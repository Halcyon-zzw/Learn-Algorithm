package old.offer.offer_1_50.offer_46;

/**
 * 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 11:17
 * @Version: 1.0
 */
public interface TranslateNum {
    int translateNum(int num);
}
