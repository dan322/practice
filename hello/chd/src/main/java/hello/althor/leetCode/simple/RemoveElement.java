package hello.althor.leetCode.simple;

public class RemoveElement {
    public static void main(String [] args)
    {
        RemoveElement remove = new RemoveElement();
        Long start = System.currentTimeMillis();
        int[] nums = new int[]{3, 2, 2, 3}; // 3 3 2 4 5 3
        int val = 3;
        int length = remove.solution(nums, val);
        System.out.println(length);
        System.out.println(System.currentTimeMillis() - start);
    }

    public int solution(int[] nums, int val)
    {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                index = i;
            }
            // todo swap equal with the value didn't equal
        }
        return 0;
    }
}
