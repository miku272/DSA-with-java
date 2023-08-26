import java.util.Queue;
import java.util.LinkedList;

class Info {
    public int diameter;
    public int height;

    public Info() {
    }

    public Info(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

class Node {
    private int data;
    private Node left;
    private Node right;

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

    public void setLeftNode(Node left) {
        this.left = left;
    }

    public Node getLeftNode() {
        return this.left;
    }

    public void setRightNode(Node right) {
        this.right = right;
    }

    public Node getRightNode() {
        return this.right;
    }
}

class BinaryTree {
    private int index = -1;

    public Node buildTree(int[] nodes) {
        this.index++;

        if (nodes[this.index] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[this.index]);
        newNode.setLeftNode(buildTree(nodes));
        newNode.setRightNode(buildTree(nodes));

        return newNode;
    }

    public void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getData() + " ");
        preorderTraversal(root.getLeftNode());
        preorderTraversal(root.getRightNode());
    }

    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.getLeftNode());
        System.out.print(root.getData() + " ");
        inorderTraversal(root.getRightNode());
    }

    public void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.getLeftNode());
        postorderTraversal(root.getRightNode());
        System.out.print(root.getData() + " ");
    }

    public void levelorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.print("\n");

                if (!q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.getData() + " ");

                if (currNode.getLeftNode() != null) {
                    q.add(currNode.getLeftNode());
                }

                if (currNode.getRightNode() != null) {
                    q.add(currNode.getRightNode());
                }
            }
        }
    }

    public int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeHeight(root.getLeftNode()) + 1, treeHeight(root.getRightNode()) + 1);
    }

    public int nodeCount(Node root) {
        if (root == null) {
            return 0;
        }

        return (nodeCount(root.getLeftNode()) + nodeCount(root.getRightNode())) + 1;
    }

    public int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return (sumOfNodes(root.getLeftNode()) + sumOfNodes(root.getRightNode())) + root.getData();
    }

    // Diameter of a tree is defined as the number of nodes in the longest path
    // between any 2 leaves
    public int treeDiameter(Node root) { // O(n^2)
        if (root == null) {
            return 0;
        }

        int leftDiameter = treeDiameter(root.getLeftNode());
        int leftHeight = treeHeight(root.getLeftNode());

        int rightDiameter = treeDiameter(root.getRightNode());
        int rightHeight = treeHeight(root.getRightNode());

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public Info optimizedTreeDiameter(Node root) { // O(n)
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = optimizedTreeDiameter(root.getLeftNode());
        Info rghtInfo = optimizedTreeDiameter(root.getRightNode());

        int selfDiameter = Math.max(leftInfo.height + rghtInfo.height + 1,
                Math.max(leftInfo.diameter, rghtInfo.diameter));
        int selfHeight = Math.max(leftInfo.height, rghtInfo.height) + 1;

        return new Info(selfDiameter, selfHeight);
    }
}

public class BInaryTreeCodes {
    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        // System.out.println(root.getData());

        // tree.preorderTraversal(root);
        // tree.inorderTraversal(root);
        // tree.postorderTraversal(root);
        // tree.levelorderTraversal(root);

        // System.out.println("Height of the tree is: " + tree.treeHeight(root));
        // System.out.println("Number of nodes in the tree: " + tree.nodeCount(root));
        // System.out.println("Sum of nodes: " + tree.sumOfNodes(root));
        // System.out.println("Maximum diameter: " + tree.treeDiameter(root));
        System.out.println("Maximum diameter: " + tree.optimizedTreeDiameter(root).diameter);
    }
}
