package Tree_yiwa;

/**
 * 二叉查找树查找过程时间复杂度为O(logN)在某种极端情况下(树的结构为单向左子树或者右子树)会上升为O(N)，因此提出了平衡二叉树（AVL）
 * https://blog.csdn.net/javazejian/article/details/53892797
 * 实上一种解决的办法就是要有一个称为平衡的附加结构条件即：任何结点的深度不得过深，而这种数据结构就是我们本篇要分析的平衡二叉树（AVL），
 * 它本身也是一种二叉查找树,
 * AVL树只是实现平衡二叉树的一种方法，它还有很多的其他实现方法如红黑树、替罪羊树、Treap、伸展树等，
 * 一棵AVL树是其每个结点的左子树和右子树的高度最多相差1的二叉查找树(空树的高度为-1)，
 * 这个差值也称为平衡因子（其取值可以是1，0，-1，平衡因子是某个结点左右子树层数的差值)
 * 无论是插入还是删除，只有那些从插入或者删除点到根结点的路径上的结点的平衡才有可能被改变，因为只有这些结点
 * 的子树才可能发生变化，所以最终也只需针对这些点进行平衡修复操作即可。
 */
public class BalancedBinaryTree_AVL<T extends Comparable> {
    private class AVLNode<T extends Comparable>{
        public AVLNode<T> left;
        public AVLNode<T> right;
        public T data;
        public int height;//当前节点的高度

