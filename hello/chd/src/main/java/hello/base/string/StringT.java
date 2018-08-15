package hello.base.string;

public class StringT {
    public static void main(String[] args) {
        String str = new String("123");
        change(str);
        System.out.println(str);
    }

    public static void change(String str) {
        str = "234";
    }
}
