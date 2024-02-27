package normal.多线程;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1117. H2O 生成
 * 中等
 *
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 *
 * 换句话说:
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 *
 *
 *
 * 示例 1:
 * 输入: water = "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 *
 * 示例 2:
 * 输入: water = "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 *
 *
 * 提示：
 * 3 * n == water.length
 * 1 <= n <= 20
 * water[i] == 'O' or 'H'
 * 输入字符串 water 中的 'H' 总数将会是 2 * n 。
 * 输入字符串 water 中的 'O' 总数将会是 n 。
 *
 * @author zhuzhiwei
 * @date 2024/2/25 20:28
 */
public class Thread_1117_H2O生成 {
    public static void main(String[] args) {

    }
}

class H2O {

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }
}

class H2OSemaphore1 {

    private Semaphore hSemaphore = new Semaphore(2);

    private volatile int hCount = 0;

    private Semaphore oSemaphore = new Semaphore(1);

    public H2OSemaphore1() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire(2);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hCount++;
        //没两个h元素可产生一个O元素
        if (hCount % 2 == 0) {
            oSemaphore.release();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hSemaphore.release(2);
    }
}

class H2OSemaphore2 {

    private Semaphore hSemaphore = new Semaphore(2);


    private Semaphore oSemaphore = new Semaphore(0);

    public H2OSemaphore2() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oSemaphore.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hSemaphore.release(2);
    }
}

class H2OSemaphoreCyclicBarrier {
    private Semaphore hSemaphore = new Semaphore(2);
    private Semaphore oSemaphore = new Semaphore(1);
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public H2OSemaphoreCyclicBarrier() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        releaseHydrogen.run();
        hSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        releaseOxygen.run();
        oSemaphore.release();
    }
}

class H2OBlockingQueue {

    private BlockingQueue<Integer> hBlockingQueue = new LinkedBlockingDeque<>(2);
    private BlockingQueue<Integer> oBlockingQueue = new LinkedBlockingDeque<>(1);

    private volatile int count = 0;
    public H2OBlockingQueue() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hBlockingQueue.put(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        count++;
        if (count == 3) {
            hBlockingQueue.clear();
            oBlockingQueue.clear();
            count = 0;
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oBlockingQueue.put(1);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        count++;
        if (count == 3) {
            hBlockingQueue.clear();
            oBlockingQueue.clear();
            count = 0;
        }
    }
}


class H2OSynchronized {
    private Object lockObj = new Object();

    private volatile int hCount = 2;

    public H2OSynchronized() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lockObj) {
            if (hCount == 0) {
                wait();
            }
            releaseHydrogen.run();
            hCount--;
            notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lockObj) {
            if (hCount != 2) {
                wait();
            }
            releaseOxygen.run();
            hCount = 2;
            notifyAll();
        }
    }
}

class H2OReentrantLock {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private volatile int hCount = 0;
    private volatile int oCount = 0;

    public H2OReentrantLock() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (hCount == 2) {
                condition.await();
            }
            releaseHydrogen.run();
            hCount++;
            if (hCount == 2 && oCount == 1) {
                hCount = 0;
                oCount = 0;
            }
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (oCount == 1) {
                condition.await();
            }
            releaseOxygen.run();
            oCount++;
            if (hCount == 2 && oCount == 1) {
                hCount = 0;
                oCount = 0;
            }
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


