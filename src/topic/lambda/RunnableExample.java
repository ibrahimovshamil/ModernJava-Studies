package topic.lambda;

public class RunnableExample {
    public static void main(String[] args) {
        RunnableClass runnableClass = new RunnableClass();
        new Thread(runnableClass).start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Trad way Hello world");
            }
        };

        new Thread(runnable).start();

        Runnable runnable1 = () -> System.out.println("Lambda way Hello world");

        new Thread(runnable1).start();
    }
}
