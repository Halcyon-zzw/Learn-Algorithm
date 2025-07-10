package interview.interview_0103.impl;

import interview.interview_0103.ReplaceSpaces;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-16 17:26
 * @Version: 1.0
 */
public class ReplaceSpacesImpl implements ReplaceSpaces {
    @Override
    public String replaceSpaces(String s, int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
