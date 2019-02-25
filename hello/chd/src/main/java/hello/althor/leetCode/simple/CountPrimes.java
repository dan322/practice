package hello.althor.leetCode.simple;

public class CountPrimes {

    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * @param args
     */
    public static void main(String[] args)
    {
        CountPrimes countPrimes = new CountPrimes();
        Long start = System.currentTimeMillis();
        int n = 100000;
//        int result = countPrimes.solution1(n);
        int result = countPrimes.countPrimes(n);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public int solution(int n)
    {
        if (n < 3) {
            return 0;
        }
        if (3 == n)
            return 1;
        int size = n / 4 + 3;
        int[] nums = new int[size];
        nums[0] = 2;
        int total = 1, i = 3, j;
        while (i < n) {
            for (j = 0; j < total; j++) {
                if ( 0 == nums[j] || (nums[j] * nums[j]) > i) {
                    System.out.println(i);
                    nums[total] = i;
                    total++;
                    break;
                }
                if (i % nums[j] == 0) {
                    break;
                }
            }
            i++;
        }
        return total;
    }

    public int solution1(int n)
    {
        if (n < 3)
            return 0;
        int  i = 2, count = 0;
        while (i < n) {
            if (isPrime(i))
                count++;
            i++;
        }
        return count;
    }

    public boolean isPrime(int n)
    {
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0)
                return false;
        }
        System.out.println(n);
        return true;
    }

    /**
     *  1. 所有的偶数（>2）不是质数
     *  2.  埃拉托斯特尼筛法 Sieve of Eratosthenes
     *      将每个素数的各个倍数，标记成合数。一个素数的各个倍数，是一个差为此素数本身的等差数列
     *      j= i * i ( i * (i - 1), 当i = i - 1时已经计算或排除)
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        boolean[] arr = new boolean[n];
        int count = n/2;
        for(int i = 3;i*i<n;i+=2){
            if(arr[i]) continue;
            for(int j = i*i;j<n;j+=2*i){
                if(!arr[j]){
                    count--;
                    arr[j] = true;
                }
            }
        }
        return count;
    }
}
