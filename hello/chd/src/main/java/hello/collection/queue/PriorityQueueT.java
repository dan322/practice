package hello.collection.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueT {
    private int size = 0;

    public static void main(String[] args) {
        int a = 5;
        int k = (a -1) >>> 1;
        System.out.println(k);

       /* PriorityQueueT p = new PriorityQueueT();
        int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();

        for (int x : ia) {
//            System.out.println(x);
            pq1.offer(x);
            p.size++;
        }

        // 注意排序
        System.out.println("pq1: " + pq1);

        //by added order
        for (Integer i:pq1) {
//            System.out.println(i);
        }

        //sort small to big
        while(!pq1.isEmpty()){
            System.out.println(pq1.poll());
            System.out.println(pq1);
        }
        System.out.println("hello\n");
        Iterator<Integer> it = pq1.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }*/
    }

    public Object poll(PriorityQueue pq1)
    {
        if (this.size == 0)
            return null;
//        Object first = pq1[0];
        return pq1;
    }
}
