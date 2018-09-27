package hello.althor.leetCode.simple;

public class SearchInsert {

    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        SearchInsert searchInsert = new SearchInsert();
        int target = 2;
        int[] nums = new int[]{1,3,5,6};
        int index = searchInsert.doSearchInsert(nums, target);
        System.out.println(index);
        System.out.println(System.currentTimeMillis() - start);
    }

    public int doSearchInsert(int[] nums, int target)
    {
        int length = nums.length;
        if (length == 0 ) return 0;
        int compareIndex = length >> 1;
        while (true) {
            if (nums[compareIndex] > target) {
                compareIndex = compareIndex >> 1;
            } else if (nums[compareIndex] == target) {
                break;
            } else {
                compareIndex =  length + compareIndex >> 1;
            }
        }
        return 0;
    }
}
