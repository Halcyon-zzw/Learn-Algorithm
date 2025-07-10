package normal.多线程;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. 交替打印 FooBar
 * 中等
 *
 * 两个不同的线程将会共用一个 FooBar 实例：
 *
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *
 * 示例 1：
 * 输入：n = 1
 * 输出："foobar"
 * 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 *
 * 示例 2：
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 *
 * @author zhuzhiwei
 * @date 2024/2/24 14:57
 */
public class Thread_1115_交替打印FooBar {
    public static void main(String[] args) {

//        FooBar fooBar = new FooBar(10);
//        FooBar2 fooBar = new FooBar2(10);
//        FooBar3 fooBar = new FooBar3(10);
//        FooBar4 fooBar = new FooBar4(10);
//        FooBar5 fooBar = new FooBar5(10);
//        FooBar6 fooBar = new FooBar6(10);
//        FooBar7 fooBar = new FooBar7(10);
        FooBarLockSupport fooBar = new FooBarLockSupport(10);

        Runnable fooRunnable = () -> System.out.print(1);
        Runnable barRunnable = () -> System.out.println(2);

        new Thread(() -> {
            try {
                fooBar.foo(fooRunnable);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(barRunnable);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}

class FooBar {

    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}

//CyclicBarrier
class FooBarCyclicBarrier {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    private int n;

    //当前是否执行foo
    private volatile boolean fooExecute = true;

    public FooBarCyclicBarrier(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n; i++) {
            while (!fooExecute) {
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooExecute = false;
            cyclicBarrier.await();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; i++) {
            cyclicBarrier.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooExecute = true;
        }
    }
}

//Thread.yield
class FooBarYield {

    private int n;

    //当前是否执行foo
    private volatile boolean fooExecute = true;

    public FooBarYield(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n; ) {
            if (fooExecute) {
                printFoo.run();
                fooExecute = false;
                i++;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; ) {
            if (!fooExecute) {
                printBar.run();
                fooExecute = true;
                i++;
            } else {
                Thread.yield();
            }
        }
    }
}

//ReentrantLock
class FooBarReentrantLock {

    private int n;

    private ReentrantLock lock = new ReentrantLock();

    //当前是否执行foo
    private volatile boolean fooExecute = true;

    public FooBarReentrantLock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n;) {

            lock.lock();
            try {
                if (fooExecute) {
                    printFoo.run();
                    fooExecute = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!fooExecute) {
                    printBar.run();
                    fooExecute = true;
                    i++;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}

//synchronized
class FooBarSynchronized {

    private int n;
    private Object lock = new Object();
    //当前是否执行foo
    private volatile boolean fooExecute = true;

    public FooBarSynchronized(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n;) {
            synchronized (lock) {
                if (fooExecute) {
                    printFoo.run();
                    fooExecute = false;
                    i++;
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; ) {
            synchronized (lock) {
                if (!fooExecute) {
                    printBar.run();
                    fooExecute = true;
                    i++;
                }
            }
        }
    }
}

//no lock
class FooBarNoLock {

    private int n;
    //当前是否执行foo
    private volatile boolean fooExecute = true;

    public FooBarNoLock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n;) {
                while (fooExecute) {
                    printFoo.run();
                    fooExecute = false;
                    i++;
                }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; ) {
                while (!fooExecute) {
                    printBar.run();
                    fooExecute = true;
                    i++;
                }
        }
    }
}

//BlockingQueue
class FooBarBlockingQueue {

    private int n;
    //当前是否执行foo
    private volatile boolean fooExecute = true;

    private BlockingQueue<Integer> fooBlockingDeque = new LinkedBlockingDeque<>() {{
        add(0);
    }};

    private BlockingQueue<Integer> barBlockingDeque = new LinkedBlockingDeque<>();

    public FooBarBlockingQueue(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {

        for (int i = 0; i < n; i++) {
            fooBlockingDeque.take();
            printFoo.run();
            barBlockingDeque.add(0);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < n; i++) {
            barBlockingDeque.take();
            printBar.run();
            fooBlockingDeque.add(0);
        }
    }
}

//LockSupport
class FooBarLockSupport {
    private Map<String, Thread> map = new ConcurrentHashMap<>();
    private int n;
    //当前是否执行foo
    private volatile boolean fooExecute = true;


    public FooBarLockSupport(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException, BrokenBarrierException {
        map.put("foo", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (!fooExecute) {
                LockSupport.park();
            }
            printFoo.run();
            fooExecute = false;
            LockSupport.unpark(map.get("bar"));
        }
    }

    public void bar(Runnable printBar) throws InterruptedException, BrokenBarrierException {
        map.put("bar", Thread.currentThread());
        for (int i = 0; i < n; i++) {
            while (fooExecute) {
                LockSupport.park();
            }
            printBar.run();
            fooExecute = true;
            LockSupport.unpark(map.get("foo"));
        }
    }
}