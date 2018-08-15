package hello.althor.sort;

public class HeapSort extends AbstractSort {

    /**
     * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
     * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
     * 得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，
     * 则整个排序过程完成。
     * 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
     * @param arr
     */
    @Override
    public void doSort(int[] arr) {
        this.buildMaxHeap(arr);
        int i = arr.length -1;
        int len = arr.length -1;

        while(i > 0) {
            this.swap(arr, 0, i);
            this.adjustHeap(arr, 0, i);
            len--;
            i--;
        }
    }

    public void buildMaxHeap(int[] arr)
    {
        int circle = arr.length >> 1;
        for (int i=circle--; i >= 0; i--) {
            this.adjustHeap(arr, i, arr.length);
        }
    }

    public void adjustHeap(int[] arr, int i, int len)
    {
        int compareNode = this.getAdjustNode(arr, i, len);

        if (compareNode > 0 && arr[i] < arr[compareNode]) {
            this.swap(arr, i, compareNode);
            this.adjustHeap(arr, compareNode, len);
        }
    }

    public int getAdjustNode(int[] arr, int i, int len)
    {
        int left_node = (i << 1) + 1;
        int right_node = (i+1) <<1;
        if (left_node >= len) return 0;
        if (right_node >= len || arr[left_node] >= arr[right_node])
            return left_node;
        return right_node;
    }

    public void swap(int[] arr, int i, int j)
    {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
