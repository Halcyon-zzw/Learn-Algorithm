package interview.interview_0101.impl;

import interview.interview_0101.IsUnique;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-16 17:02
 * @Version: 1.0
 */
public class IsUniqueByBitImpl implements IsUnique {
    @Override
    public boolean isUnique(String s) {
        int mark = 0;
        for (int i = 0; i < s.length(); i++) {
            int moveSize = s.charAt(i) - 'a';
            if (((mark >> moveSize) & 1) == 1) {
                return false;
            }
            mark = mark | (1 << moveSize);
        }
        return true;
    }

    public static void main(String[] args) {
        TestUtils.test(IsUniqueByBitImpl.class, "let");
    }
}
