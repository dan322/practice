package hello.althor.divide;

public class Application {

    public static void main(String[] args)
    {
        /*int a = 134, b = 89;
//        int a =(int) Math.floor(Math.random() * 100000);
//        int b =(int) Math.floor(Math.random() * 190000);
        System.out.println(a);
        System.out.println(b);
        LargeIntegeMulti largeIntegeMulti = new LargeIntegeMulti();
        int result = largeIntegeMulti.doMulti(a, b);
        System.out.println(result);*/

        int x = 123;

    }

    public int doReverse(int x) {
        if (x == 0 || x < 10)
            return 0;
        int j = 10;
        int i = 1;
        while (true) {
            if (x == j) {
                return 1;
            } else if ( x > j) {
                i++;
            } else {
                break;
            }
            j *= 10;
        }
        int[] arr = new int[i];
        int singleNum = 0;
        while ( x > 0 ) {
            singleNum = x - 10 * i + 1;

        }
        int middle = i >> 2 -1;


    }
}
