import tirgul10.BST;
import tirgul10.BT;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random(42);

        BST tree = new BST();

        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(1, 100);
            System.out.println("inserting " + r + ", ID: " + String.valueOf(r).hashCode());
            tree.insert(String.valueOf(r));
            System.out.println("size: " + tree.size());
            tree.displayTree();
        }

        System.out.println();
        tree.printInOrder();
        System.out.println();

        tree.delete(1669);
        System.out.println("\nsize: " + tree.size());
        tree.displayTree();

        tree.delete(1669);
        System.out.println("\nsize: " + tree.size());
        tree.displayTree();

        tree.delete(1602);
        System.out.println("\nsize: " + tree.size());
        tree.displayTree();
    }
}
