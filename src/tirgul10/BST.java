package tirgul10;

public class BST extends BT{

    @Override
    public void insert(String data) {
        root = insert(root, data);
    }

    private static Node insert(Node n, String data) {
        if (n == null || n.getID() == data.hashCode()) return new Node(data);
        if (data.hashCode() < n.getID()) n.setLeft(insert(n.getLeft(), data));
        else n.setRight(insert(n.getRight(), data));
        return n;
    }

    public Node find(int value) {
        return find(this.root, value);
    }

    private static Node find(Node n, int value) {
        if (n == null || n.getID() == value) return n;
        if (value < n.getID()) return find(n.getLeft(), value);
        return find(n.getRight(), value);
    }

    public void delete(int ID) {
        delete(root, ID);
    }

    private static Node delete(Node n, int ID) {
        if (n == null) return null;
        if (ID < n.getID()) n.setLeft(delete(n.getLeft(), ID));
        else if (ID > n.getID()) n.setRight(delete(n.getRight(), ID));
        else {
            if (n.getLeft() == null) return n.getRight();
            if (n.getRight() == null) return n.getLeft();
            Node successor = n.successor();
            n.overWriteFrom(successor);
            n.setRight(delete(n.getRight(), successor.getID()));
        }
        return n;
    }
}
