package hello.base.simpleLink;

public class Node {
    public int data;
    public Node next;

    Node (int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
