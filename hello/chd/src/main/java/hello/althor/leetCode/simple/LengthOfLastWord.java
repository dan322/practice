package hello.althor.leetCode.simple;

public class LengthOfLastWord {

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     *
     * 如果不存在最后一个单词，请返回 0 。
     *
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * @param args
     */
    public static void main(String[] args)
    {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        Long start = System.currentTimeMillis();
//        String s = "Hello world ";
        String s = "a        ";
        int length = lengthOfLastWord.solution(s);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(length);
    }

    public int solution(String s)
    {
        int length = 0;
        for (int i = s.length(); i > 0;) {
            if (' ' == s.charAt(--i)) {
                if (length == 0) continue;
                return length;
            }
            length++;
        }
        return length;
    }

    public int solution1(String s)
    {
        int pos = s.length() - 1;
        int end = -1;
        while(pos >= 0){
            if(s.charAt(pos) == ' ')
                --pos;
            else{
                end = pos;
                break;
            }
        }
        if(end == -1)
            return 0;
        while(--pos >= 0){
            if(s.charAt(pos) == ' ')
                break;
        }
        return end - pos;
    }
}
