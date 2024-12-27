public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{

    public void insert(int value) {
        if (data[0] == null) {
            data[0] = value;
            return;
        }

        int index = 0;
        while (index < data.length) {
            if (data[index] == null) {
                data[index] = value;
                return;
            } else if (value < data[index]) {
                index = getLeft(index);
            } else if (value > data[index]) {
                index = getRight(index);
            } else {
                return;
            }
        }

        if (index >= data.length) {
            resizeArray();
        }
    }

    private void resizeArray() {
        Integer[] newData = new Integer[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
