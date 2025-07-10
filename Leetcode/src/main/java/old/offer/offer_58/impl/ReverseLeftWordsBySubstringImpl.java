package old.offer.offer_58.impl;

import old.offer.offer_58.ReverseLeftWords;

/**
 * 通过内置切割函数
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 10:52
 * @Version: 1.0
 */
public class ReverseLeftWordsBySubstringImpl implements ReverseLeftWords {
    @Override
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
