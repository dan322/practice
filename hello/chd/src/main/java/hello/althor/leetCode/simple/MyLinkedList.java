package hello.althor.leetCode.simple;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

public class MyLinkedList {

    public static void main(String[] args)
    {
        MyLinkedList myLinkedList = new MyLinkedList();
        Long start = System.currentTimeMillis();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(myLinkedList.get(1));            //返回2
        myLinkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(myLinkedList.get(1)); //返回3
        System.out.println(System.currentTimeMillis() - start);
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }
}
