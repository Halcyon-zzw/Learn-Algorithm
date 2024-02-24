package hot.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 简单
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 提示:
 * 1 <= numRows <= 30

 *
 * @author zhuzhiwei
 * @date 2024/2/21 22:10
 */
public class Hot_118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> earchList = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    //第一个数和最后一个数为1
                    earchList.add(1);
                } else {
                    //上一行
                    List<Integer> lastList = result.get(i - 1);
                    earchList.add(lastList.get(j - 1) + lastList.get(j));
                }
            }
            result.add(earchList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = new Hot_118_杨辉三角().generate(5);
        System.out.println(generate);
    }
}
