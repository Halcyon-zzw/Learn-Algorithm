package old.offer.offer_59_II;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 *
 * <p>
 *     请定义一个队列并实现函数 max_value 得到队列里的最大值，
 *     要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 *      若队列为空，pop_front 和 max_value 需要返回 -1
 * </p>
 *
 * <p>
 *     本算法基于问题的一个重要性质：
 *     当一个元素进入队列的时候，它前面所有比它小的元素就不会再对答案产生影响。
 *
 * 举个例子，如果我们向队列中插入数字序列 1 3 4 5 7，那么在第一个数字 7 被插入后，
 * 数字 2 前面的所有数字 1 将不会对结果产生影响。
 * 因为按照队列的取出顺序，数字 2 只能在所有的数字 1 被取出之后才能被取出，
 * 因此如果数字 1 如果在队列中，那么数字 2 必然也在队列中，使得数字 1 对结果没有影响。
 *
 * 从队列尾部插入元素时，
 * 我们可以提前取出队列中所有比这个元素小的元素，使得队列中只保留对结果有影响的数字。
 * 这样的方法等价于要求维持队列单调递减，即要保证每个元素的前面都没有比它小的元素。
 *
 *
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 14:16
 * @Version: 1.0
 */
public class MaxQueue {
    //原始顺序的队列
    Queue<Integer> originalQueue = new LinkedList<>();
    //保证有序的队列
    Deque<Integer> orderDeque = new LinkedList<>();
    public MaxQueue() {

    }

    public int max_value() {
        if (orderDeque.isEmpty()) {
            return -1;
        }
        return orderDeque.peekFirst();
    }

    public void push_back(int value) {
        originalQueue.offer(value);
        while (!orderDeque.isEmpty() && orderDeque.peekLast() < value) {
            orderDeque.pollLast();
        }
        orderDeque.addLast(value);
    }

    public int pop_front() {
        if (originalQueue.isEmpty()) {
            return -1;
        }
        Integer poll = originalQueue.poll();
        if (poll.equals(orderDeque.peekFirst())) {
            orderDeque.pollFirst();
        }
        return poll;
    }
}
