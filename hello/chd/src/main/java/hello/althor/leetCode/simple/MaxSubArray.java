package hello.althor.leetCode.simple;

public class MaxSubArray {

    public static void main(String[] args)
    {
        MaxSubArray maxSubArray = new MaxSubArray();
        Long start = System.currentTimeMillis();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray.solution(nums);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public int solution(int[] nums)
    {

        return 0;
    }
}
