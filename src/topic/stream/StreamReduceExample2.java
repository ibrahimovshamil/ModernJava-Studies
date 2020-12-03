package topic.stream;

import topic.funcprogramming.Instructor;
import topic.funcprogramming.Instructors;

import java.util.Optional;

public class StreamReduceExample2 {
    public static void main(String[] args) {
        //find max year of expr of instructors
        Optional<Instructor> instructor=  Instructors.getAll().stream().
                reduce((i, i2) -> i.getYearsOfExperience() > i2.getYearsOfExperience() ? i : i2);
        if (instructor.isPresent())
            System.out.println(instructor.get());
    }
}
