package hello.althor.leetCode.simple;

public class MaxSubArray {

    /**
     *
     给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

     示例:

     输入: [-2,1,-3,4,-1,2,1,-5,4],
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     进阶:

     如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     * @param args
     */
    public static void main(String[] args)
    {
        MaxSubArray maxSubArray = new MaxSubArray();
        Long start = System.currentTimeMillis();
//        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = new int[] {20, -10, 1,-3,4,-1,2,1,-10,4, 5, -11, 8};
        int[] nums = new int[] {4, -5, -2,1,-3,8,-1,2,1,-7,10};
//        int[] nums = new int[] { -2, -3, -4, -1, -10};
//        int[] nums = new int[] { -1, 0, -2};
//        int result = maxSubArray.solution3(nums);
        int result = maxSubArray.solution6();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

    public int solution(int[] nums)
    {
        int head = 1, tail = nums.length, sum = nums[0], preMax = nums[0];
        while (head < tail) {
            if (nums[head] < 0  && preMax < sum) {
                preMax = sum;
            }
            if (sum < 0) sum = 0;
            sum += nums[head++];
        }
        if (preMax >= sum ) return preMax;
        return sum;
    }

    /**
     * 我们用dp[n]表示以第n个数结尾的最大连续子序列的和，于是存在以下递推公式：
     * dp[n] = max(0, dp[n-1]) + num[n])
     * @param nums
     * @return
     */
    public int solution1(int[] nums)
    {
        int global = nums[0];
        int local = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            local = Math.max(nums[i],local+nums[i]);
            global = Math.max(local,global);
        }
        return global;
    }

    public int solution2(int[] nums)
    {
        int maxSum = nums[0];
        int tempSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (tempSum > 0)
                tempSum += nums[i];
            else {
                tempSum = nums[i];
            }

            if (tempSum > maxSum) {
                maxSum = tempSum;
                //可以在这里获取最佳连续子序列和的起点位置begin和重点位置i
            }

        }
        return maxSum;
    }

    // *****
    public int solution3(int[] nums)
    {
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];

            if(sum > maxsum)
                maxsum = sum;

            if(sum < 0)
                sum = 0;
        }
        return maxsum;
    }

    int[] num = new int[] {4, 6, -12,1,-3,8,-1,2,1,-7,10};

    public int solution4()
    {
        return solve(0, num.length-1);
    }

    /**
     * 对于一数字序列，其最大连续子序列和对应的子序列可能出现在三个地方。或是整个出现在输入数据的前半部（左），或是整个出现在输入数据的后半部（右），
     * 或是跨越输入数据的中部从而占据左右两半部分。前两种情况可以通过递归求解，第三种情况可以通过求出前半部分的最大和（包含前半部分的最后一个元素）
     * 以及后半部分的最大和（包含后半部分的第一个元素）而得到，然后将这两个和加在一起即可。
     *
     * 首先，我们可以把整个序列平均分成左右两部分，答案则会在以下三种情况中：
     * 1、所求序列完全包含在左半部分的序列中。
     * 2、所求序列完全包含在右半部分的序列中。
     * 3、所求序列刚好横跨分割点，即左右序列各占一部分。
     *
     * 只要计算出:以分割点为起点向左的最大连续序列和、以分割点为起点向右的最大连续序列和，这两个结果的和就是第三种情况的答案
     * @param left
     * @param right
     * @return
     */
    int solve(int left, int right)
    {
        //序列长度为1时
        if(left == right)
            return num[left];

        //划分为两个规模更小的问题
        int mid = left + right >> 1;
        int lans = solve(left, mid);
        int rans = solve(mid + 1, right);

        //横跨分割点的情况
        int sum = 0, lmax = num[mid], rmax = num[mid + 1];
        for(int i = mid; i >= left; i--) {
            sum += num[i];
            if(sum > lmax) lmax = sum;
        }
        sum = 0;
        for(int i = mid + 1; i <= right; i++) {
            sum += num[i];
            if(sum > rmax) rmax = sum;
        }

        //答案是三种情况的最大值
        int ans = lmax + rmax;
        if(lans > ans) ans = lans;
        if(rans > ans) ans = rans;

        return ans;
    }

    /**
     * 已知一个sum数组，sum[i]表示第1个数到第i个数的和，于是sum[j] - sum[i-1]表示第i个数到第j个数的和。
     * 那么，以第n个数为结尾的最大子序列和有什么特点？假设这个子序列的起点是m，于是结果为sum[n] - sum[m-1]。
     * 并且，sum[m]必然是sum[1],sum[2]...sum[n-1]中的最小值！
     * @return
     */
    public int solution5()
    {
        int ans = num[1], lmin = 0;
        for(int i = 1; i < num.length; i++) {
            num[i] += num[i - 1];
            if(num[i] - lmin > ans)
                ans = num[i] - lmin;
            if(num[i] < lmin)
                lmin = num[i];
        }
        return ans;
    }

    /**
     * {-2,1,-3,4,-1,2,1,-5,4};
     *    => => => =>
     */
    public int solution6()
    {
        int s, ans, m = 0;
        ans = s = num[0]; //把ans初始化为序列中的的第一个数
        for(int i = 1; i < num.length; i++) {
            if(s < m) m = s;
            s += num[i];
            if(s - m > ans)
                ans = s - m;
        }
        return ans;
    }
}
