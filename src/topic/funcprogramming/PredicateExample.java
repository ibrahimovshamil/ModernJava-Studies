package topic.funcprogramming;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = integer -> integer > 10;
        System.out.println(predicate.test(20));

        Predicate<Integer> predicate1 = integer -> integer % 2 == 0;
        System.out.println(predicate1.test(20));

        System.out.println(predicate.and(predicate1.negate()).test(20));


    }
}
