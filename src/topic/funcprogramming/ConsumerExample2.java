package topic.funcprogramming;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

        Consumer<Instructor> c1 = instructor -> System.out.println(instructor);
        instructors.forEach(c1);

        System.out.println("----------");

        Consumer<Instructor> c2 = instructor -> System.out.print(instructor.getName());
        instructors.forEach(c2);

        System.out.println("----------");

        instructors.forEach(c2.andThen(c1));

        System.out.println("----------Filter");

        instructors.forEach(instructor -> {
            if (instructor.onlineCourses)
                c2.andThen(c1).accept(instructor);
        });
    }
}
