package hello.base.simpleLink;

public class AddTwoNumbers {
    ListNode l1;
    ListNode l2;
    /**
     * ********给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头
     * @param args
     */
   public static void main(String[] args)
   {
       int[] num1 = new int[] {2, 4, 3};
       int[] num2 = new int[]{5, 6, 4};
       AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
       addTwoNumbers.initListNode(num1, num2);
       Long start = System.currentTimeMillis();
       ListNode result = addTwoNumbers.addTwoNumbers(addTwoNumbers.l1, addTwoNumbers.l2);
       System.out.println(System.currentTimeMillis() - start);
       while (result.next != null) {
           System.out.println(result.val);
           result = result.next;
       }
   }

   public void initListNode(int[] num1, int[] num2)
   {
       int length = num1.length;
       int i = 0;
       ListNode now = this.l1;
       while (i < length) {
           if (i == 0) {
               this.l1 = new ListNode(num1[i]);
               now = this.l1;
               continue;
           }
           i++;
           now.next = new ListNode(num1[i]);
       }
       length = num2.length;
       i = 0;
       now = this.l2;
       while (i < length) {
           if (i == 0) {
               this.l2 = new ListNode(num2[i]);
               now = this.l2;
               continue;
           }
           i++;
           now.next = new ListNode(num2[i]);
       }
   }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode now = newHead;
        int i = 0, result;
        while(true) {
            result = l1.val + l2.val + i;
            if (result > 9) {
                now.next = new ListNode(result - 10);
                i = 1;
            } else {
                now.next = new ListNode(result);
            }
            now = now.next;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                now.next = l2;
                break;
            }
            if (l2 == null) {
                now.next = l1;
                break;
            }
        }
        return newHead.next;
    }
}
