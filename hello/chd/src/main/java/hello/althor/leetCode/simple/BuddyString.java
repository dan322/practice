package hello.althor.leetCode.simple;

public class BuddyString {

    /**
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
     * 就返回 true ；否则返回 false 。
     *
     * 提示：
     *      0 <= A.length <= 20000
     *      0 <= B.length <= 20000
     *      A 和 B 仅由小写字母构成。
     * @param args
     */
    public static void main(String[] args)
    {
        BuddyString buddyString = new BuddyString();
        Long start = System.currentTimeMillis();
        String a = "ab";  //aaaaaaabc
        String b = "ba";  //aaaaaaacb
        boolean result = buddyString.solution(a, b);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public boolean solution(String A, String B)
    {
        //todo ann

        return false;
    }
}
