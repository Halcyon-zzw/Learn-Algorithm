package offer.offer_1_50.offer_38.impl;

import offer.offer_1_50.offer_38.Permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 回溯法
 *
 * 将数组按个赋值到数组指定位置，用visited数组判断是否已经排列过
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 15:53
 * @Version: 1.0
 */
public class PermutationByRecursionImpl implements Permutation {
    List<String> result = new ArrayList<>();
    char[] resultArr;
    char[] arr;
    @Override
    public String[] permutation(String s) {
        if (s == null) {
            return null;
        }
        resultArr = new char[s.length()];
        boolean[] visitedArr = new boolean[s.length()];
        arr = s.toCharArray();
        dfs(visitedArr, 0);
        return result.toArray(new String[0]);
    }

    /**
     *
     * @param visitedArr 是否已处理
     * @param index 赋值的位置
     */
    public void dfs(boolean[] visitedArr, int index) {
        if (index == arr.length) {
            result.add(new String(resultArr));
            return;
        }
        //用于判断当前层是否出现相同的字符
        Set<Character> set = new HashSet<>();
        //将数组固定到当前位置
        for (int i = 0; i < arr.length; i++) {
            if (visitedArr[i] || set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            resultArr[index] = arr[i];
            visitedArr[i] = true;
            dfs(visitedArr, index + 1);
            visitedArr[i] = false;
        }
    }
}
