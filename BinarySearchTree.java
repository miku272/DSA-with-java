class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getLeftNode() {
        return this.leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getRightNode() {
        return this.rightNode;
    }
}

public class BinarySearchTree {
    public static Node insertIntoBST(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (root.getData() > value) {
            root.setLeftNode(insertIntoBST(root.getLeftNode(), value));
        } else {
            root.setRightNode(insertIntoBST(root.getRightNode(), value));
        }

        return root;
    }

    public static boolean searchBST(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.getData() == value) {
            return true;
        }

        if (root.getData() > value) {
            return searchBST(root.getLeftNode(), value);
        } else {
            return searchBST(root.getRightNode(), value);
        }
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.getLeftNode());
        System.out.print(root.getData() + " ");
        inorderTraversal(root.getRightNode());
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insertIntoBST(root, values[i]);
        }

        // inorderTraversal(root);

        System.out.println(searchBST(root, 0));
    }
}