package hello.althor.sort;

public class CountingSort extends AbstractSort {

    /**
     * 将输入的数据值转化为键存储在额外开辟的数组空间中。
     * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数
     * 是一种稳定的排序算法。计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。
     * 然后根据数组C来将A中的元素排到正确的位置。它只能对整数进行排序
     *
     * 找出待排序的数组中最大和最小的元素；
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     *
     * 当输入的元素是n 个0到k之间的整数时，它的运行时间是 O(n + k)。计数排序不是比较排序，排序的速度快于任何比较排序算法
     * 最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
     * @param arr
     */
    @Override
    public void doSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int i=1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                continue;
            }
            if (arr[i] > max) max = arr[i];
        }

        int bias = 0 - min;
        int[] new_arr = new int[max - min +1];
        for (int i= 0; i< arr.length; i++) {
            new_arr[arr[i] + bias]++;
        }

        int index = 0;
        for(int i= 0; i< new_arr.length; i++) {
            while (new_arr[i] > 0) {
                arr[index] = i - bias;
                new_arr[i]--;
                index++;
            }
        }

       /* int i = 0;
        while (index < arr.length) {
            if (new_arr[i] > 0) {
                arr[index] = i - bias;
                new_arr[i]--;
                index++;
                continue;
            }
            i++;
        }*/
    }
}
