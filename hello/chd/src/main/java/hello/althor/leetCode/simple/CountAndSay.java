package hello.althor.leetCode.simple;

public class CountAndSay {

    public static void main(String[] args)
    {
        CountAndSay countAndSay = new CountAndSay();
        Long start = System.currentTimeMillis();
        int num = 3;
        int result = countAndSay.solution(num);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public int solution(int num)
    {
        if (num == 1) return num;
        int result = 0;
        int count = 1, remainder, value = 0;
        for (int i = 2; i < num + 1; i++) {
            // todo read result
            while (result > 0) {
                remainder = result % 10;
                if (remainder == value) {
                    count++;
                    continue;
                }
                if (result != 0) {
                    result = result * 10 + count * 10 + value;
                }
                value = remainder;
                num /= 10;
            }
        }
        return result;
    }


}
