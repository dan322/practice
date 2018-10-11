package hello.base.simpleLink;

import hello.base.simpleLink.Node;

public class SimpleLinked {
    // TODO
    private Node head = null;

    public void deleteNode(Node node)
    {
        if (head.next == null) return;
        Node searchNode = head.next;
        Node preNode = null;
        while (searchNode.next != node.next)
        {
            preNode = searchNode;
            if (searchNode.next == null)
                return;
            searchNode = searchNode.next;
        }
        if (preNode == null) {
            head.next = null;
            return;
        }
        preNode.next = searchNode.next;
    }

    public void insertNode(Node node, int value)
    {
        Node newNode = new Node(value);
        if (head.next == null) {
            head.next = newNode;
            return;
        }
        Node searchNode = head.next;
        while (searchNode.next == node.next) {
            node.next = searchNode.next;
            searchNode.next = node;
            break;
        }
    }

    public void deleteNodeAfter(Node node)
    {
        if (head.next == null ) return;
        Node searchNode = head.next;
        while ( searchNode.next == node.next)
        {
            node.next = null;
            break;
        }
    }

    public void deleteTailN(int n)
    {

    }

    public void reverseLink ()
    {
        if (head.next == null) return;
        Node nextNode = head.next;
        Node secondNode = nextNode.next;
        while (secondNode != null)
        {
            nextNode.next = secondNode.next;
            head.next = secondNode;
            secondNode.next = nextNode;
            if (nextNode.next == null)
                return;
            secondNode = nextNode.next;
        }
    }

    // todo linked examine circle

    /**
     *    ********    *******
     * @return
     */
    public boolean isCircle()
    {
        if (head.next == null)
            return false;
        Node node1 = head.next;
        Node node2 = node1;
        if (node2.next == null)
            return false;
        while (node1.next != node2.next.next) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node2 == null)
                return false;
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
        Node searchNode = head.next;
        if (searchNode == null) {
            return l1;
        }
        while (searchNode.next != null) {
            searchNode = searchNode.next;
        }
        searchNode.next = l1.head.next;
        l1.head.next = searchNode;
        return l1;
    }

    public Node findNode(int data)
    {
        if (head.next == null) return null;
        Node searchNode = head.next;
        while (searchNode.data != data) {
            searchNode = searchNode.next;
            if (searchNode == null )
                return null;
        }
        return searchNode;
    }


}
