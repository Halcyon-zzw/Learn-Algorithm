package hot.哈希;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 49. 字母异位词分组
 * 中等
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * @author zhuzhiwei
 * @date 2023/10/26 15:28
 */
public class Hot_49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Stream.of(strs).collect(Collectors.groupingBy(
                strArr -> {
                    char[] strChars = strArr.toCharArray();
                    Arrays.sort(strChars);
                    return Arrays.toString(strChars);
                }
        )).values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] charCountArr = new int[26];
            str.chars().forEach(c -> {
                charCountArr[c - 'a'] ++;
            });
            String key = Arrays.toString(charCountArr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            //获取连续最小的值
            if (!set.contains(num - 1)) {
                int tmpRes = 1;
                int curNum = num;
                while (set.contains(++curNum)) {tmpRes ++;}
                res = Math.max(res, tmpRes);
            }
        }
        return res;
    }
}
