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

        return 0;
    }
}
