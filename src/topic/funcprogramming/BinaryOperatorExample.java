package topic.funcprogramming;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> integerBinaryOperator = (a, b) -> a + b;
        System.out.println(integerBinaryOperator.apply(2, 4));

        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
        BinaryOperator<Integer> minBi = BinaryOperator.minBy(comparator);
        System.out.println(minBi.apply(2,4));
        BinaryOperator<Integer> maxBi = BinaryOperator.maxBy(comparator);
        System.out.println(maxBi.apply(2,4));

    }
}
