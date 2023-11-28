package hot.回溯;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author zhuzhiwei
 * @date 2023/11/23 19:56
 */
public class Hot_46_全排列 {

    private final List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] usedFlagArr = new int[nums.length];

        List<Integer> eachList = new ArrayList<>();

        dfs(eachList, usedFlagArr, nums);
        return resultList;
    }

    private void dfs(List<Integer> eachList, int[] usedFlagArr, int[] nums) {
        if (eachList.size() == nums.length) {
            resultList.add(new ArrayList<>(eachList));
            return;
        }
        for (int i = 0; i < usedFlagArr.length; i++) {
            //没有使用
            if (usedFlagArr[i] == 0) {
                eachList.add(nums[i]);
                usedFlagArr[i] = 1;
                dfs(eachList, usedFlagArr, nums);
                //换个数，清除标记
                eachList.remove(eachList.size() - 1);
                usedFlagArr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = new Hot_46_全排列().permute(nums);

        System.out.println(ArrayUtils.toString(permute));
    }
}
