import java.util.ArrayList;
import java.util.Queue;
import java.util.HashMap;
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

class HDInfo {
    Node node;
    int hD;

    public HDInfo() {
    }

    public HDInfo(Node node, int hD) {
        this.node = node;
        this.hD = hD;
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

    public boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.getData() != subRoot.getData()) {
            return false;
        }

        if (!isIdentical(node.getLeftNode(), subRoot.getLeftNode())) {
            return false;
        }

        if (!isIdentical(node.getRightNode(), subRoot.getRightNode())) {
            return false;
        }

        return true;
    }

    public boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.getData() == subRoot.getData()) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.getLeftNode(), subRoot) || isSubTree(root.getRightNode(), subRoot);
    }

    public void treeTopView(Node root) {
        Queue<HDInfo> q = new LinkedList<HDInfo>();
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        int min = 0, max = 0;

        q.add(new HDInfo(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            HDInfo currInfo = q.remove();

            if (currInfo == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(currInfo.hD)) {
                    map.put(currInfo.hD, currInfo.node);
                }

                if (currInfo.node.getLeftNode() != null) {
                    q.add(new HDInfo(currInfo.node.getLeftNode(), currInfo.hD - 1));

                    min = Math.min(min, currInfo.hD - 1);
                }

                if (currInfo.node.getRightNode() != null) {
                    q.add(new HDInfo(currInfo.node.getRightNode(), currInfo.hD + 1));

                    max = Math.max(max, currInfo.hD + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).getData() + " ");
        }
    }

    public void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.getData() + " ");
            return;
        }

        kthLevel(root.getLeftNode(), level + 1, k);
        kthLevel(root.getRightNode(), level + 1, k);
    }

    public boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.getData() == n) {
            return true;
        }

        boolean foundLeft = getPath(root.getLeftNode(), n, path);
        boolean foundRight = getPath(root.getRightNode(), n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public Node lowestCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<Node>();
        ArrayList<Node> path2 = new ArrayList<Node>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;

        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i - 1);
        return lca;
    }

    public int kthAncestorOfNode(Node root, int node, int k) {
        if (root == null) {
            return -1;
        }

        if (root.getData() == node) {
            return 0;
        }

        int leftDist = kthAncestorOfNode(root.getLeftNode(), node, k);
        int rightDist = kthAncestorOfNode(root.getRightNode(), node, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k) {
            System.out.println(root.getData());
        }

        return max + 1;
    }

    public int transformToSumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSide = transformToSumTree(root.getLeftNode());
        int rightSide = transformToSumTree(root.getRightNode());

        int selfSum = (leftSide + rightSide);

        System.out.print(selfSum + " ");

        if (selfSum != 0) {
            return selfSum;
        }

        return root.getData();
    }
}

public class BinaryTreeCodes {
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
        // System.out.println("Maximum diameter: " +
        // tree.optimizedTreeDiameter(root).diameter);

        // Node subRoot = new Node(2);
        // subRoot.setLeftNode(new Node(4));
        // subRoot.setRightNode(new Node(5));

        // System.out.println(tree.isSubTree(root, subRoot));

        // tree.treeTopView(root);

        // tree.kthLevel(root, 1, 3);

        // System.out.println(tree.lowestCommonAncestor(root, 4, 6).getData());

        // tree.kthAncestorOfNode(root, 5, 2);

        tree.transformToSumTree(root);
    }
}
