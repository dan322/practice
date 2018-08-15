package hello.althor.sort;

public class TestApplication {

    public static void main(String[] args)
    {
        /*System.out.println(12%10);
        int a = 4, b = 6;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);*/
        MergeSort mergeSort = new MergeSort();
        int[] arrLeft = new int[]{9, 8, 3, 1, 23, 454, 21, 2, 4, 23};
        int[] arrRight = new int[]{8};
//        int[] newArray = mergeSort.merge(arrLeft, arrRight);
        int[] newArray = mergeSort.mergeSort(arrLeft);
        for (int i=0; i< newArray.length; i++)
            System.out.println(newArray[i]);
    }
}
