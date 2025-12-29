package tirgul10;

public class BST extends BT{

    @Override
    public void insert(Node n) {
        root = insert(root, n);
    }

    private static Node insert(Node parent, Node newNode) {
        if (parent == null) return newNode;
        if (parent.getID() == newNode.getID()) {
            parent.overWriteFrom(newNode);
            return parent;
        }
        if (newNode.getID() < parent.getID()) parent.setLeft(insert(parent.getLeft(), newNode));
        else parent.setRight(insert(parent.getRight(), newNode));
        return parent;
    }

    @Override
    public void insert(String data) {
        root = insert(root, data);
    }

    private static Node insert(Node n, String data) {
        if (n == null) return new Node(data);
        if (n.getID() == data.hashCode()) {
            n.setData(data);
            return n;
        }
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
