package normal.normal_2609;

/**
 * 2609. 最长平衡子字符串
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 *
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 *
 * 返回  s 中最长的平衡子字符串长度。
 *
 * 子字符串是字符串中的一个连续字符序列。
 *
 * @author zhuzhiwei
 * @date 2023/11/8 14:47
 */
public interface Solution2609 {
    int findTheLongestBalancedSubstring(String s);
}
