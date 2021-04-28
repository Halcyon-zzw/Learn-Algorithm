package offer.offer_1_50.offer_46.impl;

import offer.offer_1_50.offer_46.TranslateNum;

/**
 * 递归实现
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 11:19
 * @Version: 1.0
 */
public class TranslateNumByRecursionImpl implements TranslateNum {
    @Override
    public int translateNum(int num) {
        String numStr = num + "";
        return recursion(numStr, 0);
    }

    public int recursion(String numStr, int index) {
        if (index == numStr.length()) {
            return 1;
        }
        int nonCount = recursion(numStr, index + 1);
        if (index < numStr.length() - 1) {
            String substring = numStr.substring(index, index + 2);
            if (newTranslate(substring)) {
                nonCount += recursion(numStr, index + 2);
            }
        }
        return nonCount;
    }

    private boolean newTranslate(String s) {
        if (s == "0") {
            return true;
        }
        if (s.startsWith("0")) {
            return false;
        }
        if (s.compareTo("0") > 0 && s.compareTo("25") <= 0) {
            return true;
        }
        return false;
    }
}
