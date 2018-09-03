package hello.althor.leetCode.simple;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidParentheses {
    private Map<Character, Integer> map;
//    private Map<Character, Character> map2;

    ValidParentheses()
    {
        this.map = new HashMap<Character, Integer>();
        this.map.put('[', 1);
        this.map.put(']', -1);
        this.map.put('(', 2);
        this.map.put(')', -2);
        this.map.put('{', 3);
        this.map.put('}', -3);
    }

  /*  ValidParentheses()
    {
        this.map2 = new HashMap<Character, Character>();
        this.map2.put('[', ']');
        this.map2.put('(', ')');
        this.map2.put('{', '}');
    }*/


    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        String[] strings = new String[]{"()", "()[]{}", "(]", "([)]", "{[]}", ")({}", ")(({)}"};
        ValidParentheses validParentheses = new ValidParentheses();
        for (String s: strings) {
            System.out.println(validParentheses.isValid(s));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public boolean isValid(String s)
    {
        int length = s.length();
        if ((length & 1) == 1) return false;
        int preInt = 0;
        int total = 0;
        int nowInt;
        while (--length >= 0) {
            nowInt = this.map.get(s.charAt(length));
           /* if (preInt < 0) {
                if ( nowInt > 0 && (nowInt + preInt) != 0 ) break;
            } else {
                if (nowInt + preInt == 0) break;
            }*/
            if (preInt < 0 && nowInt > 0 && (nowInt + preInt) != 0) {
                break;
            }
            if (preInt > 0 && (nowInt + preInt) == 0) {
                break;
            }
            total += nowInt;
            preInt = nowInt;
        }
        return total == 0;
    }

}
