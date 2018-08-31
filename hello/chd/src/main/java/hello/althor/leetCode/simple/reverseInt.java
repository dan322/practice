package hello.althor.leetCode.simple;

public class reverseInt {

    public static void main(String[] args)
    {
        /*int a = 134, b = 89;
//        int a =(int) Math.floor(Math.random() * 100000);
//        int b =(int) Math.floor(Math.random() * 190000);
        System.out.println(a);
        System.out.println(b);
        LargeIntegeMulti largeIntegeMulti = new LargeIntegeMulti();
        int result = largeIntegeMulti.doMulti(a, b);
        System.out.println(result);*/
        Long start = System.currentTimeMillis();
        int x = -2147483648;
        System.out.println(doReverse(x));
//        System.out.println(reverse(x));
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int doReverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) return 0;
        int usingedX = Math.abs(x);
        if ( usingedX < 10)
            return x;
        String str = String.valueOf(usingedX);
        int length = str.length();
        int maxIndex = length -1;
        int middle = length >> 1;
        int i = 0;
        char numberMin, numberMax;
        boolean zeroRemove = true;
        char[] newInt = new char[length];
        while (middle <= maxIndex) {
            if (i == maxIndex) {
                newInt[maxIndex] = str.charAt(maxIndex);
                break;
            }
            numberMin = str.charAt(maxIndex);
            if (numberMin == 0 && zeroRemove) {
                i++;
                continue;
            }
            if (zeroRemove) zeroRemove = false;
            numberMax = str.charAt(i);
            newInt[i] = numberMin;
            newInt[maxIndex] = numberMax;
            i++;
            maxIndex--;
        }
        String newStr = "";
        for (int j = 0; j < length; j++) {
            newStr += newInt[j];
        }
        int base = x < 0 ? -1: 1;
        try {
            return Integer.parseInt(newStr) * base;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse(int x) {
        int rev = 0;
        if ((x >= 0 && x < 10) || (x > -10 && x <0)) return x;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
