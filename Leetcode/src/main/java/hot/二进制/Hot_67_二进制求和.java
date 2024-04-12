package hot.二进制;

/**
 * 67. 二进制求和
 * 简单
 *
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 *
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 10^4
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 *
 * @author zhuzhiwei
 * @date 2024/4/11 13:47
 */
public class Hot_67_二进制求和 {
    /**
     * 从后往前计算，注意进位
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int aIndex = a.length() - 1, bIndex = b.length() - 1;
        //进位
        int other = 0;
        StringBuilder reverseBinary = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int aValue = 0, bValue = 0;
            if (aIndex >= 0) {
                aValue = a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >= 0) {
                bValue = b.charAt(bIndex) - '0';
                bIndex--;
            }
            int sum = aValue + bValue + other;
            other = sum / 2;
            int result = sum % 2;
            reverseBinary.append(result);
        }
        if (other > 0) {
            reverseBinary.append(other);
        }
        return reverseBinary.reverse().toString();
    }
}
