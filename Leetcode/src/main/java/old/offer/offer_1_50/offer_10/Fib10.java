package old.offer.offer_1_50.offer_10;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 16:06
 * @Version: 1.0
 */
public class Fib10 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int result = fib(n - 1) + fib(n - 2);
        if (result > 1000000007) {
            result -= 1000000007;
        }
        return result;
    }

    /**
     * 通过动态规则解答
     * 状态定义：设dp为一维数组，dp[i]的值代表fib(i)
     * 转移方程：dp[i] = dp[i - 1] + dp [i - 2]
     * 初始状态：dp[0] = 0; dp[1] = 1
     * 返回值：dp[n]
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int lastSecond = 0;
        int lastFirst = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            //大数越界： 随着 nn 增大, f(n)f(n) 会超过 Int32 甚至 Int64 的取值范围，导致最终的返回值错误。
            result = (lastSecond + lastFirst) % 1000000007;
            lastSecond = lastFirst;
            lastFirst = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Fib10 fib10 = new Fib10();
        int i = fib10.fib2(45);
        System.out.println(i);

        int fib = fib10.fib(45);
        System.out.println(fib);
    }
}
