package hello.althor.leetCode.simple;

public class SearchInsert {

    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        SearchInsert searchInsert = new SearchInsert();
        int target = 6;
        int[] nums = new int[]{1,3,5,6, 8};
        int index = searchInsert.doSearchInsert(nums, target);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(index);
    }

    public int doSearchInsert(int[] nums, int target)
    {
        int length = nums.length;
        if (length == 0 || target < nums[0] || target > nums[length-1]) return -1;
        int compareIndex = length >> 1;
        int rightNode = length;
        int leftNode = 0;
        int compareEnd;
        while (target != nums[compareIndex]) {
            if (nums[compareIndex] > target) {
                compareEnd = rightNode;
                rightNode = compareIndex;
                compareIndex = (rightNode - leftNode) >> 1;
            } else {
                compareEnd = leftNode;
                leftNode = compareIndex;
                compareIndex = (rightNode + leftNode) >> 1;
            }
            if (compareIndex == compareEnd)
                return -1;
        }
        return compareIndex;
    }
}
