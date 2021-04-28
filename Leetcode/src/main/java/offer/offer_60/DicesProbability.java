package offer.offer_60;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 *
 * 输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 14:42
 * @Version: 1.0
 */
public interface DicesProbability {
    double[] dicesProbability(int n);
}
