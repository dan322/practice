package hello.althor.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static void main(String[] args)
    {
        double time = System.currentTimeMillis();

        /**
         * insert sort (58)
         */
//        InsertSort abstractSort =  new InsertSort();
        /**
         * bubble sort (408)   最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
         */
//        BubbleSort abstractSort =  new BubbleSort();

        /**
         *  83
         */
//        SelectionSort abstractSort = new SelectionSort();

        /**
         *  29 (18)
         */
//        ShellSort abstractSort = new ShellSort();

        /**
         * 20
         */
//        QuickSort abstractSort = new QuickSort();

        /**
         *  14 when number is more bigger more faster
         */
//        CountingSort abstractSort = new CountingSort();

        /**
         * 23 17
         */
//        HeapSort abstractSort = new HeapSort();

        /**
         * 38
         */
//        RadixSort abstractSort = new RadixSort();

        /**
         * 100+
         */
        MergeSort abstractSort = new MergeSort();

        abstractSort.setTotal(10000);
//        abstractSort.setTotal(10);
//        int seventh = (1000 >> 3) + (1000 >> 6) + 1;
//        System.out.println(seventh);

        int[] raw_arr = abstractSort.generateArr();
//        System.out.println("Raw array: ");
//        for (int i=0; i< raw_arr.length; i++) {
//            System.out.println(raw_arr[i]);
//        }
//        int[] raw_arr = new int[] {9, 8, 3, 1, 23, 454, 21, 2, 4, 24, 23};

        abstractSort.doSort(raw_arr);

        double endTime = System.currentTimeMillis();
        System.out.println("Total Spend Time: " + (endTime - time));
        System.out.println("Sorted array: ");
        for (int i=0; i< raw_arr.length; i++) {
//            System.out.println(raw_arr[i]);
        }
    }
}
