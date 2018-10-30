package hello.base.simpleLink;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
