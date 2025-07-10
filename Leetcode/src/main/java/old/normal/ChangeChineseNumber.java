package normal;

/**
 * 数字转中文表示
 *
 * @Author: zhuzw
 * @Date: 2021-06-04 9:46
 * @Version: 1.0
 */
public class ChangeChineseNumber {
    String[] changeArr = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", };
    String[] unitChangeArr = {"", "十", "百", "千"};
    String[] unitChangeArr2 = {"", "万", "亿"};
    public String change(double num) {
        String s = num + "";
        String[] splitArr = s.split("\\.");
        String intStr = splitArr[0];
        String decimalStr = splitArr.length > 1 ? splitArr[1] : "";

        intStr = changeIntStr(intStr);
        if (decimalStr != null) {
            decimalStr = "点" + changeDecimalStr(decimalStr);
        }
        return intStr + decimalStr;
    }

    private String changeIntStr(String intStr) {
        String result = "";

        int unitIndex = 0, j = 0;
        for (int i = intStr.length() - 1; i >= 0 ; i--) {
            int num = Integer.parseInt(intStr.charAt(i) + "");
            String numStr = "";
            if (num == 0) {
                if (i == intStr.length() - 1 || (i < intStr.length() - 1 && intStr.charAt(i + 1) == '0')) {
                    numStr = "";
                }else {
                    numStr = change(num);
                }
            }else {
                numStr = change(num);
            }

            String unit = num == 0 ? "" : unitChangeArr[unitIndex % 4];
            String unit2 = "";
            if (unitIndex % 4 == 0) {
                unit2 = unitChangeArr2[j++];
            }
            unitIndex ++;
            result = numStr + unit + unit2 + result;
        }
        return result;
    }

    private String changeDecimalStr(String decimalStr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < decimalStr.length(); i++) {
            int num = Integer.parseInt(decimalStr.charAt(i) + "");
            sb.append(change(num));
        }
        return sb.toString();
    }



    public String change(int num) {
        if (num <0 || num > 9) {
            return null;
        }
        return changeArr[num];
    }


    public static void main(String[] args) {
        ChangeChineseNumber changeChineseNumber = new ChangeChineseNumber();
        String change = changeChineseNumber.change(100400.234);
        System.out.println(change);
    }
}
