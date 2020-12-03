package topic.stream;

import topic.funcprogramming.Instructor;
import topic.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        //return instrs sorted by their name and more than 10 years of experience

        Predicate<Instructor> moreThan10 = i -> i.getYearsOfExperience() > 10;
        List<Instructor> list = Instructors.getAll().stream()
                .filter(moreThan10)
                .sorted(Comparator.comparing(Instructor::getName))
                .collect(Collectors.toList());

        System.out.println(list);

    }
}
