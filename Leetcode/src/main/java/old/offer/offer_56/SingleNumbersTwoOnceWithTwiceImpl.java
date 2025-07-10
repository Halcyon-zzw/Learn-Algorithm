package old.offer.offer_56;

/**
 * <p>
 *     一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 *      要求时间复杂度是O(n)，空间复杂度是O(1)。
 * </p>
 * 
 * 异或实现
 *
 * <p>
 *     知识点：
 *     1、x^x = 0;
 *     2、x^0 = x;
 *     3、异或的结果可以理解为数位不同的结果，如：
 *          110 ^ 001 = 111
 *          101 ^ 100 = 011
 *
 *      => 所有数的异或 = 最后两个数的异或
 *      => 将两个数字按照某位不同（所有数字异或结果得出）分成两组;每个组异或后即是最后的结果
 * </p>
 *
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 13:28
 * @Version: 1.0
 */
public class SingleNumbersTwoOnceWithTwiceImpl implements SingleNumbers {
    @Override
    public int[] singleNumbers(int[] nums) {
        int xorResult = 0;

        for (int num : nums) {
            xorResult ^= num;
        }
        //找到某位不同的标识
        int mark = 1;
        while ((xorResult & mark) == 0) {
            mark = mark << 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mark) == 0) {
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
