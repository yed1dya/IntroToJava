package tirgul8;

public class IntNode {
    int value;
    IntNode next;

    public IntNode(int value, IntNode nextNode) {
        this.value = value;
        this.next = nextNode;
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }
}
