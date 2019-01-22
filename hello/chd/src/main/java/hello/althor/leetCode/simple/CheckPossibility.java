package hello.althor.leetCode.simple;

public class CheckPossibility {

    /**
     * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     *
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
     *
     * n 的范围为 [1, 10,000]。
     * @param args
     */
    public static void main(String[] args)
    {
        CheckPossibility checkPossibility = new CheckPossibility();
        Long start = System.currentTimeMillis();
        int[] nums = new int[]{4, 2, 1};
        boolean result = checkPossibility.solution(nums);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public boolean solution(int[] nums)
    {
        // todo ann
        return false;
    }
}
