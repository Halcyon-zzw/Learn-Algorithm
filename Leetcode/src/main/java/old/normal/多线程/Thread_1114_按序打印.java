package normal.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 1114. 按序打印
 * 简单
 *
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 提示：
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出："firstsecondthird"
 * 解释：
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。正确的输出是 "firstsecondthird"。
 *
 * 示例 2：
 * 输入：nums = [1,3,2]
 * 输出："firstsecondthird"
 * 解释：
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。正确的输出是 "firstsecondthird"。
 *
 *
 * 提示：
 * nums 是 [1, 2, 3] 的一组排列
 *
 * @author zhuzhiwei
 * @date 2024/2/24 14:05
 */
public class Thread_1114_按序打印 {
    public static void main(String[] args) throws InterruptedException {
//        FooCountDownLatch fooCountDownLatch = new FooCountDownLatch();
        FooSemaphore foo = new FooSemaphore();
        Runnable runnable1 = () -> System.out.println("first");
        Runnable runnable2 = () -> System.out.println("second");
        Runnable runnable3 = () -> System.out.println("third");

        Thread thread1 = new Thread(() -> {
            try {
                foo.first(runnable1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(runnable2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(runnable3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        List<Thread> threadList = new ArrayList<>();
        threadList.add(null);
        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);


        int[] orderList = {2, 3, 1};

        for (int i : orderList) {
            threadList.get(i).start();
            Thread.sleep(100);
        }
    }
}

class FooCountDownLatch {

    private CountDownLatch firstCountDownLatch = new CountDownLatch(1);
    private CountDownLatch secondCountDownLatch = new CountDownLatch(1);

    public FooCountDownLatch() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstCountDownLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstCountDownLatch.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondCountDownLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondCountDownLatch.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}


class FooSemaphore {

    private Semaphore firstSemaphore = new Semaphore(0);
    private Semaphore secondSemaphore = new Semaphore(0);

    public FooSemaphore() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondSemaphore.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}