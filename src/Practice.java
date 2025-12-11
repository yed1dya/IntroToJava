public class Practice {
    public static void main(String[] args) {
        f();
        f(1);
    }

    public static void f(){
        System.out.println("f");
    }

    public static void f(int a){
        System.out.println(a);
    }

    public static void f(String s){
        System.out.println(s);
    }

}
