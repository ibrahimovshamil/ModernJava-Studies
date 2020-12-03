package topic.stream;

import topic.funcprogramming.Instructors;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamReduceExample {
    public static void main(String[] args) {
        //find sum and factorial

        int sum2 = IntStream.rangeClosed(1, 9).reduce(0, (left, right) -> left + right);
        System.out.println("sum2 " + sum2);
    }
}
