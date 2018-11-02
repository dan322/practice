package hello.althor.leetCode.simple;

public class RemoveElement {
    public static void main(String [] args)
    {
        RemoveElement remove = new RemoveElement();
        Long start = System.currentTimeMillis();
        int[] nums = new int[]{3, 2, 3, 2, 4, 5, 3, 8}; //
        int val = 3;
        int length = remove.solution1(nums, val);
        System.out.println(length);
        System.out.println(System.currentTimeMillis() - start);
//        System.out.println("");
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(nums[i]);
        }
    }

    /**
     *  不稳定
     * @param nums
     * @param val
     * @return
     */
    public int solution(int[] nums, int val)
    {
        int last = nums.length - 1;
        for (int i = last; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[last];
                nums[last--] = val;
            }
        }
        return last + 1;
    }

    /**
     * 稳定
     * @param nums
     * @param val
     * @return
     */
    public int solution1(int[] nums, int val)
    {
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                first++;
                continue;
            }
            nums[i-first] = nums[i];
        }
        return nums.length - first;
    }

    /**
     *  best
     * @param nums
     * @param val
     * @return
     */
    public int solution2(int[] nums, int val) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }
}
