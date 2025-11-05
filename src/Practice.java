import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a");
        int a = scan.nextInt();
        if (a == 0){
            System.out.println(1);
        }
        for (int i = a - 1; i > 0 && a != 0; i -= 1){
            a *= i;
        }
        System.out.println(a);

        String[][] arr = {{"Apple", "mango", "banana"}, {"Rabbit", "tiger"}};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j].charAt(0));
            }
        }

        int[][] matrix = {{11, 12}, {21, 22}, {31, 32}, {41, 42}};

    }
}
