package hello.althor.leetCode.simple;

public class StrstrSolution {

    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        StrstrSolution strstrSolution = new StrstrSolution();
        String haystack = "";
        String needle = "";
        int index = strstrSolution.strStr(haystack, needle);
        System.out.println(index);
        System.out.println(System.currentTimeMillis() - start);
    }

    public int strStr(String haystack, String needle) {
        if (needle == "") return 0;
        int index = -1;

        return index;
    }

}
