package hello.althor.leetCode.simple;

public class SearchInsert {

    public static void main(String[] args)
    {
       /* char[] chars = new char[]{'v', 'e', 'r', 's', 'i', 'o', 'n', '1'};
        int hashKey = 0;
        for (int i = 0; i < chars.length; i++) {
            hashKey = (hashKey << 5) - hashKey + chars[i];
            hashKey = 31 * hashKey + chars[i];
        }
        System.out.println(hashKey);
*/
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
