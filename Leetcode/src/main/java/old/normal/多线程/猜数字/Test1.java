package normal.多线程.猜数字;

/**
 * 猜数字
 *
 * @author zhuzhiwei
 * @date 2024/4/1 21:09
 */
public class Test1 {
    public static void main(String[] args) {
        Game game = new Game();
        game.numberGenerationThread.start();
        game.numberGuessingThread1.start();
        game.numberGuessingThread2.start();
    }
}

class Game implements Runnable {
    private static int actualNumber;
    final int TOO_LOW = -1, TOO_HIGH = 1, CORRECT = 0;
    int guessedNumber1, guessedNumber2, lowerBound = 0, upperBound = 100, message1 = TOO_LOW, message2 = TOO_LOW;
    boolean readyForGuessing1 = false, hasNumberBeenGenerated = false, readyForGuessing2 = false, hasNumberBeenGenerated2 = false;
    Thread numberGenerationThread, numberGuessingThread1, numberGuessingThread2;

    Game() {
        numberGenerationThread = new Thread(this);
        numberGuessingThread1 = new Thread(this);
        numberGuessingThread2 = new Thread(this);
    }

    public void run() {
        for (int turn = 1; true; turn++) {
            setMessage(turn);
            if (message1 == CORRECT || message2 == CORRECT)
                return;
        }
    }

    public synchronized void setMessage(int turn) {
        if (Thread.currentThread() == numberGenerationThread && !hasNumberBeenGenerated) {
            actualNumber = (int) (Math.random() * 100) + 1;
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is? " + actualNumber);
            hasNumberBeenGenerated = true;
            readyForGuessing1 = true;
            readyForGuessing2 = true;
        }
        if (Thread.currentThread() == numberGenerationThread) {
            while (readyForGuessing1 || readyForGuessing2)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            if (actualNumber == guessedNumber1 || actualNumber == guessedNumber2) {
                message1 = CORRECT;
                System.out.println("猜对了");
                return;
            }
            readyForGuessing1 = true;
            readyForGuessing2 = true;
        }
        if (Thread.currentThread() == numberGuessingThread1 && hasNumberBeenGenerated) {
            while (!readyForGuessing1)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            if (message1 == TOO_LOW) {
                lowerBound = guessedNumber1;
                guessedNumber1 = (lowerBound + upperBound) / 2;
            } else if (message1 == TOO_HIGH) {
                upperBound = guessedNumber1;
                guessedNumber1 = (lowerBound + upperBound) / 2;
            }
            System.out.println("线程A第" + turn + "次猜的数字：" + guessedNumber1);
            if (actualNumber > guessedNumber1) {
                message1 = TOO_LOW;
                System.out.println("A, 猜小了");
            } else if (actualNumber < guessedNumber1) {
                message1 = TOO_HIGH;
                System.out.println("A,猜大了");
            }
            readyForGuessing1 = false;
        }
        if (Thread.currentThread() == numberGuessingThread2 && hasNumberBeenGenerated) {
            while (!readyForGuessing2)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            if (message2 == TOO_LOW) {
                lowerBound = guessedNumber2;
                guessedNumber2 = (lowerBound + upperBound) / 2;
            } else if (message2 == TOO_HIGH) {
                upperBound = guessedNumber2;
                guessedNumber2 = (lowerBound + upperBound) / 2;
            }
            System.out.println("线程B第" + turn + "次猜的数字：" + guessedNumber2);
            if (actualNumber > guessedNumber2) {
                message2 = TOO_LOW;
                System.out.println("B, 猜小了");
            } else if (actualNumber < guessedNumber2) {
                message2 = TOO_HIGH;
                System.out.println("B,猜大了");
            }
            readyForGuessing2 = false;
        }
        notifyAll();
    }


}