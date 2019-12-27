package binaryTree_yiwa;

public interface Tree <T extends Comparable>{
    boolean isEmpty();
    int size();//二叉树的结点个数
    int height();//返回二叉树的高度或者深度,即结点的最大层次
    String preOrder();
    String inOrder();
    String postOrder();
    String levelOrder();//层次遍历
    void insert(T data);
    void remove(T data);
    T findMax();
    T findMin();
    BinaryNode findNode(T data);
    boolean contains(T data) throws Exception;
    void clear();
}
