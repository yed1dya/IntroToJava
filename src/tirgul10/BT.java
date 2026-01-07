package tirgul10;

import java.util.Stack;

public class BT {

    protected Node root;

    public BT(Node root) {
        this.root = root;
    }

    public BT() {
        this(null);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int size() {
        return Node.size(root);
    }

    public void insert(Node n) {
        root = insert(root, n);
    }

    private static Node insert(Node root, Node newNode) {
        if (root == null) return newNode;
        if (Math.random() < 0.5) root.setLeft(insert(root.getLeft(), newNode));
        else root.setRight(insert(root.getRight(), newNode));
        return root;
    }

    public void insert(String data) {
        root = insert(root, data);
    }

    private static Node insert(Node n, String data) {
        if (n == null) return new Node(data);
        if (Math.random() < 0.5) n.setLeft(insert(n.getLeft(), data));
        else n.setRight(insert(n.getRight(), data));
        return n;
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    private static void printInOrder(Node n) {
        if (n == null) return;
        printInOrder(n.getLeft());
        System.out.print(n.getID() + "  ");
        printInOrder(n.getRight());
    }

    public int depth() {
        return depth(root);
    }

    private static int depth(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    public int numOfLeaves() {
        return numOfLeaves(root);
    }

    private static int numOfLeaves(Node n) {
        if (n == null) return 0;
        if (n.isLeaf()) return 1;
        return numOfLeaves(n.getLeft()) + numOfLeaves(n.getRight());
    }

    public int leavesInLevelRec(int level) {
        if (level < 0) return 0;
        return leavesInLevelRec(root, level);
    }

    private static int leavesInLevelRec(Node n, int level) {
        if (n == null) return 0;
        if (level == 0) return n.isLeaf() ? 1 : 0;
        return leavesInLevelRec(n.getLeft(), level - 1) +
                leavesInLevelRec(n.getRight(), level - 1);
    }

    public int levelWithMaxLeaves() {
        if (root == null) return -1;
        int maxLeaves = 0, maxLeavesLevel = -1;
        for (int i = 0; i < depth(); i++) {
            int leavesInCurrentLevel = leavesInLevelRec(i);
            if (leavesInCurrentLevel > maxLeaves) {
                maxLeaves = leavesInCurrentLevel;
                maxLeavesLevel = i;
            }
        }
        return maxLeavesLevel;
    }

    public int maxLevelWithNoLeaves() {
        if (root == null) return -1;
        int maxNoLeavesLevel = -1;
        for (int i = 0; i < depth(); i++) {
            int leavesInCurrentLevel = leavesInLevelRec(i);
            if (leavesInCurrentLevel == 0) {
                maxNoLeavesLevel = i;
            }
        }
        return maxNoLeavesLevel;
    }

    public String longestPath() {
        if (root == null || root.isLeaf()) return "";
        String path = longestPath(root);
        return path.substring(0, path.length() - 3);
    }

    private static String longestPath(Node n) {
        if (n == null) return "";
        if (n.isLeaf()) return "--";
        String longestPathLeft = longestPath(n.getLeft()),
                longestPathRight = longestPath(n.getRight());
        if (longestPathLeft.length() >= longestPathRight.length()) {
            return "L-" + longestPathLeft;
        }
        return "R-" + longestPathRight;
    }

    // Source: https://github.com/camluca/Samples/blob/4954a1ad1d9b034abbd3c23c4581324fb6b8fa57/Tree.java
    public void displayTree() {
        System.out.println("size: " + size());
        System.out.println("depth: " + depth());
        System.out.println("number of leaves in tree: " + numOfLeaves());
        System.out.println("longest path: " + longestPath());
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int emptyLeaf = 64;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while(!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for(int j = 0; j < emptyLeaf; j++) System.out.print(' ');
            while(!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.getID());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if(temp.getLeft() != null || temp.getRight() != null) isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j = 0; j < emptyLeaf * 2 - 2; j++) System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while(!localStack.isEmpty()) globalStack.push(localStack.pop());
        }
        System.out.println("****......................................................****\n");
    }


}
