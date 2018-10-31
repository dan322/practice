package hello.base.simpleLink;

import jdk.nashorn.internal.runtime.Undefined;

public class SimpleLinked {
    // TODO
    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void deleteNode(ListNode listNode)
    {
        if (head.next == null) return;
        ListNode searchListNode = head.next;
        ListNode preListNode = null;
        while (searchListNode.next != listNode.next)
        {
            preListNode = searchListNode;
            if (searchListNode.next == null)
                return;
            searchListNode = searchListNode.next;
        }
        if (preListNode == null) {
            head.next = null;
            return;
        }
        preListNode.next = searchListNode.next;
    }

    public void insertNode(int value, ListNode listNode)
    {
        ListNode newListNode = new ListNode(value);
        if (head == null) {
            head = newListNode;
            return;
        }
        ListNode searchListNode = head;
        while (searchListNode.next != listNode) {
            searchListNode = searchListNode.next;
        }
        if (listNode != null) {
            newListNode.next = searchListNode.next;
        }
        searchListNode.next = newListNode;
    }

    public void deleteNodeAfter(ListNode listNode)
    {
        if (head.next == null ) return;
        ListNode searchListNode = head.next;
        while ( searchListNode.next == listNode.next)
        {
            listNode.next = null;
            break;
        }
    }

    public void deleteTailN(int n)
    {
        ListNode p1 = head.next, p2 = head.next;
        while (p2.next != null) {
            if (n <= 0) {
                p1 = p1.next;
            } else {
                n--;
            }
            p2 = p2.next;
        }
        p1.next = null;
    }

    public void reverseLink ()
    {
        if (head.next == null) return;
        ListNode nextListNode = head.next;
        ListNode secondListNode = nextListNode.next;
        while (secondListNode != null)
        {
            nextListNode.next = secondListNode.next;
            head.next = secondListNode;
            secondListNode.next = nextListNode;
            if (nextListNode.next == null)
                return;
            secondListNode = nextListNode.next;
        }
    }

    // todo linked examine circle

    /**
     *    ********    *******
     * @return
     */
    public boolean isCircle()
    {
        if (head.next == null || head.next.next == null)
            return false;
        ListNode listNode1 = head.next;
        ListNode listNode2 = listNode1.next.next;
        while (listNode1 != listNode2) {
            listNode1 = listNode1.next;
            if (listNode2 == null || listNode2.next == null) {
                return false;
            }
            listNode2 = listNode2.next.next;
        }
        return true;
    }

    /**
     *  merge two linked
     * @param l1
     * @return
     */
    public SimpleLinked mergeLinked(SimpleLinked l1)
    {
        ListNode searchListNode = head.next;
        if (searchListNode == null) {
            return l1;
        }
        while (searchListNode.next != null) {
            searchListNode = searchListNode.next;
        }
        searchListNode.next = l1.head.next;
        l1.head.next = searchListNode;
        return l1;
    }

    public ListNode findNode(int data)
    {
        if (head.next == null) return null;
        ListNode searchListNode = head.next;
        while (searchListNode.val != data) {
            searchListNode = searchListNode.next;
            if (searchListNode == null )
                return null;
        }
        return searchListNode;
    }

    /**
     *  two sorted list merge
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode joinListNode;
        while (true) {
            if (l1.val <= l2.val) {
                joinListNode = l1;
                l1 = l1.next;
            } else {
//                joinListNode.next = l2;
                joinListNode = l2;
                l2 = l2.next;
            }
            if (head == null) head = joinListNode;
            if (l2 == null) break;
        }
        return l1;
    }


}
