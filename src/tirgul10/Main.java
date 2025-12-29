package tirgul10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random(42);

        BST tree = new BST();

        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(10, 100);
            System.out.println("inserting " + r + ", ID: " + String.valueOf(r).hashCode());
            tree.insert(String.valueOf(r));
            tree.displayTree();
        }

        System.out.println("\nprinting in order:");
        tree.printInOrder();
        System.out.println("\n");

        System.out.println("deleting 1669");
        tree.delete(1669);
        tree.displayTree();

        System.out.println("deleting 1669");
        tree.delete(1669);
        tree.displayTree();

        System.out.println("deleting 1602");
        tree.delete(1602);
        tree.displayTree();
    }
}
