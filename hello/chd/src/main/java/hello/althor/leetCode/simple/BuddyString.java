package hello.althor.leetCode.simple;

public class BuddyString {

    /**
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
     * 就返回 true ；否则返回 false 。
     *
     * 示例 1：
     *
     * 输入： A = "ab", B = "ba"
     * 输出： true
     * 示例 2：
     *
     * 输入： A = "ab", B = "ab"
     * 输出： false
     * 示例 3:
     *
     * 输入： A = "aa", B = "aa"
     * 输出： true
     * 示例 4：
     *
     * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
     * 输出： true
     * 示例 5：
     *
     * 输入： A = "", B = "aa"
     * 输出： false
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
        String a = "baacaeaa";  //aaaaaaabc
        String b = "baaceaaa";  //aaaaaaacb
        boolean result = buddyString.solution1(a, b);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    /**
     *  if A not equal B, then can must change once, other letter must be same
     *  if A equal B, then must have a letter consistently occur twice times or more
     * @param A
     * @param B
     * @return
     */
    public boolean solution(String A, String B)
    {
        if (A.length() != B.length() || A.length() < 2)
            return false;
        char prevCharA = 0;
        boolean consistentSame = false, isChangeOnce = false;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                if (A.charAt(i) == prevCharA) {
                    consistentSame = true;
                } else {
                    prevCharA = A.charAt(i);
                }
            } else if (!isChangeOnce && A.charAt(i) == B.charAt(i + 1) && A.charAt(i + 1) == B.charAt(i)) {
                isChangeOnce = true;
                i++;
            } else {
                return false;
            }
        }
        return consistentSame || isChangeOnce;
    }

    public boolean solution1(String A, String B)
    {
        if (A.length() != B.length() || A.length() < 2)
            return false;
        int i;
        char prevChar;
        if (A == B) {
            prevChar = A.charAt(0);
            for (i = 1; i < A.length(); i++) {
                if (A.charAt(i) == prevChar) {
                    return true;
                } else {
                    prevChar = A.charAt(i);
                }
            }
        } else {
            char[] chars = A.toCharArray();
            for (i = 0; i < chars.length; i++) {
                if (chars[i] != B.charAt(i)) {
                    prevChar = chars[i];
                    chars[i] = chars[i + 1];
                    chars[i + 1] = prevChar;
                    return B.equals(String.valueOf(chars));
                }
            }
        }
        return false;
    }
}
