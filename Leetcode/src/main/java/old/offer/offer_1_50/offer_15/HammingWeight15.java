package old.offer.offer_1_50.offer_15;

/**
 * 二进制中1的个数
 *
 * @Author: zhuzw
 * @Date: 2021-04-19 16:45
 * @Version: 1.0
 */
public class HammingWeight15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
