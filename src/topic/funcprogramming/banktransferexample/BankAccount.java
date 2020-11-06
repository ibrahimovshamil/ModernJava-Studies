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
            balance = subtract.apply(balance, amount);
            lock.unlock();
            return true;
        }
        return false;
    }

    boolean deposit(double amount) throws InterruptedException {
        if (lock.tryLock()) {
            Thread.sleep(1000);
            balance = add.apply(balance, amount);
            lock.unlock();
            return true;
        }
        return false;
    }

    boolean transfer(BankAccount to, double amount) throws InterruptedException {
        if (withdraw(amount)) {
            System.out.println("Withdrawing amount: " + amount + " from: " + accountName);
            if (to.deposit(amount)) {
                System.out.println("Depositing amount:" + amount + " to: " + to.accountName);
                return true;
            } else {
                System.out.println("Failed to acquire both locks: refunding " + amount + " to: " + accountName);
                while (!deposit(amount))
                    continue;
            }
        }
        return false;
    }

    public BankAccount(int id, double balance, String accountName) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
