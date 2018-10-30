package hello.althor.leetCode.simple;

public class SearchInsert {

    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        SearchInsert searchInsert = new SearchInsert();
        int target = 2;
        int[] nums = new int[]{1,3,5,6};
        int index = searchInsert.doSearchInsert(nums, target);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(index);
    }

    public int doSearchInsert(int[] nums, int target)
    {
        int leftNode = 0;
        int rightNode = nums.length -1;
        int compareIndex = rightNode >> 1;
        while (rightNode >= leftNode) {
            if (nums[compareIndex] > target) {
                rightNode = compareIndex -1;
            } else if (target == nums[compareIndex]) {
                return compareIndex;
            } else {
                leftNode = compareIndex + 1;
            }
            compareIndex = leftNode + ((rightNode - leftNode) >> 1);
        }
        return leftNode;
    }
}
