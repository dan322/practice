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
     * A = "abab", B = "abab"
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
        String a = "ab";  //aaaaaaabc   baacaeaa  abab  abcd
        String b = "ab";  //aaaaaaacb   baaceaaa  abab  cbad
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
        boolean[] existChars = new boolean[26];
        boolean consistentSame = false, isChangeOnce = false;
        int index = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                if (existChars[A.charAt(i) - 97]) {
                    consistentSame = true;
                } else {
                    existChars[A.charAt(i) - 97] = true;
                }
            } else if (!isChangeOnce){
                if (-1 == index) {
                    index = i;
                } else if (A.charAt(index) == B.charAt(i) && A.charAt(i) == B.charAt(index)) {
                    isChangeOnce = true;
                } else {
                    return false;
                }
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
        int i, index = -1;
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
                    if (-1 == index) {
                         index = i;
                    } else {
                        prevChar = chars[i];
                        chars[i] = chars[index];
                        chars[index] = prevChar;
                    }
                    return B.equals(String.valueOf(chars));
                }
            }
        }
        return false;
    }


    public boolean solution2(String A, String B) {
        if(A.length() != B.length() || A.length() == 0 || B.length() ==0){
            return false;
        }
        if(A.equals(B)){
            for(int i=0;i<A.length();i++){
                String temp = String.valueOf(A.charAt(i));
                if(A.indexOf(temp) != A.lastIndexOf(temp)){
                    return true;
                }
            }
            return false;
        }else{
            char[] a = A.toCharArray();
            char[] b = B.toCharArray();
            char other1A =a[1];
            char other1B =b[1];
            char other2A =a[1];
            char other2B =b[1];
            int flag = 0;
            for(int i=0;i<a.length;i++){
                if(a[i] != b[i]){
                    flag++;
                    if(flag == 1){
                        other1A = a[i];
                        other1B = b[i];
                    }else if(flag == 2){
                        other2A = a[i];
                        other2B = b[i];
                    }else if(flag > 2){
                        return false;
                    }
                }

            }
            if(other1A == other2B && other1B == other2A && flag == 2){
                return true;
            }else{
                return false;
            }
        }
    }


    public boolean solution3(String A, String B)
    {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            //等字符串的情况，查找有无重复字符
            boolean[] boo = new boolean[26];
            for (int i = 0; i < A.length(); i++) {
                if (!boo[A.charAt(i) - 'a']) {
                    boo[A.charAt(i) - 'a'] = true;
                } else {
                    return true;
                }
            }
        } else {//不等字符串的情况，查找是否只有两处不同且两处可调换
            int[] index = new int[2];
            int count = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (count == 2) return false;
                    index[count++] = i;
                }
            }
            if (count == 2) {
                return (A.charAt(index[0]) == B.charAt(index[1])) &&
                        (A.charAt(index[1]) == B.charAt(index[0]));
            }
        }
        return false;
    }
}
