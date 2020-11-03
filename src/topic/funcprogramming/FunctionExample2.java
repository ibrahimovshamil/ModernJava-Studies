package topic.funcprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample2 {
    public static void main(String[] args) {
        Predicate<Instructor> predicate = (instructor) -> instructor.isOnlineCourses();
        Function<List<Instructor>, Map<String, Integer>> mapFunction = (instructorList) -> {
            Map<String, Integer> map = new HashMap<>();
            instructorList.forEach(instructor -> {
                if (predicate.test(instructor))
                    map.put(instructor.name, instructor.yearsOfExperience);
            });
            return map;
        };
        System.out.println(mapFunction.apply(Instructors.getAll()));
    }

}
