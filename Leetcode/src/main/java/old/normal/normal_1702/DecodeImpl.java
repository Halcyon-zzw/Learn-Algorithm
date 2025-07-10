package normal.normal_1702;

import mode.ListNode;

/**
 * 异或操作符合交换律和结合律
 *
 * @Author: zhuzw
 * @Date: 2021-05-06 16:58
 * @Version: 1.0
 */
public class DecodeImpl implements Decode {
    @Override
    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = encoded[i - 1] ^ result[i - 1];
        }

        return result;
    }


}
