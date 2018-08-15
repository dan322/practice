package hello.althor.sort;

public class QuickSort extends AbstractSort {

    /**
     *
     * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param arr
     */
    @Override
    public void doSort(int[] arr)
    {
        if (arr.length < 1) return;
//        this.doQuickSort(arr, 0, arr.length-1);
        this.QuickSort(arr, 0, arr.length -1);
    }

    /*public void doQuickSort(int[] arr, int start, int end)
    {
        if (end > start) {
            int pivot = this.getRandomPivot(start, end);
            *//*if (start < pivot)
                doQuickSort(arr, start, pivot -1);
            if (pivot < end)
                doQuickSort(arr, pivot+1, end);*//*
            int s = start;
            for (; s <= end; s++)
            {
                if (s == pivot) continue;
                if (s < pivot && arr[s] < arr[pivot]) continue;
                if (s > pivot && arr[s] > arr[pivot]) continue;
                this.swap(arr, s, pivot);
                System.out.println(s);
                pivot = s;
            }
//            doQuickSort(arr, start, pivot -1);
//            doQuickSort(arr, pivot +1, end);
        }
    }

    public int getRandomPivot(int start, int end)
    {
        return 0;
//        if (end <= start) return 0;
//        return (int) Math.random() * (end - start + 1) + start;
    }*/

    /*public void swap(int[] arr, int i, int j)
    {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }*/

    public void QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return;
        int smallIndex = this.partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        this.swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    this.swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
