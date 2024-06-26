package hot.数学;

import utils.ArrayUtils;

/**
 * 66. 加一
 * 简单
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author zhuzhiwei
 * @date 2024/4/11 19:36
 */
public class Hot_66_加一 {
    /**
     * 注意进位和第一个数字的进位
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        //进位
        int other = 1;
        result[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i] = digits[i] + other;
            other = result[i] / 10;
            result[i] = result[i] % 10;
        }
        if (other != 0) {
            //还有进位 最终的结果为100...00
            result = new int[result.length + 1];
            result[0] = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        int[] ints = new Hot_66_加一().plusOne(arr);
        System.out.println(ArrayUtils.toString(ints));
    }
}
