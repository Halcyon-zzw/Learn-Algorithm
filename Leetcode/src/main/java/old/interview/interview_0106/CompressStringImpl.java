package interview.interview_0106;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-18 16:51
 * @Version: 1.0
 */
public class CompressStringImpl implements CompressString {
    @Override
    public String compressString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
                continue;
            }else {
                sb.append(c + "" + count);
                count = 1;
                c = s.charAt(i);
            }
        }
        sb.append(c + "" + count);
        String result = sb.toString();
        return result.length() >= s.length() ? s : result;
    }


}
