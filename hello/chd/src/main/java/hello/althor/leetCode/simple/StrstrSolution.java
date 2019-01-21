package hello.althor.leetCode.simple;

public class StrstrSolution {

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     * @param args
     */
    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        StrstrSolution strstrSolution = new StrstrSolution();
        String haystack = "hello world";
        String needle = "w";
        int index = strstrSolution.strStr(haystack, needle);
        System.out.println(index);
        System.out.println(System.currentTimeMillis() - start);
    }


    public int strStr(String haystack, String needle) {
        if (needle == "") return 0;
        int[] needle_pre = new int[128];
        char[] needle_chars = needle.toCharArray();
        char[] haystack_chars = haystack.toCharArray();
        for (int j = needle.length(), charInt; j > 0; j--) {
            charInt = needle_chars[j-1];
            if (needle_pre[charInt] > 0) continue;
            needle_pre[charInt] = j;
        }
        int i = 0;
        boolean is_needle;
        while (i <= haystack.length() - needle.length()) {
            is_needle = true;
            for (int j = 0; j < needle.length(); j++) {
                if (needle_chars[j] != haystack_chars[i + j]) {
                    i = i + needle.length() - needle_pre[haystack_chars[i + needle.length()]] + 1;
                    is_needle = false;
                    break;
                }
            }
            System.out.println(i);
            if (is_needle) return  i;
        }
        return -1;
    }
}
