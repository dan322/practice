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
        int n = 20;
        int result = countPrimes.solution(n);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public int solution(int n)
    {
        // todo ann 
        return n;
    }
}
