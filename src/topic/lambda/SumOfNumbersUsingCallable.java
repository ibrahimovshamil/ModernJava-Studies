package topic.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SumOfNumbersUsingCallable {
    static int[] arr = IntStream.rangeClosed(0, 5000).toArray();
    static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws Exception {
        Callable callable1 = () -> {
            int sum = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                sum += arr[i];
            }
            return sum;
        };

        Callable callable2 = () -> {
            int sum = 0;
            for (int i = arr.length / 2; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2);
        List<Future<Integer>> futures = service.invokeAll(callables);

        int sum = 0;
        int k = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
            System.out.println("sum for K " + ++k + " " + sum);
        }
        System.out.println("Sum already known: " + total);
        System.out.println("Sum from callables : " + sum);

        service.shutdown();

    }
}
