package hello.althor.leetCode.simple;

public class PlusOne {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头
     * @param args
     */
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        Long start = System.currentTimeMillis();
        int[] digits = new int[]{ 8, 9, 9, 9};
        int[] result = plusOne.solution1(digits);
        System.out.println(System.currentTimeMillis() - start);
        for (int i= 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public int[] solution(int[] digits) {
        for (int i = digits.length; i > 0; ) {
            if (9 == digits[--i]) {
                digits[i] = 0;
                continue;
            }
            digits[i]++;
            break;
        }
        if (0 == digits[0]) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public int[] solution2(int[] digits) {
        for (int i = digits.length; i > 0; ) {
            if (9 == digits[--i]) {
                digits[i] = 0;
                continue;
            }
            digits[i]++;
           return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public int[] solution1(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry != 0) {
            int[] b = new int[digits.length + 1];
            b[0] = carry;
            System.arraycopy(digits, 0, b, 1, digits.length);
            return b;
        }
        return digits;
    }
}
