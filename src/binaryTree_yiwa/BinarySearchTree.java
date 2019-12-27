package binaryTree_yiwa;

import java.util.Stack;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {
    protected BinaryNode<T> root;
    public BinarySearchTree(){
        root =null;
    }
    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public int size() {
        return size(root);
    }
    private int size(BinaryNode<T> p){
        if (p==null) return 0;
        else return size(p.left)+1+size(p.right);
    }


    @Override
    public int height() {
        return height(root);
    }
    private int height(BinaryNode<T> subTree){
        if (subTree==null) return -1;
        else {
            int l=height(subTree.left);
            int r=height(subTree.right);
            return l>r?(l+1):(r+1);
        }
    }

    @Override
    public String preOrder() {
        String sb=preOrder(root);
        if (sb.length()>0){
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }
    private String preOrder(BinaryNode<T> subtree){
        StringBuilder sb=new StringBuilder();
        if (subtree!=null) {//递归结束条件
            sb.append(subtree.data).append(",");
            //遍历左子树
            sb.append(preOrder(subtree.left));
            //遍历右子树
            sb.append(preOrder(subtree.right));
        }
        return sb.toString();

    }

    @Override
    public String inOrder() {
        String sb=inOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }
    public String inOrder(BinaryNode<T> subtree) {
        StringBuilder sb=new StringBuilder();
        if (subtree!=null) {//递归结束条件
            //先遍历左子树
            sb.append(inOrder(subtree.left));
            //再遍历根结点
            sb.append(subtree.data).append(",");
            //最后遍历右子树
            sb.append(inOrder(subtree.right));
        }
        return sb.toString();
    }
    @Override
    public String postOrder() {
        String sb=postOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }

        return sb;
    }
    public String postOrder(BinaryNode<T> subtree) {
        StringBuilder sb=new StringBuilder();
        if (subtree!=null) {//递归结束条件
            //先遍历左子树
            sb.append(postOrder(subtree.left));

            //再遍历右子树
            sb.append(postOrder(subtree.right));

            //最后遍历根结点
            sb.append(subtree.data).append(",");
        }
        return sb.toString();
    }

    /**
     * 非递归的先根遍历
     * @return
     */
    public String preOrderTraverse(){
        StringBuffer sb=new StringBuffer();
        Stack<BinaryNode<T>> l=new Stack<>();
        BinaryNode<T> p=root;
        while(p!=null||!l.empty()){
            if (p!=null){
                sb.append(p.data+",");
                l.push(p);
                p=p.left;
            }else {
                p=l.pop();
                p=p.right;
            }
        }
        if(sb.length()>0){
            return sb.toString().substring(0,sb.length()-1);
        }else {
            return sb.toString();
        }
    }
    @Override
    public String levelOrder() {
        return null;
    }

    @Override
    public void insert(T data) {

    }

    @Override
    public void remove(T data) {

    }

    @Override
    public T findMax() {
        return null;
    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public BinaryNode findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }
}
