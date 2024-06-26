package hot.数学;

/**
 * 172. 阶乘后的零
 * 中等
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 *
 * 提示：
 * 0 <= n <= 10^4
 *
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 *
 * @author zhuzhiwei
 * @date 2024/4/11 20:26
 */
public class Hot_172_阶乘后的零 {
    /**
     * 产生0的情况：
     * 只有因子2 * 5才能才是0，题解可分解为n!能分解多少个2 * 5
     * 其中每两个数可分解一个2，如2、4、6...
     * 每5个数才能分解一个5，如5、10、15...
     * 所以2的个数一定大于5的个数，所以可转换为能分解多少个因子5。
     *
     * f(n) = n / 5。表示[1, n]中能被5整除的个数
     *
     * 以阶乘1000为例：
     * f(1000) = 1000 / 5 = 200;
     *      => 即[1, 1000]能被5整除的数一共200个（每五个数出现一次）：5、10、15...995、1000
     *      而这200个数中，提取因子5后变成1、2、3...199、200
     *      变成了求f(1000 / 5 = 200)
     * f(200) = 200 / 5 = 40
     *      => [1, 200]中能被5整除的数一共40个：5、10...195、200
     *      提取因子5后变成：1、2、3...39、40
     *      变成求f(200 / 5 = 40)
     * 以此类推，依次求f(200 / 5 = 40)、f(40 / 5 = 8)、f(8 / 5 = 1)、f(1 / 5 = 0)直到n = 0结束
     * 对于上述所有的结果求和。
     *
     *
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
