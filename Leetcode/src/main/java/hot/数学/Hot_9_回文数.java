package hot.数学;

/**
 * 9. 回文数
 * 简单
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 *  回文数
 * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 *
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 *
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * @author zhuzhiwei
 * @date 2024/4/11 18:58
 */
public class Hot_9_回文数 {

    /**
     * 将数字转为字符串，通过左右指针判断是否相等
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = x + "";
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }


    /**
     * 不将数字转为字符串
     *
     * 反转数字，比较反转后的数字是否相等。
     * 但是int最大值为2147483647，反转所有会溢出，所以可以反转一半。
     *
     * reverseNum初始为0
     * 反转：reverseNum = reverseNum * 10 + x % 10;
     * 原num /= 10
     * 反转终止条件：原num <= 反转后的num
     *
     * 处理特殊情况：num的长度为奇数
     *
     *
     * return 原num = 反转后的num
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        //负数一定回文数、最后一位是0的非0数不是回文数
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            //最后一位数
            int tail = x % 10;
            reverseNum = reverseNum * 10 + tail;
            x = x / 10;
        }
        //x长度为奇数时，去除反转后reverseNum最后一个数字: reverseNum / 10
        //如12321，x = 12，reverseNum = 123
        return x == reverseNum || x == reverseNum / 10;
    }
}
