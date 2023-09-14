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

    public static Node findInorderSuccessor(Node root) {
        while (root.getLeftNode() != null) {
            root = root.getLeftNode();
        }

        return root;
    }

    public static Node deleteNodeInBST(Node root, int value) {
        if (root.getData() < value) {
            root.setRightNode(deleteNodeInBST(root.getRightNode(), value));
        } else if (root.getData() > value) {
            root.setLeftNode(deleteNodeInBST(root.getLeftNode(), value));
        } else {
            if (root.getLeftNode() == null && root.getRightNode() == null) {
                return null;
            }

            if (root.getLeftNode() == null) {
                return root.getRightNode();
            } else if (root.getRightNode() == null) {
                return root.getLeftNode();
            }

            Node inorderSuccessor = findInorderSuccessor(root.getRightNode());

            root.setData(inorderSuccessor.getData());

            root.setRightNode(deleteNodeInBST(root.getRightNode(), inorderSuccessor.getData()));
        }

        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.getData() >= k1 && root.getData() <= k2) {
            printInRange(root.getLeftNode(), k1, k2);
            System.out.print(root.getData() + " ");
            printInRange(root.getRightNode(), k1, k2);
        } else if (root.getData() < k1) {
            printInRange(root.getLeftNode(), k1, k2);
        } else {
            printInRange(root.getRightNode(), k1, k2);
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
        // int[] values = { 5, 1, 3, 4, 2, 7 };
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insertIntoBST(root, values[i]);
        }

        // inorderTraversal(root);

        // System.out.println(searchBST(root, 0));

        printInRange(root, 5, 12);
    }
}