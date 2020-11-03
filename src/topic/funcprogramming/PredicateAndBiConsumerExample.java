package topic.funcprogramming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndBiConsumerExample {
    public static void main(String[] args) {
        List<Instructor> list = Instructors.getAll();

        Predicate<Instructor> p1 = i -> i.getYearsOfExperience() > 10;
        Predicate<Instructor> p2 = i -> i.isOnlineCourses();

        BiConsumer<String, List<String>> biConsumer = (name, courses) ->
                System.out.println("Name is : " + name + " Courses are : " + courses.toString());

        Consumer<Instructor> consumer = i -> {
            if (p1.and(p2).test(i))
                biConsumer.accept(i.name, i.courses);
        };

        list.forEach(consumer);

    }
}
