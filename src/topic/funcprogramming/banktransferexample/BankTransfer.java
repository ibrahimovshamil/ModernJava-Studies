package topic.funcprogramming.banktransferexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BankTransfer {
    public static void main(String[] args) {
        AccountFactory factory = BankAccount::new;
        BankAccount studentAccount = factory.getAccount(1, 2000, "Shamil");
        BankAccount uniAccount = factory.getAccount(1, 800, "Bilkent");

        Consumer<String> threadInfo = (str) -> System.out.println(str + " says :: Executing Transfer");
        BiConsumer<String, Double> printer = (str, amount) -> System.out.println(str + amount);
        BiPredicate<BankAccount, Double> isEnough = (acc, amount) -> acc.balance > amount;
        BiConsumer<BankAccount, BankAccount> printer2 = (student, university) ->
                System.out.println("Ending balance of student account: " + studentAccount.balance + " University account: " + uniAccount.balance);


        Thread thread = new Thread(() -> {
            double amount = 100;
            threadInfo.accept(Thread.currentThread().getName());
            try {
                if (!isEnough.test(studentAccount, amount)) {
                    printer.accept(Thread.currentThread().getName() + " says :: balance insufficent, ", amount);
                    return;
                }
                while (!studentAccount.transfer(uniAccount, amount)) {
                    continue;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer2.accept(studentAccount, uniAccount);
        });

        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            service.submit(thread);
        }

        service.shutdown();

        printer2.accept(studentAccount, uniAccount);
    }
}
