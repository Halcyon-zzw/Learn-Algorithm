package offer.offer_58.impl;

import offer.offer_58.ReverseLeftWords;

/**
 * 遍历字符串实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 10:53
 * @Version: 1.0
 */
public class ReverseLeftWordsByTraverseImpl implements ReverseLeftWords {
    @Override
    public String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
