package topic.funcprogramming;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Double> sqrt = (i) -> Math.sqrt(i);
        System.out.println(sqrt.apply(64));

        Function<String, String> toLowerCase = (str) -> str.toLowerCase();
        Function<String, String> concat = (str) -> str.concat(" in Java");

        System.out.println(toLowerCase.andThen(concat).apply("PROGraming"));
    }
}
