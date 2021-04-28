package offer.offer_1_50.offer_20;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 8:57
 * @Version: 1.0
 */
public class IsNumber20 {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean number_able = true;
        boolean sign_able = true;
        boolean e_able = false;
        boolean point_able = true;
        boolean point_global_able = true;
        boolean e_global_able = true;

        //表示接收下一个字符后，是否为一个正确的数字
        boolean isNumber = false;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                if (number_able) {
                    number_able = true;
                    sign_able = false;
                    point_able = true;
                    e_able = true;
                    isNumber = true;
                } else {
                    return false;
                }
            }else if (c == '+' || c == '-') {
                if (sign_able) {
                    number_able = true;
                    sign_able = false;
                    e_able = false;
                    point_able = true;
                    isNumber = false;
                }else {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (e_able && e_global_able) {
                    number_able = true;
                    sign_able = true;
                    e_global_able = false;
                    point_global_able = false;
                    isNumber = false;
                }else {
                    return false;
                }
            }else if (c == '.') {
                if (point_able && point_global_able) {
                    number_able = true;
                    sign_able = false;
//                    e_able = false;
                    point_global_able = false;
                    //出现小数点取决于上一次的状态
//                    if (i != 0 && i == s.length() - 1) {
//                        //. 在末位，且不在首位
//                        isNumber = true;
//                    }else {
//                        isNumber = false;
//                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
            i++;
        }
        return isNumber;
    }

    public static void main(String[] args) {
        IsNumber20 isNumber20 = new IsNumber20();
        String[] arr = {"+100","5e2","-123","3.1416","-1E-16","0123", "1 ", ".1", "3.", "+.8", "46.e3",
                "123", "12e","1a3.14","1.2.3","+-5","12e+5.4", ".", "4e+", " -."};
        for (String s : arr) {
            boolean number = isNumber20.isNumber(s);
            System.out.println(s + ":" + number);
        }
        String s = "";
        boolean number = isNumber20.isNumber(s);
        System.out.println(s + ":" + number);
    }
}
