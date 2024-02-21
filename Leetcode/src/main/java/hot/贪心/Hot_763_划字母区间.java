package hot.贪心;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 中等
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 *
 * 示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 *
 * @author zhuzhiwei
 * @date 2024/2/21 16:04
 */
public class Hot_763_划字母区间 {
    /**
     * 维护一个数组，记录每个字母的最大下标
     *
     * 遍历字符串，当前区间为，[起始位置,该区间内字母的最大小标]
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] charMaxIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            charMaxIndex[chars[i] - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(charMaxIndex[chars[i] - 'a'], end);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        List<Integer> integers = new Hot_763_划字母区间().partitionLabels(s);
        System.out.println(ArrayUtils.toString(integers));
    }
}
