package topic.funcprogramming;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> c = (o) -> System.out.println("length of " + o + " is " + o.length());
        c.accept("Hello");
    }
}
