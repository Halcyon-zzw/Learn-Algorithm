package hot.normal_49;

import java.util.List;

/**
 * 49. 字母异位词分组
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * @author zhuzhiwei
 * @date 2023/10/26 15:28
 */
public interface GroupAnagrams {
    List<List<String>> groupAnagrams(String[] strs);
}
