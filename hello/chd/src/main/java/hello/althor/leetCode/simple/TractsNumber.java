package hello.althor.leetCode.simple;

public class TractsNumber {

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        int x = 1000021;
        System.out.println(isTractsNumber(x));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static boolean isTractsNumber(int x)
    {
        if (x < 0) return false;
        if (x< 10) return true;
        boolean result = true;
        String str = String.valueOf(x);
        int start = 0, end = str.length() -1;
        int middle = end >> 1;
        char min, max;
        while(start <= middle) {
            if (end == start) {
                break;
            }
            min = str.charAt(start);
            max = str.charAt(end - start);
            System.out.println(max + " | " + min);
            if (min != max) {
                result = false;
                break;
            }
            start++;
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        if(s.equals(reverse))
            return true;
        return false;
    }

    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);

        StringBuffer sb = new StringBuffer(s);

        String s1 = sb.reverse().toString();

        if (s.equals(s1)){
            return true;
        }else {
            return false;
        }
    }

   /* 方法：反转一半数字
            思路

    映入脑海的第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。

    第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。 但是，如果反转后的数字大于 \text{int.MAX}int.MAX，我们将遇到整数溢出问题。

    按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转 \text{int}int 数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。

    例如，输入 1221，我们可以将数字“1221”的后半部分从“21”反转为“12”，并将其与前半部分“12”进行比较，因为二者相同，我们得知数字 1221 是回文。

    让我们看看如何将这个想法转化为一个算法。

    算法

    首先，我们应该处理一些临界情况。所有负数都不可能是回文，例如：-123 不是回文，因为 - 不等于 3。所以我们可以对所有负数返回 false。

    现在，让我们来考虑如何反转后半部分的数字。 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以10的余数，122 % 10 = 2，就可以得到倒数第二位数字。如果我们把最后一位数字乘以10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。 如果继续这个过程，我们将得到更多位数的反转数字。

    现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？

    我们将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
*/
}
