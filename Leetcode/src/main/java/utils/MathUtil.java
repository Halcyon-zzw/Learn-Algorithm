package utils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-15 14:09
 * @Version: 1.0
 */
public class MathUtil {

    /**
     * 辗转相除法求最大公因数
     * gcd(a, b) = gcd(b, a mod b)
     * @return
     */
    public static long gcb(long a, long b) {
        long mod;
        while (true) {
            mod = a % b;
            if (mod == 0) {
                break;
            }
            a = b;
            b = mod;
        }
        return b;
    }

    /**
     * 最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    public static long lcm(long a, long b) {
        return a * b / gcb(a, b);
    }

    /**
     * 数位之和
     * @param num
     * @return
     */
    public static int addEachLocation(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static int max(int ... nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
