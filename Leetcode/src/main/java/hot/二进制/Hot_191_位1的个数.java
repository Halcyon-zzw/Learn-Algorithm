package hot.二进制;

/**
 * 191. 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中
 * 设置位
 *  的个数（也被称为汉明重量）。
 *
 *
 *
 * 示例 1：
 * 输入：n = 11
 * 输出：3
 * 解释：输入的二进制串 1011 中，共有 3 个设置位。
 *
 * 示例 2：
 * 输入：n = 128
 * 输出：1
 * 解释：输入的二进制串 10000000 中，共有 1 个设置位。
 *
 * 示例 3：
 * 输入：n = 2147483645
 * 输出：30
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 30 个设置位。
 *
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 *
 * 进阶：
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * @author zhuzhiwei
 * @date 2024/4/11 14:39
 */
public class Hot_191_位1的个数 {
    /**
     * 每次向右移动一位，判断末尾是否是1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = n; i != 0; i >>= 1) {
            if ((i & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * n & (n - 1) => 将末尾的0置为0
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
