package topic.funcprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BiFunctionExample {
    public static void main(String[] args) {

        BiFunction<Predicate<Instructor>, List<Instructor>, Map<String, Integer>> mapBiFunction = (predicate, instructors) -> {
            Map<String, Integer> map = new HashMap<>();
            Consumer<Instructor> consumer = (inst) -> {
                if (predicate.test(inst))
                    map.put(inst.name, inst.yearsOfExperience);
            };
            instructors.forEach(consumer);
            return map;
        };

        Predicate<Instructor> predicate = (inst) -> inst.onlineCourses == true;
        System.out.println(mapBiFunction.apply(predicate, Instructors.getAll()));
    }
}
