package Tree_yiwa;
//https://www.cnblogs.com/yahuian/p/10813614.html
public class BinarySearchTree {
    //节点类
    private class Node{
        int data;
        Node right;
        Node left;
    }
    private Node root;//根节点
    //插入数据（创建树）
    public void insert(int value){
        //先初始化待插入的节点，再通过两个指针parent和current遍历二叉树找到要插入的位置
        Node p=new Node();
        p.data=value;
        if (null==root){
            root=p;
        }else {
            Node parent=new Node();
            Node current=root;
            while (true){
                parent=current;
                if (value>parent.data){
                    current=current.right;
                    if (current==null){
                        parent.right=p;
                        return;
                    }
                }else {
                    current=current.left;
                    if (current==null){
                        parent.left=p;
                        return;
                    }
                }
            }
        }
    }
    /**遍历指的是按照某种特定的次序来访问二叉搜索树中的每个节点，主要有三种遍历的方法：
     *前序遍历，“中左右”
     *中序遍历，“左中右”
     *后续遍历，“左右中”
     *///https://blog.csdn.net/lusa1314/article/details/87267349
    //前序遍历
    public void preOrder(Node root){
        if (root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //中序遍历
    public void inOrder(Node root){
        if (root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    //后续遍历
    public void postOrder(Node root){
        if (root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
    //选择以何种那个方式遍历
    public void traverse(int type){
        switch (type){
            case 1:
                System.out.println("前序遍历");
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.println("中序遍历");
                inOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.println("后续遍历");
                postOrder(root);
                System.out.println();
                break;
        }

    }
    //根据值查找节点
    public Node find(int data){//时间复杂度时间复杂度为O(logN)
        Node current=root;
        while (current.data!=data){
            if (data>current.data)
                current=current.right;
            if (data<current.data)
                current=current.left;
        }
        return current;
    }
    public void show(Node node){
        if(node!=null)
            System.out.println(node.data);
        else
            System.out.println("null");
    }
    //删除节点
    //https://www.cnblogs.com/yahuian/p/10813614.html
    /**
     * 1.删除节点有零个孩子，只需parent.left(parent.right)设置为null java垃圾回收机制自动删除current节点
     * 2.删除节点有一个孩子，只需将parent.left(parent.right)设置为curent.left(curent.right)即可
     *     （思考：要删除节点只有一个左(右)子节点，那么以子节点构成的子树中的数据都小于(大于)当前删除的节点
     *           所以直接用父节点指向子树）
     * 3.删除的节点有两个孩子，（如果将一棵二叉树按照中序遍历的方式输出，即一个从小到大的数组 ，那么删除了当前节点，
     *  可以用左右任意一个节点值替换）
     */
    private Node getSuccessor(Node deleNode){
        Node successorParent=deleNode;
        Node successor=deleNode;
        Node currrent=deleNode.right;//也可以按照left的逻辑走这个算法
        while(currrent!=null) {//寻找替代节点,找到刚好在删除节点右边的值最相近的临界值
                               //以及他的父节点
          successorParent=successor;
          successor=currrent;
          currrent=currrent.left;
        }
        //如果此节点为要删除的节点的右子树的左子，调节
        if (successor!=deleNode.right){
            successorParent.left=successor.right;
            successor.right=deleNode.right;
        }
        return successor;//用来替换删除的节点的节点
    }
    public boolean delete(int data){
        Node current=root;
        Node parent=new Node();
        boolean isRightChild=true;
        while (current.data!=data){ //找到要删除的节点current，
            parent=current;
            if (data>current.data){
                current=current.right;
                isRightChild=true;
            }else {
                current=current.left;
                isRightChild=false;
            }
            if (current==null) return false;
        }
        //此时要删除的节点current 其父节点为parent
        //1.要删除的节点为叶子节点，即有零个孩子
        if (current.left==null&&current.right==null){
            if (current==root){
                root=null;//整棵树清空
            }
            else {
                if (isRightChild)
                    parent.right=null;
                else
                    parent.left=null;
            }
            return true;
        }
        //2.要删除结点有一个右子结点
        else if (current.left==null){
            if (current==root){
                root=current.right;
            }else if (isRightChild){
                parent.right=current.right;
            }else
                parent.left=current.right;
            return true;
        }
        //要删除节点只有一个左子节点
        else if (current.right==null){
            if (current==root){
                root=current.left;
            }else if (isRightChild){
                parent.right=current.left;
            }else
                parent.left=current.left;
            return true;
        }
        else //要删除节点有两个子节点
        {
            Node successor=getSuccessor(current);//从删除节点开始找可以替代 删除节点的节点
            if(current==root){
                root=successor;
            }else if (isRightChild){
                parent.right=successor;
            }else
                parent.left=successor;
            successor.left=current.left;
            return true;
        }

    }
}
