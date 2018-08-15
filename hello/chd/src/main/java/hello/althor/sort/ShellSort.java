package hello.althor.sort;

public class ShellSort extends AbstractSort {

    @Override
    public void doSort(int[] arr) {
        /**
         * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
         * 在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，
         * 这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列.
         * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
         * 按增量序列个数k，对序列进行k 趟排序；
         * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
         * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
         */

         //   如果数组长度不能整除

        for (int gap = arr.length >>1; gap >= 1;gap = gap >>1) {
//                    insert sort by group
            for (int j= gap; j < arr.length; j++) {
                int index = j;
                int now = arr[index];
                    /*while (index > 0 ) {
                        if (now > arr[index - gap])
                            break;
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }*/
                while (index >= gap && (now < arr[index-gap])) {
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                arr[index] = now;
            }
        }
    }

  /*  @Override
    public void doSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }*/
}