        public AVLNode(T data) {
            this(null,null,data);
        }
        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data){
            this(left,right,data,0);
        }
        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data, int height) {
            this.left = left;
            this.right = right;
            this.data = data;
            this.height = height;
        }
    }
    public AVLNode<T> root;
    public boolean isEmpty(){return root==null;}
    public int size(){return size(root);}
    public int size(AVLNode<T> subtree){
        if (subtree==null)
            return 0;
        else
            return size(subtree.left)+1+size(subtree.right);
    }
    public int height(){
        return height(root);
    }
    public int height(AVLNode<T> p){
        return p==null?-1:p.height;
    }
    public String preOrder(AVLNode<T> subtree){
        StringBuilder sb=new StringBuilder();
        if (subtree!=null){
            sb.append(subtree.data).append(",");
            sb.append(preOrder(subtree.left));
            sb.append(preOrder(subtree.right));
        }
        return sb.toString();
    }
    public String inOrder(AVLNode<T> subtree){
        StringBuilder sb=new StringBuilder();
        if (subtree!=null){
            sb.append(inOrder(subtree.left));
            sb.append(subtree.data).append(",");
            sb.append(inOrder(subtree.right));
        }
        return sb.toString();
    }
    public String postOrder(AVLNode<T> subtree){
        StringBuilder sb=new StringBuilder();
        if (subtree!=null){
            sb.append(postOrder(subtree.left));
            sb.append(postOrder(subtree.right));
            sb.append(subtree.data).append(",");
        }
        return sb.toString();
    }
    public void insert(T data){
        if (data==null){
            throw new RuntimeException("data can't not be null");
        }
        this.root=insert(data,root);
    }
    public void remove(T data){
        if (data==null)
            throw new RuntimeException("data can not be null");
        this.root=remove(data,root);
    }
    private AVLNode<T> remove(T data,AVLNode<T> p){
        if (p==null)
            return null;
        int result=data.compareTo(p.data);
        //从左子树查找需要删除的元素
        if (result<0){
            p.left=remove(data,p.left);
            //检测是否平衡
            if(height(p.right)-height(p.left)==2){
                AVLNode<T> currentNode=p.right;
                //判断需要那种旋转
                if(height(currentNode.left)>height(currentNode.right)){
                    //RL
                    p=doubleRotateWithRight(p);
                }else{
                    //RR
                    p=singleRotateRight(p);
                }
            }
            //从右子树查找需要删除的元素
        }else if (result>0){
            p.right=remove(data,p.right);
            //检测是否平衡
            if(height(p.left)-height(p.right)==2){
                AVLNode<T> currentNode=p.left;
                //判断需要那种旋转
                if(height(currentNode.right)>height(currentNode.left)){
                    //LR
                    p=doubleRotateWithLeft(p);
                }else{
                    //LL
                    p=singleRotateLeft(p);
                }
            }
            //已找到需要删除的元素,并且要删除的结点拥有两个子节点
        }else if (p.right!=null&&p.left!=null){
            //寻找替换结点
            p.data=findMin(p.right).data;

            //移除用于替换的结点
            p.right = remove( p.data, p.right );
        }else {
            //只有一个孩子结点或者只是叶子结点的情况
            p=(p.left!=null)? p.left:p.right;
        }
        if (p!=null)
            p.height=Math.max(height(p.left),height(p.right))+1;
        return p;
    }
    private AVLNode<T> findMin(AVLNode<T> p){
        if (p==null)//结束条件
            return null;
        else if (p.left==null)//如果没有左结点,那么t就是最小的
            return p;
        return findMin(p.left);
    }
    private AVLNode<T> findMax(AVLNode<T> p){
        if (p==null)
            return null;
        else if (p.right==null)//如果没有右结点,那么t就是最大的
            return p;
        return findMax(p.right);
    }
    public T findMin() {
        return findMin(root).data;
    }
    public T findMax() {
        return findMax(root).data;
    }
    private AVLNode<T> insert(T data,AVLNode<T> p){
        if (p==null)
            p=new AVLNode<T>(data);
        int result=data.compareTo(p.data);
        if (result<0){
            p.left=insert(data,p.left);
            //插入后计算子树的高度,等于2则需要重新恢复平衡,由于是左边插入,左子树的高度肯定大于等于右子树的高度
            if (height(p.left)-height(p.right)==2){
                if (data.compareTo(p.left.data)<0){
                    p=singleRotateLeft(p);
                }else {
                    p=doubleRotateWithLeft(p);
                }
            }
        }else if (result>0){
            p.right=insert(data,p.right);

            if(height(p.right)-height(p.left)==2){
                if (data.compareTo(p.right.data)<0){
                    //进行右左旋转
                    p=doubleRotateWithRight(p);
                }else {
                    p=singleRotateRight(p);
                }
            }
        }else ;
        p.height=Math.max(height(p.left),height(p.right))+1;
        return p;
    }

    /**
     * ① 在结点X的左孩子结点的左子树中插入元素
     * ② 在结点X的左孩子结点的右子树中插入元素
     * ③ 在结点X的右孩子结点的左子树中插入元素
     * ④ 在结点X的右孩子结点的右子树中插入元素
     * @param x
     * @return
     */
    //左左单旋转
    private AVLNode<T> singleRotateLeft(AVLNode<T> x){
        AVLNode<T> w=x.left;
        x.left=w.right;
        w.right=x;
        x.height=Math.max(height(x.left),height(x.right))+1;
        w.height=Math.max(height(w.left),height(w.right))+1;
        return w;
    }
    //右右单旋转
    private AVLNode<T> singleRotateRight(AVLNode<T> x){
        AVLNode<T> w=x.right;
        x.right=w.left;
        w.left=x;
        x.height=Math.max(height(x.left),height(w.left))+1;
        w.height=Math.max(height(w.left),height(w.right))+1;
        return w;
    }
    //左右旋转
    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> x){
        x.left=singleRotateRight(x.left);
        return singleRotateLeft(x);
    }
    //右左旋转
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> x){
        x.right=singleRotateLeft(x.right);
        return singleRotateRight(x);
    }
    private void printTree(AVLNode<T> t){
        if (t!=null){
            printTree(t.left);
            System.out.print(t.data+"->");
            printTree(t.right);
        }
    }
    public void clear() {
        this.root=null;
    }

    public static void main(String[] args) {
        BalancedBinaryTree_AVL<Integer> avlTree=new BalancedBinaryTree_AVL<>();
        for (int i=0;i<1800;i++){
            avlTree.insert(i);
        }
        avlTree.printTree(avlTree.root);
        System.out.println("前序遍历："+avlTree.preOrder(avlTree.root));
    }
}
