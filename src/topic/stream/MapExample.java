package topic.stream;

import topic.funcprogramming.Instructor;
import topic.funcprogramming.Instructors;

import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        Instructors.getAll().stream()
                .map(Instructor::getName)
                .peek(System.out::println)
                .map(str -> str.toUpperCase())
                .collect(Collectors.toSet()).stream().forEach(System.out::println);
    }
}
