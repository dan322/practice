package hello.althor.sort;

import java.util.ArrayList;
import java.util.Arrays;

abstract public class AbstractSort {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int[] generateArr()
    {
        int i = 0;
        int[] raw_arr = new int[this.total];
        while(i < this.total) {
            int j = (int) Math.ceil(Math.random() * 100000);
            raw_arr[i] = j;
            i++;
        }
        return raw_arr;
    }

    abstract public void doSort(int[] arr);
}
