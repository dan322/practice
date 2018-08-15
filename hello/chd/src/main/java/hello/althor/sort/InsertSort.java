package hello.althor.sort;

import java.util.ArrayList;

public class InsertSort extends AbstractSort{
    /**
     *
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，
     * 找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param arr
     */
    @Override
    public void doSort(int[] arr) {
        for (int i =1; i< arr.length; i++)
        {
            int j = i -1;
            int now = arr[i];
            while (now < arr[j]) {
                arr[j+1] = arr[j];
                j--;
                if (j < 0) {
                    break;
                }
            }
            arr[j+1] = now;
        }
    }
}
