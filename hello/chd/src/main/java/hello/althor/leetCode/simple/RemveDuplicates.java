package hello.althor.leetCode.simple;

import java.util.Arrays;

public class RemveDuplicates {
    private int length;

    public static void main(String[] args)
    {
        RemveDuplicates remveDuplicates = new RemveDuplicates();
        long start = System.currentTimeMillis();
        int[] nums = {0,0,1,1,1,2,2,3,3,4, 5, 5, 6, 8, 10, 32, 32, 24, 16, 16};
        int length = remveDuplicates.removeDuplicates1(nums);
        System.out.println(length);
        System.out.println(System.currentTimeMillis() - start);
    }

    public int removeDuplicates(int[] nums) {
        this.length = nums.length;
        int length = this.length;
        int duplicateLength = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i-1]) {
                duplicateLength++;
            } else if (duplicateLength > 0) {
                i -= duplicateLength;
                deleteNum(nums, i--, duplicateLength, length);
                length -= duplicateLength;
                duplicateLength = 0;
            }
        }
        return length - duplicateLength;
    }

    public void deleteNum(int[] nums, int i, int duplicateLength, int end)
    {
        while(i < end) {
            nums[i] = nums[i + duplicateLength];
            i++;
        }
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        for (int k : nums)
            System.out.println(k);
        return ++i;
    }

    /**
     * best
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0, j = i + 1;
        while (j != nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                if (i != j) {
                    nums[i] = nums[j];
                }
            }
            j++;
        }
        return i + 1;
    }
}
