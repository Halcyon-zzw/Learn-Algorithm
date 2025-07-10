package normal.多线程;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 * 中等
 *
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *
 *
 * 提示：
 * 本题已经提供了打印字符串的相关方法，如 printFizz() 等，具体方法名请参考答题模板中的注释部分。
 *
 * @author zhuzhiwei
 * @date 2024/2/25 21:34
 */
public class Thread_1195_交替打印字符串 {
    public static void main(String[] args) {

//        FizzBuzzSemaphore fizzBuzz = new FizzBuzzSemaphore(15);
//        FizzBuzzSynchronized fizzBuzz = new FizzBuzzSynchronized(15);
//        FizzBuzzReentrantLock fizzBuzz = new FizzBuzzReentrantLock(15);
        FizzBuzzLockSupport fizzBuzz = new FizzBuzzLockSupport(1);

        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number(n -> System.out.println(n));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}


class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

    }
}

class FizzBuzzSemaphore {
    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private Semaphore numberSemaphore = new Semaphore(1);
    private int n;

    private volatile int curNum = 1;

    public FizzBuzzSemaphore(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n ; i += 3) {
            if (i % 5 != 0) {
                fizzSemaphore.acquire();
                printFizz.run();
                curNum++;
                release();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzzSemaphore.acquire();
                printBuzz.run();
                curNum++;
                release();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzSemaphore.acquire();
                printFizzBuzz.run();
                curNum++;
                release();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                numberSemaphore.acquire();
                printNumber.accept(curNum++);
                release();
            }
        }
    }

    private void release() {
        if (curNum % 3 == 0 && curNum % 5 == 0) {
            fizzBuzzSemaphore.release();
        } else if (curNum % 3 == 0) {
            fizzSemaphore.release();
        } else if (curNum % 5 == 0) {
            buzzSemaphore.release();
        } else {
            numberSemaphore.release();
        }
    }
}

/**
 * CyclicBarrier控制四个线程都遍历完一次后进入下一次的遍历
 */
class FizzBuzzCyclicBarrier {
    private int n;

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public FizzBuzzCyclicBarrier(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
            }
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                printBuzz.run();
            }
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
            }
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
            }
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class FizzBuzzSynchronized {
    private Object lock = new Object();
    private volatile int curNum = 1;
    private int n;

    public FizzBuzzSynchronized(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (curNum <= n) {
            synchronized (lock) {
                if (curNum % 3 == 0 && curNum % 5 != 0) {
                    printFizz.run();
                    curNum++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (curNum <= n) {
            synchronized (lock) {
                if (curNum % 3 != 0 && curNum % 5 == 0) {
                    printBuzz.run();
                    curNum++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curNum <= n) {
            synchronized (lock) {
                if (curNum % 3 == 0 && curNum % 5 == 0) {
                    printFizzBuzz.run();
                    curNum++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }

            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (curNum <= n) {
            synchronized (lock) {
                if (curNum % 3 != 0 && curNum % 5 != 0) {
                    printNumber.accept(curNum);
                    curNum++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }
}


class FizzBuzzReentrantLock {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private volatile int curNum = 1;
    private int n;

    public FizzBuzzReentrantLock(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (curNum <= n) {
            lock.lock();
            try {
                if (curNum % 3 == 0 && curNum % 5 != 0) {
                    printFizz.run();
                    curNum++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (curNum <= n) {
            lock.lock();
            try {
                if (curNum % 3 != 0 && curNum % 5 == 0) {
                    printBuzz.run();
                    curNum++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curNum <= n) {
            lock.lock();
            try {
                if (curNum % 3 == 0 && curNum % 5 == 0) {
                    printFizzBuzz.run();
                    curNum++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (curNum <= n) {
            lock.lock();
            try {
                if (curNum % 3 != 0 && curNum % 5 != 0) {
                    printNumber.accept(curNum);
                    curNum++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}


class FizzBuzzYield {

    private volatile int curNum = 1;
    private int n;

    public FizzBuzzYield(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (curNum <= n) {
            if (curNum % 3 == 0 && curNum % 5 != 0) {
                printFizz.run();
                curNum++;
            } else {
                Thread.yield();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (curNum <= n) {
            if (curNum % 3 != 0 && curNum % 5 == 0) {
                printBuzz.run();
                curNum++;
            } else {
                Thread.yield();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curNum <= n) {
            if (curNum % 3 == 0 && curNum % 5 == 0) {
                printFizzBuzz.run();
                curNum++;
            } else {
                Thread.yield();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (curNum <= n) {
            if (curNum % 3 != 0 && curNum % 5 != 0) {
                printNumber.accept(curNum);
                curNum++;
            } else {
                Thread.yield();
            }
        }
    }
}


class FizzBuzzLockSupport {
    Map<String, Thread> map = new ConcurrentHashMap<>();
    private volatile int curNum = 1;
    private int n;

    public FizzBuzzLockSupport(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        map.put("fizz", Thread.currentThread());
        for (int i = 3; i <=n; i += 3) {
            if (i % 5 != 0) {
                LockSupport.park();
                printFizz.run();
                curNum++;
                LockSupport.unpark(map.get("number"));
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        map.put("buzz", Thread.currentThread());
        for (int i = 5; i <=n; i += 5) {
            if (i % 3 != 0) {
                LockSupport.park();
                printBuzz.run();
                curNum++;
                LockSupport.unpark(map.get("number"));
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        map.put("fizzbuzz", Thread.currentThread());
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                LockSupport.park();
                printFizzBuzz.run();
                curNum++;
                LockSupport.unpark(map.get("number"));
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        map.put("number", Thread.currentThread());
        while (curNum <= n) {
            while (curNum % 3 != 0 && curNum % 5 != 0 && curNum <= n) {
                printNumber.accept(curNum);
                curNum++;
            }
            unPark();
            if (curNum <= n) {
                LockSupport.park();
            }
        }
    }

    private void unPark() {
        if (curNum % 3 == 0 && curNum % 5 == 0) {
            LockSupport.unpark(map.get("fizzbuzz"));
        } else if (curNum % 3 == 0) {
            LockSupport.unpark(map.get("fizz"));
        } else if (curNum % 5 == 0) {
            LockSupport.unpark(map.get("buzz"));
        } else {
            LockSupport.unpark(map.get("number"));
        }
    }
}


