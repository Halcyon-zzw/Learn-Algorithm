package old.offer.offer_1_50.offer_09;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 15:49
 * @Version: 1.0
 */
public class Queue09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Queue09() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            //stack1中没有数据
            return -1;
        }else {
            return stack2.pop();
        }
    }

}
