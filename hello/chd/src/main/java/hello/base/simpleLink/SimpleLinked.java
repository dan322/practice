package hello.base.simpleLink;

import hello.base.simpleLink.Node;

public class SimpleLinked {
    // TODO
    private Node head = null;

    public void addToHead (int value)
    {
        Node node = new Node(value);
        if (head != null || head.next != null)
            node.next = head.next;
        head = node;
    }

    public void addToNodeAfter (Node node, int value)
    {
        Node newNode = new Node(value);
        newNode.next = node.next;
        node.next = newNode;
    }

    public void addToNodeBefore(Node node, int value)
    {

    }

    public void deleteNode(Node node)
    {
        if (head == null) return;
        Node searchNode = head;
        Node preNode = null;
        while (searchNode.data != node.data)
        {
            preNode = searchNode;
            if (searchNode.next == null)
                return;
            searchNode = searchNode.next;
        }
        if (preNode == null) {
            head = null;
            return;
        }
        preNode.next = searchNode.next;
    }

    public void insertNode(Node node, int value)
    {
        Node newNode = new Node(value);
        
    }

}
