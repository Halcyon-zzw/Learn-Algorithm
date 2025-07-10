package normal.normal_877.impl;

import normal.normal_877.StoneGame;
import utils.TestUtils;

/**
 * 待完善
 *
 * @Author: zhuzw
 * @Date: 2021-06-16 10:53
 * @Version: 1.0
 */
public class StoneGameImpl implements StoneGame {
    @Override
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles .length == 0) {
            return false;
        }
        int i = 0, j = piles.length - 1, sum = 0;
        while (i <= j) {
            if (piles[i] > piles[j]) {
                sum += piles[i++];
            }else {
                sum += piles[j--];
            }
            if (i > j) {
                break;
            }
            if (piles[i] > piles[j]) {
                sum -= piles[i++];
            }else {
                sum -= piles[j--];
            }
        }
        return sum > 0;
    }

    public static void main(String[] args) {
        TestUtils.test(StoneGameImpl.class, new int[]{3, 2, 10, 4});
    }
}
