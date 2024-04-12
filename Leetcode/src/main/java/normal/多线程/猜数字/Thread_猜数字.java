package normal.多线程.猜数字;

/**
 * TODO
 *
 * @author zhuzhiwei
 * @date 2024/4/1 20:56
 */
public class Thread_猜数字 {
    public static void main(String[] args) {
        Number number = new Number();
        number.giveNumberThread.start();
        number.guessNumberThread1.start();
        number.guessNumberThread2.start();
    }
}

class Number implements Runnable {
    private static int theNumber;
    final int TO_LOW = -1, TOO_HIGH = 1, SUCCESS = 0;
    int guessNumber1, guessNumber2, min = 0, max = 100, message = TO_LOW, message2 = TO_LOW;
    boolean pleaseGuess = false, isGiveNumber = false, pleaseGuess2 = false, isGiveNumber2 = false;
    Thread giveNumberThread, guessNumberThread1, guessNumberThread2;

    Number() {
        giveNumberThread = new Thread(this);
        guessNumberThread1 = new Thread(this);
        guessNumberThread2 = new Thread(this);
    }

    public void run() {
        for (int count = 1; true; count++) {
            setMessage(count);
            if (message == SUCCESS || message2 == SUCCESS)
                return;
        }
    }

    public synchronized void setMessage(int count) {

        if (Thread.currentThread() == giveNumberThread && isGiveNumber == false) {
            theNumber = (int) (Math.random() * 100) + 1;
            System.out.println("随机给你一个1至100之间的数，猜猜是多少？" + theNumber);
            isGiveNumber = true;
            pleaseGuess = true;
            pleaseGuess2 = true;
        }
        if (Thread.currentThread() == giveNumberThread) {
            while (pleaseGuess == true || pleaseGuess2 == true)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            if (theNumber == guessNumber1 || theNumber == guessNumber2) {
                message = SUCCESS;
                System.out.println("猜对了");
                return;
            }
            pleaseGuess = true;
            pleaseGuess2 = true;
        }
        if (Thread.currentThread() == guessNumberThread1 && isGiveNumber == true) {
            while (pleaseGuess == false)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            if (message == TO_LOW) {
                min = guessNumber1;
                guessNumber1 = (min + max) / 2;
                System.out.println("A第" + count + "次猜这个数是：" + guessNumber1);
            } else if (message == TOO_HIGH) {
                max = guessNumber1;
                guessNumber1 = (min + max) / 2;
                System.out.println("A第" + count + "次猜这个数是：" + guessNumber1);
            }
            if (theNumber > guessNumber1) {
                message = TO_LOW;
                System.out.println("猜小了");
            } else if (theNumber < guessNumber1) {
                message = TOO_HIGH;
                System.out.println("猜大了");
            }

            pleaseGuess = false;
        }
        if (Thread.currentThread() == guessNumberThread2 && isGiveNumber == true) {
            while (pleaseGuess2 == false)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            if (message2 == TO_LOW) {
                min = guessNumber2;
                guessNumber2 = (min + max) / 2;
                System.out.println("B第" + count + "次猜这个数是：" + guessNumber2);
            } else if (message2 == TOO_HIGH) {
                max = guessNumber2;
                guessNumber2 = (min + max) / 2;
                System.out.println("B第" + count + "次猜这个数是：" + guessNumber2);
            }
            if (theNumber > guessNumber2) {
                message2 = TO_LOW;
                System.out.println("猜小了");
            } else if (theNumber < guessNumber2) {
                message2 = TOO_HIGH;
                System.out.println("猜大了");
            }
            pleaseGuess2 = false;
        }
        notifyAll();
    }
}