package binaryTree_yiwa;

public class BinaryNode<T extends Comparable> {
    T data;
    BinaryNode<T> left;
    BinaryNode<T> right;
    public BinaryNode(T data,BinaryNode left,BinaryNode right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public BinaryNode(T data){
        this(data,null,null);

    }
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }//判断是否为叶子结点
}
