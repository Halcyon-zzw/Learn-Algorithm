package old.offer.offer_1_50.offer_31.impl;

import old.offer.offer_1_50.offer_31.ValidateStackSequences;

import java.util.Stack;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 15:23
 * @Version: 1.0
 */
public class ValidateStackSequencesImpl implements ValidateStackSequences {
    @Override
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int pushVal : pushed) {
            stack.push(pushVal);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[index]) {
                return false;
            }
        }
        return true;
    }
}
