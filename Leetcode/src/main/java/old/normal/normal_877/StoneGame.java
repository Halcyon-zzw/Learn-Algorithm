package normal.normal_877;

/**
 * 石子游戏
 *
 * <p>
 *     偶数堆石子排成一行，每堆都有正整数颗石子
 *     游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-06-16 10:52
 * @Version: 1.0
 */
public interface StoneGame {
    boolean stoneGame(int[] piles);
}
