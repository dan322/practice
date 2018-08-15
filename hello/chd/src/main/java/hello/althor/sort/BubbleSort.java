package hello.althor.sort;

public class BubbleSort extends AbstractSort{

    @Override
    public void doSort(int[] arr) {

        for (int j=0; j< arr.length -2; j++) {
            for(int i=0; i< arr.length-1; i++) {
                if (arr[i] < arr[i+1]) {
                    continue;
                }
              /*  int now = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = now;*/
                arr[i] = arr[i+1] ^ arr[i];
                arr[i+1] =  arr[i] ^ arr[i+1];
                arr[i] = arr[i] ^ arr[i+1];
            }
        }

    }
}
