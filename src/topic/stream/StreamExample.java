package topic.stream;

import topic.funcprogramming.Instructor;
import topic.funcprogramming.Instructors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

        Predicate<Instructor> hasOnline = i -> i.isOnlineCourses();
        Predicate<Instructor> hasExperience = i -> i.getYearsOfExperience() > 10;

        Map<String, Boolean> map = new HashMap<>();
        instructors.forEach(instructor -> {
            if (hasExperience.and(hasExperience).test(instructor))
                map.put(instructor.getName(), instructor.isOnlineCourses());
        });

        System.out.println(map);

        //or

        Map<String, Boolean> map2 = new HashMap<>();
        map2 = instructors.stream().filter(hasExperience).filter(hasOnline)
                .collect(Collectors.toMap(Instructor::getName, Instructor::isOnlineCourses));

        System.out.println(map2);
    }
}
