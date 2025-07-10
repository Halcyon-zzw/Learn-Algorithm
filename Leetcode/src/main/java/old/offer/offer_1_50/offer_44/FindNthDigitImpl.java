package old.offer.offer_1_50.offer_44;

import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 14:04
 * @Version: 1.0
 */
public class FindNthDigitImpl implements FindNthDigit {
    @Override
    public int findNthDigit(int n) {
        //digit表示当前的位数，num表示一个数，start表示当前数的第几位
        //sum表示前digit位数的数位个数和
        int digit = 1, num, start, sum = 0;
        //确定位数
        while (true) {
            int cur = (int) (digit * (Math.pow(10, digit) - Math.pow(10, digit - 1)));
            if (n > cur) {
                n -= cur;
            }else {
                break;
            }
            digit++;
        }
        if (digit == 1) {
            return n;
        }
        //确定是那个数，以digit=3为例，从100开始，所以需要-1
        num = (n - 1) / digit + (int) Math.pow(10, digit - 1);
        //确定当前数的第几位
        start = (n - 1) % digit;
        return (num + "").charAt(start) - '0';
    }

    public static void main(String[] args) {
        TestUtils.test(FindNthDigitImpl.class, 10000);
    }
}
