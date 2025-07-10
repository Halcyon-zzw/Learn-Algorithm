package old.offer.offer_1_50.offer_14;

import java.math.BigInteger;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-19 14:38
 * @Version: 1.0
 */
public class CuttingRope1401 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        //绳子的长度
        for (int i = 3; i <= n; i++) {
            //从长度=2开始减
            for (int j = 2; j < i; j++) {
                int cur_dp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(cur_dp, dp[i]);
            }
        }
        return dp[n];
    }

    public int cuttingRopeBigInteger(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(1);
        //绳子的长度
        for (int i = 3; i <= n; i++) {
            dp[i] = BigInteger.valueOf(0);
            //从长度=2开始减
            for (int j = 2; j < i; j++) {
                BigInteger cur_dp = BigInteger.valueOf(j * (i - j)).max(dp[i - j].multiply(BigInteger.valueOf(j)));
                dp[i] = cur_dp.max(dp[i]);
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        CuttingRope1401 cuttingRope1401 = new CuttingRope1401();
        int result = cuttingRope1401.cuttingRopeBigInteger(1000);
        System.out.println(result);
    }
}
