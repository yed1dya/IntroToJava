package tirgul10;

public class Node {
    private int ID;
    private String data;
    private Node left, right;

    public Node(String data, Node left, Node right) {
        this.ID = data.hashCode();
        this.left = left;
        this.right = right;
    }

    public Node(String data) {
        this(data, null, null);
    }

    public Node() {
        this("");
    }

    public void overWriteFrom(Node other) {
        this.data = other.data;
        this.ID = other.ID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public static int size(Node n) {
        if (n == null) return 0;
        return size(n.left) + size(n.right) + 1;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node successor() {
        Node current = this.right;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }
}
