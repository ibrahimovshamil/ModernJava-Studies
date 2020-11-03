package topic.funcprogramming;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

        Predicate<Instructor> instructorPredicate = instructor -> instructor.isOnlineCourses();
        Predicate<Instructor> instructorPredicate1 = instructor -> instructor.getYearsOfExperience() > 10;

        instructors.forEach(instructor -> {
            if (instructorPredicate.and(instructorPredicate1).test(instructor))
                System.out.println(instructor);
        });
    }
}
