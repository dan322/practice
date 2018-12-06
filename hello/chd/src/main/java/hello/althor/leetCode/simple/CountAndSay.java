package hello.althor.leetCode.simple;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Stack;

public class CountAndSay {

    // TODO
    public static void main(String[] args)
    {
        CountAndSay countAndSay = new CountAndSay();
        Long start = System.currentTimeMillis();
        int num = 2;
//        int result = countAndSay.solution(num);
        String result = countAndSay.solution1(num);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * @param number
     * @return
     */
    public int solution(int number)
    {
        if (number == 1) return number;
        int count, remainder, value, prevRemainder, result = 1, num;
        for (int i = 2; i < number + 1; i++) {
            value = result;
            num = 1;
            count = 0;
            result = 0;
            prevRemainder = 1;
            while (value > 0) {
                remainder = value % 10;
                value = value/10;
                if (remainder == prevRemainder) {
                    count++;
                    continue;
                }
                result += (count * 10 + prevRemainder) * num;
                prevRemainder = remainder;
                count = 1;
                num *= 100;
            }
            result += (count * 10 + prevRemainder) * num;
        }
        return result;
    }

    public String solution1(int number)
    {
        String result = "1123";
        System.out.println(result.toCharArray());
        if (number == 1) return result;
        char[] value = result.toCharArray();
        char num;
        int count = 0;
        for (int i = 2; i < number + 1; i++) {
            result = "";

        }
        return result;
    }

    public int test(int value)
    {
        int result = 0;
        int prevRemainder = 1;
        int remainder, count = 0, num = 1;
        while (value > 0) {
            remainder = value % 10;
            value = value/10;
            if (remainder == prevRemainder) {
                count++;
                continue;
            }
            result += (count * 10 + prevRemainder) * num;
            prevRemainder = remainder;
            count = 1;
            num *= 100;
        }
        result += (count * 10 + prevRemainder) * num;
        return result;
    }

    public int test1(int value)
    {
        value = 1;
        Stack nums = new Stack();
        while (value > 0) {

        }
        return 0;
    }



}
