package normal.多线程;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 * 中等
 * 现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
 *
 * 例如，调用 printNumber(7) 将会输出 7 到控制台。
 * 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
 *
 * 线程 A：调用 zero() ，只输出 0
 * 线程 B：调用 even() ，只输出偶数
 * 线程 C：调用 odd() ，只输出奇数
 * 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
 *
 * 实现 ZeroEvenOdd 类：
 *
 * ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
 * void zero(printNumber) 调用 printNumber 以输出一个 0 。
 * void even(printNumber) 调用printNumber 以输出偶数。
 * void odd(printNumber) 调用 printNumber 以输出奇数。
 *
 *
 * 示例 1：
 * 输入：n = 2
 * 输出："0102"
 * 解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 *
 * 示例 2：
 * 输入：n = 5
 * 输出："0102030405"
 *
 * @author zhuzhiwei
 * @date 2024/2/24 18:12
 */
public class Thread_1116_打印零与奇偶数 {

    public static void main(String[] args) {
//        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
//        ZeroEvenOddLock zeroEvenOdd = new ZeroEvenOddLock(10);
//        ZeroEvenOddYield zeroEvenOdd = new ZeroEvenOddYield(10);
//        ZeroEvenOddLockSupport zeroEvenOdd = new ZeroEvenOddLockSupport(10);
        ZeroEvenOddLock zeroEvenOdd = new ZeroEvenOddLock(10);
        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(n -> System.out.print(0));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(n -> System.out.print(n));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(n -> System.out.print(n));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/**
 * 使用BlockingQueue、CyclicBarrier思路与Semaphare相同
 */
class ZeroEvenOddSemaphore {
    //输出0的信号量
    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore oddSemaphore = new Semaphore(0);
    private Semaphore evenSemaphore = new Semaphore(0);

    private int n;
    private boolean even;

    private volatile int curNum = 1;

    public ZeroEvenOddSemaphore(int n) {
        this.n = n;
        even = n % 2 == 0;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (curNum % 2 == 0) {
                evenSemaphore.release();
            } else {
                oddSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int endNum = even ? n : n - 1;
        while (curNum <= endNum) {
            evenSemaphore.acquire();
            printNumber.accept(curNum);
            curNum++;
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int endNum = even ? n - 1 : n;
        while (curNum <= endNum) {
            oddSemaphore.acquire();
            printNumber.accept(curNum);
            curNum++;
            zeroSemaphore.release();
        }
    }
}

class ZeroEvenOddYield {

    private volatile int state = 0;
    private int n;

    private volatile int curNum = 1;



    public ZeroEvenOddYield(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (curNum % 2 == 0) {
                state = 2;
            } else {
                state = 1;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int endNum = n % 2 == 0 ? n : n - 1;
        while (curNum <= endNum) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(curNum);
            state = 0;
            curNum++;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int endNum = n % 2 == 0 ? n - 1 : n;
        while (curNum <= endNum) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(curNum);
            state = 0;
            curNum++;
        }
    }
}

/**
 * LockSupport
 * park(): 暂停当前线程
 * unpark(Thread thread); 唤醒指定线程
 */
class ZeroEvenOddLockSupport {

    private Map<String, Thread> map = new ConcurrentHashMap<>();

    private int n;
    /**
     * 是否是偶数
     */
    private boolean even;

    private volatile int curNum = 1;



    public ZeroEvenOddLockSupport(int n) {
        this.n = n;
        even = n % 2 == 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        map.put("zero", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            printNumber.accept(0);
            if (curNum % 2 == 0) {
                while (!map.containsKey("even"));
                LockSupport.unpark(map.get("even"));
            } else {
                //如果唤醒odd线程前，还没将odd线程添加到map将出现死锁
                while (!map.containsKey("odd"));
                LockSupport.unpark(map.get("odd"));
            }
            LockSupport.park();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        map.put("even", Thread.currentThread());
        int endNum = even ? n : n - 1;
        while (curNum <= endNum) {
            LockSupport.park();
            printNumber.accept(curNum);
            curNum++;
            LockSupport.unpark(map.get("zero"));
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        map.put("odd", Thread.currentThread());
        int endNum = even ? n - 1 : n;
        while (curNum <= endNum) {
            LockSupport.park();
            printNumber.accept(curNum);
            curNum++;
            LockSupport.unpark(map.get("zero"));
        }
    }
}


class ZeroEvenOddLock {
    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private volatile int state = 0;
    private int n;

    private volatile int curNum = 1;

    public ZeroEvenOddLock(int n) {
        this.n = n;
    }


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (state != 0) {
                    condition.await();
                }
                printNumber.accept(0);
                if (curNum % 2 == 0) {
                    state = 2;
                } else {
                    state= 1;
                }
                condition.signalAll();

            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int endNum = n % 2 == 0 ? n : n - 1;
        for (int i = 2; i <= endNum; i += 2) {
            lock.lock();
            try {
                while (state != 2) {
                    condition.await();
                }
                printNumber.accept(curNum++);
                state = 0;
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int endNum = n % 2 == 0 ? n - 1 : n;
        for (int i = 1; i <= endNum; i += 2) {
            lock.lock();
            try {
                while (state != 1) {
                    condition.await();
                }
                printNumber.accept(curNum++);
                state = 0;
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }
}