package topic.funcprogramming.banktransferexample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

public class BankAccount {
    int id;
    double balance;
    String accountName;
    final Lock lock = new ReentrantLock();

    BiFunction<Double, Double, Double> subtract = (a, b) -> a - b;
    BiFunction<Double, Double, Double> add = (a, b) -> a + b;

    boolean withdraw(double amount) throws InterruptedException {
        if (lock.tryLock()) {
            Thread.sleep(1000);
            balance =  subtract.apply(balance, amount);
            lock.unlock();
            return true;
        }
        return false;
    }
}
