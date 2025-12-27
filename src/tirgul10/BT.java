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
        return Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // Source: https://github.com/camluca/Samples/blob/4954a1ad1d9b034abbd3c23c4581324fb6b8fa57/Tree.java
    public void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int emptyLeaf = 32;
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
        System.out.println("****......................................................****");
    }


}
