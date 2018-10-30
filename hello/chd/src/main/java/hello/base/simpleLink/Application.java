package hello.base.simpleLink;

public class Application {

    public static void main(String[] args)
    {
        SimpleLinked link = new SimpleLinked();
        link.insertNode(3, null);
        link.insertNode(2, null);
        link.insertNode(0, null);
        link.insertNode(-4, null);
       /* ListNode node = link.getHead();
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }*/
        System.out.println(link.isCircle());
    }
}
