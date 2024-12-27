import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode n, int value) {
        if (n == null) {
            return new TreeNode(value);
        }

        if (value < n.data) {
            n.left = insertRec(n.left, value);
        } else if (value > n.data) {
            n.right = insertRec(n.right, value);
        }

        return n;
    }

    public boolean find(int value) {
        return findBSTRec(root, value);
    }

    private boolean findBSTRec(TreeNode n, int value) {
        if (n == null) {
            return false;
        }

        if (n.data == value) {
            return true;
        } else if (value < n.data) {
            return findBSTRec(n.left, value);
        } else {
            return findBSTRec(n.right, value);
        }
    }

    public int getMax() throws TreeEmptyException {
        if (root == null) {
            throw new TreeEmptyException();
        }

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.data;
    }

    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);
    }
}
