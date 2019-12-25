package Tree_yiwa;

import org.junit.Test;

public class Test_binarySearchTree {
    @Test
    public void test() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(39);
        binarySearchTree.insert(24);
        binarySearchTree.insert(23);
        binarySearchTree.insert(30);
        binarySearchTree.insert(26);
        binarySearchTree.insert(27);
        binarySearchTree.insert(25);
        binarySearchTree.insert(35);
        binarySearchTree.insert(60);
        binarySearchTree.insert(64);
        binarySearchTree.insert(53);
        binarySearchTree.insert(70);
        binarySearchTree.insert(75);
        binarySearchTree.insert(72);
        binarySearchTree.traverse(1);
        binarySearchTree.traverse(2);
        binarySearchTree.traverse(3);
        binarySearchTree.delete(24);
        binarySearchTree.traverse(2);
        binarySearchTree.delete(25);
        binarySearchTree.traverse(2);
    }
}
