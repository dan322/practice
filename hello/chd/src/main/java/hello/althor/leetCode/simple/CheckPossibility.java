package hello.althor.leetCode.simple;

public class CheckPossibility {

    /**
     * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * <p>
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
     * <p>
     * n 的范围为 [1, 10,000]。
     *
     * @param args
     */
    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        Long start = System.currentTimeMillis();
//        int[] nums = new int[]{1, 2, 4, 5, 3};
//        int[] nums = new int[]{1, 2, 3, 3, 2, 5, 1};
//        int[] nums = new int[]{2, 3, 3, 2, 2, 4};
//        int[] nums = new int[]{2, 3, 2, 2, 3};
//        int[] nums = new int[]{3, 3, 2, 2};
        int[] nums = new int[]{1, 3, 5, 4, 4, 5};
//        int[] nums = new int[]{-1, 4, 2, 3};
        boolean result = checkPossibility.solution2(nums);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public boolean solution(int[] nums) {
//        int illegalNum = 0;
        boolean impossible = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (impossible || !(i + 2 == nums.length || nums[i] <= nums[i + 2]
                        || i == 0 || nums[i - 1] <= nums[i + 1]))
                    return false;
                impossible = true;
            }
        }
        return true;
    }

    public boolean solution1(int[] nums)
    {
        boolean modified = false;

        for(int i=0; i<nums.length; i++)
        {
            if(i+1 < nums.length && nums[i] > nums[i+1])
            {
                if(modified) // if modified a number already
                    return false;
                else // if it is first time to modify a number
                {
                    if(i-1 < 0 || nums[i+1] >= nums[i-1]) // if nums[i+1] is larger or equal all numbers before nums[i]
                        nums[i] = nums[i+1]; // change nums[i] as same as nums[i+1]
                    else // if nums[i+1] is not larger than all numbers before nums[i]
                        nums[i+1] = nums[i]; // change nums[i+1] as same as nums[i]

                    modified = true;
                }
            }
        }
        return true;
    }

    public boolean solution2(int[] nums)
    {
        int cc = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (cc == 0) {
                    if (i >= 2 && nums[i] < nums[i - 2])
                        nums[i] = nums[i - 1];
                    cc++;
                } else if (cc == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
