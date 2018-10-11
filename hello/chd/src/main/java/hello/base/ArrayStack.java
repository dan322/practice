package hello.base;

public class ArrayStack {
    // todo
    private int length;
    private int tailInt;
    private int[] nums;

    ArrayStack(int capacity)
    {
        nums = new int[capacity];
    }

    public void add(int data)
    {
        if (++tailInt == length) {
            //todo 扩容 (capacity * 2)
            int[] newNums = new int[length<<1];
            int oldLength = length;
            while (oldLength > 0) {
                oldLength--;
                newNums[oldLength] = nums[oldLength];
//                newNums[--oldLength] = nums[oldLength];
            }
            nums = newNums;
        }
        tailInt++;
        nums[length++] = data;
    }

    public int getData()
    {
        if (tailInt < 0)
            return -1;
        length--;
        return nums[tailInt--];
    }

}
