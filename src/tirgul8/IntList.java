package tirgul8;

public class IntList {
    IntNode head;

    public void reverse() {
        IntNode prev = null;
        IntNode curr = head;
        while (curr != null) {
            IntNode nextNode = curr.getNext(); // Save next node
            curr.setNext(prev);                // Reverse pointer
            prev = curr;                       // Advance prev
            curr = nextNode;                   // Advance curr
        }
        head = prev; // Update head to the new front
    }

    public void reverseRec() {
        head = reverseRecHelp(head);
    }

    private IntNode reverseRecHelp(IntNode current) {
        // Base Case: If the list is empty or has only one node, it is already reversed.
        // We return 'current' because it will become the new head of the list.
        if (current == null|| current.next == null) {
            return current;
        }

        // Recursive Step: Reverse the rest of the list starting from the next node.
        // 'newHead' will eventually bubble up the reference to the last node (the new head).
        IntNode newHead = reverseRecHelp(current.next);

        // current.getNext() is still pointing to the next node.
        // We use that pointer to set the next node's next pointer back to current.
        current.getNext().setNext(current);

        // We set our own next to null, otherwise we might create a cycle
        // (this will be overwritten in the next recursive call, unless we are the original first node).
        current.setNext(null);

        return newHead;
    }

    
    
    public IntList copyBigger(int n) {
        IntList newList = new IntList();
        newList.head = copyBiggerRecursive(head, n);
        return newList;
    }

    // Private helper
    private IntNode copyBiggerRecursive(IntNode p, int n) {
        if (p == null) return null;

        // Recursive call first (processing rest of list)
        IntNode nextNodes = copyBiggerRecursive(p.getNext(), n);

        // If current satisfies condition, create node and link to result
        if (p.getValue() > n) {
            return new IntNode(p.getValue(), nextNodes);
        } else {
            // Skip this node, return the result of the rest
            return nextNodes;
        }
    }

}
