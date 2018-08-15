package hello.althor.sort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {
    /**
     * 采用分治法（Divide and Conquer）
     * O(n log n）的时间复杂度
     * 需要额外的内存空间。
     *
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     * @param arr
     */
    @Override
    public void doSort(int[] arr) {
        int[] newArray = this.mergeSort(arr);
        for (int i=0; i< newArray.length; i++)
            System.out.println(newArray[i]);
    }

    public int[] mergeSort(int[] array)
    {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(this.mergeSort(left), this.mergeSort(right));
    }

    public int[] merge(int[] arrLeft, int[] arrRight)
    {
        int[] mergeArray = new int[arrLeft.length + arrRight.length];
        int rightIndex = 0;

        for (int i=0; i < arrLeft.length; i++) {
            if (rightIndex >= arrRight.length || arrLeft[i] < arrRight[rightIndex]) {
                mergeArray[i + rightIndex] = arrLeft[i];
                continue;
            }
            mergeArray[i + rightIndex] = arrRight[rightIndex];
            rightIndex++;
            i--;
        }
        for (; rightIndex < arrRight.length; rightIndex++) {
            mergeArray[arrLeft.length + rightIndex] = arrRight[rightIndex];
        }

       /* for (int index = 0, i = 0, j = 0; index < mergeArray.length; index++) {
            if (i >= arrLeft.length)
                mergeArray[index] = arrRight[j++];
            else if (j >= arrRight.length)
                mergeArray[index] = arrLeft[i++];
            else if (arrLeft[i] > arrRight[j])
                mergeArray[index] = arrRight[j++];
            else
                mergeArray[index] = arrLeft[i++];
        }*/
        return mergeArray;
    }
}
