package hello.althor.sort;

public class BucketSort extends AbstractSort {
    /**
     * 计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定
     * 工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
     * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排
     *
     * 人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
     * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
     * 对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
     * 从不是空的桶里把排好序的数据拼接起来。
     *
     * 桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
     * 最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n+k)　
     * @param arr
     *
     * https://www.cnblogs.com/guoyaohua/p/8600214.html
     */

    @Override
    public void doSort(int[] arr) {

    }
}
