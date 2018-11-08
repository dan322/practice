package hello.base.simpleLink;

import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args)
    {
      /*  SimpleLinked link = new SimpleLinked();
        link.insertNode(3, null);
        link.insertNode(2, null);
        link.insertNode(0, null);
        link.insertNode(-4, null);*/
       /* ListNode node = link.getHead();
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }*/
       Long start = System.currentTimeMillis();
        Application application = new Application();
        int [] arr = new int[] {3, 2, 0, -4};

        boolean hasCycle = application.listHasCycle(arr);

        System.out.println(hasCycle);
        System.out.println(System.currentTimeMillis() - start);
    }

    public boolean listHasCycle(int[] nums)
    {
        int length = nums.length;
        if (length < 2) return false;
        ListNode head = new ListNode(nums[0]);
        ListNode node1 = new ListNode(nums[1]);
        head.next = node1;
        ListNode node2 = new ListNode(nums[2]);
        node1.next = node2;
        ListNode node3 = new ListNode(nums[3]);
        node2.next = node3;
        node3.next = node1;
        /*ListNode pre = head;
        for (int i = 1; i < length; i++) {
            ListNode newListNode = new ListNode(nums[i]);
            pre.next = newListNode;
            pre = pre.next;
        }*/
        return hasCycle(head);
    }

    /**
     * ********************************    双指针     (以不同的速度在环形赛道上跑步)
     * 时间复杂度：O(n)， 让我们将 nn 设为链表中结点的总数。为了分析时间复杂度，我们分别考虑下面两种情况。
     *
     * 链表中不存在环：
     * 快指针将会首先到达尾部，其时间取决于列表的长度，也就是 O(n)。
     *
     * 链表中存在环：
     *   我们将慢指针的移动过程划分为两个阶段：非环部分与环形部分：
     *
     *      慢指针在走完非环部分阶段后将进入环形部分：此时，快指针已经进入环中 {迭代次数} = {非环部分长度} = N迭代次数=非环部分长度=N
     *
     *      两个指针都在环形区域中：考虑两个在环形赛道上的运动员 - 快跑者每次移动两步而慢跑者每次只移动一步。其速度的差值为1，因此需要经过 {{二者之间距离}}{{速度差值}}
     *      速度差值二者之间距离次循环后，快跑者可以追上慢跑者。这个距离几乎就是 " {环形部分长度 K}环形部分长度 K" 且速度差值为 1，我们得出这样的结论 {迭代次数} = {近似于}迭代次数=近似于 "{环形部分长度 K}环形部分长度 K".
     *
     *     因此，在最糟糕的情形下，时间复杂度为 O(N+K)也就是 O(n)。
     *
     *   空间复杂度：O(1)， 我们只使用了慢指针和快指针两个结点，所以空间复杂度为 O(1)。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode listNode1 = head;
        ListNode listNode2 = listNode1.next.next;
        while (listNode1 != listNode2) {
            if (listNode2 == null || listNode2.next == null) {
                return false;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
        }
        return true;
}

    /**
     *   *****************************    哈希表  (检查一个结点此前是否被访问过来判断链表是否为环形链表)
     *   时间复杂度：O(n)， 对于含有 n 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1) 的时间。
     *
     *   空间复杂度：O(n)， 空间取决于添加到哈希表中的元素数目，最多可以添加 n个元素
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    // TODO

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * @param nums
     * @return
     */
    public ListNode detectCycle(int[] nums)
    {
        int length = nums.length;
        if (length < 2) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode node1 = new ListNode(nums[1]);
        head.next = node1;
        ListNode node2 = new ListNode(nums[2]);
        node1.next = node2;
        ListNode node3 = new ListNode(nums[3]);
        node2.next = node3;
        node3.next = node1;
        /*ListNode pre = head;
        for (int i = 1; i < length; i++) {
            ListNode newListNode = new ListNode(nums[i]);
            pre.next = newListNode;
            pre = pre.next;
        }*/

        return null;
//        return solution(head);
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 不允许修改给定的链表。
     */
    public ListNode solution(ListNode head)
    {
        if (head == null || head.next == null)
            return null;
        ListNode listNode1 = head;
        ListNode listNode2 = listNode1.next.next;
        int n = 0;
        while (listNode1 != listNode2) {
            if (listNode2 == null || listNode2.next == null) {
                return null;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
        }
        // todo get cycle length
        listNode1 = listNode2;
        while (listNode1 != listNode2) {
            listNode1 = listNode1.next;
            n++;
        }
        // todo has cycle p2 go ahead cycle length (n)
        listNode2 = head;
        listNode1 = head;
        while (n > 0) {
            listNode2 = head.next;
            n--;
        }
        // p1 go from first node, then if two pointer meet, the pointer is the start of cycle
        while (listNode1 != listNode2) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return listNode1;
    }

    // TODO
    public int cycleLength(int[] nums)
    {
        int length = nums.length;
        if (length < 2) return 0;
        ListNode head = new ListNode(nums[0]);
        ListNode node1 = new ListNode(nums[1]);
        head.next = node1;
        ListNode node2 = new ListNode(nums[2]);
        node1.next = node2;
        ListNode node3 = new ListNode(nums[3]);
        node2.next = node3;
        node3.next = node1;
        /*ListNode pre = head;
        for (int i = 1; i < length; i++) {
            ListNode newListNode = new ListNode(nums[i]);
            pre.next = newListNode;
            pre = pre.next;
        }*/

        return 0;
    }

    /**
     *  return cycle length in list
     * @param head
     * @return
     */
    public int cycleLengthSolution(ListNode head)
    {

        if (head == null || head.next == null)
            return 0;
        ListNode listNode1 = head;
        ListNode listNode2 = listNode1.next.next;
        int n = 0;
        while (listNode1 != listNode2) {
            if (listNode2 == null || listNode2.next == null) {
                return 0;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
        }
        // todo get cycle length
        listNode1 = listNode2;
        while (listNode1 != listNode2) {
            listNode1 = listNode1.next;
            n++;
        }
        return n;
    }
}
