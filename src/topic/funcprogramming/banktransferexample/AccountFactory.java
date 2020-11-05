package topic.funcprogramming.banktransferexample;

@FunctionalInterface
public interface AccountFactory {
    abstract BankAccount getAccount(int id, double balance, String name);
}
