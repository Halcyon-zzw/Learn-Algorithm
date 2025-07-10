package old.offer.offer_1_50.offer_46.impl;

import old.offer.offer_1_50.offer_46.TranslateNum;

/**
 * 设f(i) 位前i位翻译的数量
 * f(i) = {
 *     if (val[i-1] & val[i] 能翻译成新的值)
 *          f(i) = f(i - 1) + f(i - 2)
 *     else
 *          f(i) = f(i - 1)
 * }
 * 初始值:
 *  f(0) = 1;
 *  f(1) = 1;
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 15:08
 * @Version: 1.0
 */
public class TranslateNumByDynamicImpl implements TranslateNum {
    @Override
    public int translateNum(int num) {
//        String numStr = num + "";
//        int[] arr = new int[numStr.length() + 1];
//        arr[0] = 1;
//        arr[1] = 1;
//        char[] chars = numStr.toCharArray();
//        for (int i = 1; i < chars.length; i++) {
//            if (newTranslate( numStr.substring(i - 1, i + 1))) {
//                arr[i + 1] = arr[i] + arr[i - 1];
//            }else {
//                arr[i + 1] = arr[i];
//            }
//        }
//        return arr[chars.length];
        String numStr = num + "";
        int preOne = 1;
        int preTwo = 1;
        //判断长度为1的情况
        int result = preOne;

        char[] chars = numStr.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (newTranslate( numStr.substring(i - 1, i + 1))) {
                result = preOne + preTwo;
            }else {
                result = preOne;
            }
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    private boolean newTranslate(String s) {
        if (s.compareTo("10") >= 0 && s.compareTo("25") <= 0) {
            return true;
        }
        return false;
    }
}
