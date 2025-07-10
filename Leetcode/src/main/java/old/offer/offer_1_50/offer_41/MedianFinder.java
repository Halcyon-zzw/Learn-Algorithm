package old.offer.offer_1_50.offer_41;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据中的中位数
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 18:44
 * @Version: 1.0
 */
public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>();   //小顶堆，保留较大数
        B = new PriorityQueue<>((o1, o2) -> o2 - o1);   //大顶堆，保留较小数
    }

    public void addNum(int num) {
        //A.size >= B.size
        if (A.size() == B.size()) {
            //将B中最大加入A
            B.offer(num);
            A.offer(B.poll());
        }else {
            //将A中最小加入B
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double findMedian() {
        if (A.size() == B.size()) {
            return (A.peek() + B.peek()) / 2.0;
        }else {
            return A.peek();
        }
    }
}
