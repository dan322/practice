package hello.althor.leetCode.simple;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    final static String EMPTY = "";

    public static void main(String [] args)
    {
        Long start = System.currentTimeMillis();
        LongestCommonPrefix longest = new LongestCommonPrefix();

        String[] str = new String[] {"flower", "flow", "flight"};
//        String[] str = new String[] {"dog", "racecar", "car"};
//        String[] str = new String[] {"racecar", "racecar", "racecar"};
//        String[] str = new String[] {"red"};

//        System.out.println(longest.getLongestCommonPrefix(str));
        System.out.println(longest.longestCommonPrefix3(str));
        System.out.println(System.currentTimeMillis() - start);
    }

    public String getLongestCommonPrefix(String[] str)
    {
        /*
        String minStr = str[0];
        ArrayList<char[]> charArrayList = new ArrayList<char[]>();
        int minLength = str[0].length();
        int strArrayLength = str.length;
        for (int i = 0; i < strArrayLength; i++) {
            if (str[i].length() < minLength) {
                minStr = str[i];
                minLength = str[i].length();
                charArrayList.add(minStr.toCharArray());
            } else {
                charArrayList.add(str[i].toCharArray());
            }
        }

        if (minLength == 0) return "";
         out:
        for (int index = 0; index < charArrayList.size(); index++) {
            char[] comparedStr = charArrayList.get(index);
            char[] charArr = minStr.toCharArray();
            for (int j = 0; j < minLength; j++) {
                if (charArr[j] != comparedStr[j]) {
                    if (j == 0) {
                        minStr = "";
                        break out;
                    }
                    minStr = minStr.substring(0, j);
                    break;3. jira-6212 CX02 客户满意度处理日志报告;
4. jira-6213 CX03 订单中的客户满意度处理;
                }
            }
        }
        */
        int length = str.length;
        if (length == 0) return "";
        String minStr = str[0];
        int minLength = minStr.length();
        int comparedLength;
        out:
        for (int index = 1; index < length; index++) {
            char[] comparedStr = str[index].toCharArray();
            char[] charArr = minStr.toCharArray();
            comparedLength = comparedStr.length -1;
            for (int j = 0; j < minLength; j++) {
                if (comparedLength < j || charArr[j] != comparedStr[j]) {
                    if (j == 0) {
                        minStr = "";
                        break out;
                    }
                    minStr = minStr.substring(0, j);
                    minLength = minStr.length();
                    break;
                }
            }
        }
        return minStr;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0)
            return EMPTY;
        char[] alter = strs[0].toCharArray();
        int len=alter.length;
        for (int i = 1; i < strs.length; ++i) {
            String cur = strs[i];
            if (cur == null)
                return EMPTY;
            len=Math.min(len, cur.length());
            for (int j = 0; j < len && j < cur.length(); ++j) {
                if (cur.charAt(j) != alter[j]) {
                    len=j;
                    break;
                }
            }
        }
        return String.valueOf(alter, 0, len);
    }

    /**
     *  best
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    public String longestCommonPrefix3(String[] strs) {
        int count=strs.length;
        String prefix="";
        if(count!=0){
            prefix=strs[0];
        }
        for(int i=0;i<count;i++){
            while(!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

}
