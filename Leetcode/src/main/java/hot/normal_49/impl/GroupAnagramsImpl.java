package hot.normal_49.impl;

import hot.normal_49.GroupAnagrams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author zhuzhiwei
 * @date 2023/10/26 15:29
 */
public class GroupAnagramsImpl implements GroupAnagrams {
    @Override
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
