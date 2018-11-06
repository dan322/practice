package hello.althor.leetCode.simple;

import javax.xml.bind.SchemaOutputResolver;

public class CountAndSay {

    // TODO
    public static void main(String[] args)
    {
        CountAndSay countAndSay = new CountAndSay();
        Long start = System.currentTimeMillis();
        int num = 3;
        int result = countAndSay.solution(num);
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
     * @param num
     * @return
     */
    public int solution(int num)
    {
        if (num == 1) return num;
        if (num == 2) return 11;
        int count = 1, remainder = 0, value, prevRemainder = 0, result = 11;
        for (int i = 3; i < num + 1; i++) {
            // todo read result
            value = result;
            result = 0;
            while (value > 0) {
                remainder = value % 10;
                System.out.println(remainder);
                System.out.println(prevRemainder);
                if (remainder == prevRemainder) {
                    prevRemainder = remainder;
                    count++;
                    continue;
                }
                if (prevRemainder != 0) {
                    result = result * 10 + count * 10 + prevRemainder;
                    count = 1;
                }
                value = value / 10;
                System.out.println(value);
                prevRemainder = remainder;
            }
            if (value == 1)
                result = result * 10 + count * 10 + remainder;
        }
        return result;
    }


}
