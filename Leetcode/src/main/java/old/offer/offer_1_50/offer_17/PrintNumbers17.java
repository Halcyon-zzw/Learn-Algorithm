package old.offer.offer_1_50.offer_17;

import java.util.Arrays;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-19 18:18
 * @Version: 1.0
 */
public class PrintNumbers17 {
    int[] resultArr;
    int index = 0;
    /**
     * 全排列实现
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        resultArr = new int[(int) Math.pow(10, n) - 1];

        for (int digit = 1; digit <= n; digit++) {
            for (char i = '1'; i <= '9'; i++) {
                char[] number = new char[digit];
                number[0] = i;
                dfs(number, digit, 1);
            }
        }
        return resultArr;
    }

    void dfs(char[] number, int digit, int i) {
        if (digit == i) {
            //完成
            resultArr[index++] = Integer.parseInt(String.valueOf(number));
            return;
        }
        for (char j = '0'; j <= '9'; j++) {
            number[i] = j;
            dfs(number, digit, i + 1);
        }
    }

    public static void main(String[] args) {
        PrintNumbers17 printNumbers17 = new PrintNumbers17();
        int[] ints = printNumbers17.printNumbers(1);
        Arrays.stream(ints).forEach(System.out::print);
        System.out.println();

    }
}
