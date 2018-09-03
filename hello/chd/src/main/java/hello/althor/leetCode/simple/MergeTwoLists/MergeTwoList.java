package hello.althor.leetCode.simple.MergeTwoLists;

public class MergeTwoList {

    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next = new ListNode(4);
        System.out.println(l1.val);
        System.out.println(l1.next.val);
        System.out.println(l1.next.val);

        MergeTwoList mergeTwoList = new MergeTwoList();
        mergeTwoList.mergeTwoLists(l1, l2);

        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     *  有序list
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {

        return l1;
    }
}
