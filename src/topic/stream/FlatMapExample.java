package topic.stream;

import topic.funcprogramming.Instructor;
import topic.funcprogramming.Instructors;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {

        List<List<String>> courses = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .collect(Collectors.toList());

        // to be able to do get only a List of courses we need to use flatMap()

        List<String> courses2 = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(courses2);
    }
}
