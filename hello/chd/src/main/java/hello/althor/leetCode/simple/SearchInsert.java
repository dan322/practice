package hello.althor.leetCode.simple;

public class SearchInsert {

    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = new int[]{};
        int target = 2;
        int index = searchInsert.doSearchInsert(nums, target);
        System.out.println(index);
        System.out.println(System.currentTimeMillis() - start);
    }

    public int doSearchInsert(int[] nums, int target)
    {
        int length = nums.length;
        int compareIndex = length >> 1;
        while (compareIndex > 0) {
            if (nums[compareIndex] > target) {
                compareIndex = compareIndex >> 1;
            } else if (nums[compareIndex] == target) {
                break;
            } else {
                compareIndex = ( length - compareIndex) >> 1 + compareIndex;
            }
        }
        return 0;
    }
}
