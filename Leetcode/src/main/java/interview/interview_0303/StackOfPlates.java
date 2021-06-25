package interview.interview_0303;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 14:33
 * @Version: 1.0
 */
public class StackOfPlates {
    private int cap;
    List<Stack<Integer>> list = new ArrayList<>();
    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        if (list.size() == 0 || list.get(list.size() - 1).size() == cap) {
            list.add(new Stack<>());
        }
        Stack<Integer> stack = list.get(list.size() - 1);
        stack.push(val);
    }

    public int pop() {
        if (list.size() == 0) {
            return -1;
        }
        Stack<Integer> stack = list.get(list.size() - 1);
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            list.remove(list.size() - 1);
        }
        return pop;
    }

    public int popAt(int index) {
        if (index < 0 || index > list.size()) {
            return -1;
        }
        Stack<Integer> stack = list.get(index);
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            list.remove(index);
        }
        return pop;
    }
}
