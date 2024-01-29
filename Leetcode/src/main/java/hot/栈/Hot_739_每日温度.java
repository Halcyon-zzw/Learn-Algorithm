package hot.栈;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * @author zhuzhiwei
 * @date 2023/12/27 11:07
 */
public class Hot_739_每日温度 {
    /**
     * 栈内维护从栈底到栈顶单调递减的下标
     * for i in temperatures
     *      if temp[i] > 栈顶元素
     *          出栈直到temp[i] < 栈顶元素;最后将当前index入栈
     *          并将结果赋值为 i - 栈内下标
     *      else
     *          入栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] resultArr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer popIndex = stack.pop();
                resultArr[popIndex] = i - popIndex;
            }
            stack.push(i);

        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        int[] resultArr = new Hot_739_每日温度().dailyTemperatures(arr);
        System.out.println(ArrayUtils.toString(resultArr));
    }
}
