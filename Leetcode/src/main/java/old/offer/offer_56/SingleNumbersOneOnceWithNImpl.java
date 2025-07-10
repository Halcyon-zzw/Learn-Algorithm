package old.offer.offer_56;

/**
 * <p>
 *     一个整型数组 nums 里除一个数字出现一次之外，其他数字都出现了3次。
 *      要求时间复杂度是O(n)，空间复杂度是O(1)。
 * </p>
 *
 * <p>
 *     统计每个位置上1出现的数量，然后%3即是最后的结果
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 17:23
 * @Version: 1.0
 */
public class SingleNumbersOneOnceWithNImpl implements OneOnceWithNOther {
    @Override
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];

        for (int num : nums) {
            int mark = 1;
            for (int i = 0; i < 32; i++) {
                if ((num & mark) == mark) {
                    arr[i] ++;
                }
                mark = mark << 1;
            }
        }
        int m = 3;
        //还原
//        StringBuffer sb = new StringBuffer();
//        for (int i = arr.length - 1; i >= 0; i--) {
//            sb.append(arr[i] % m);
//        }
//        return Integer.parseUnsignedInt(sb.toString(), 2);
        //还原
        int res = 0, mark = 1;
        for (int i = 0; i < 32; i++) {
            if (arr[i] % m == 1) {
                res |= mark;
            }
            mark <<= 1;
        }
        return res;
    }
}
