package topic.funcprogramming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

        BiConsumer<String, String> biConsumer = (name, gender) -> System.out.println("Name is : " + name + " Gender is: " + gender);
        biConsumer.accept("Shamil", "male");

        instructors.forEach(instructor -> {
            biConsumer.accept(instructor.name, instructor.gender);
        });

        //OR

        System.out.println("--------------");
        Consumer<Instructor> consumer = instructor -> biConsumer.accept(instructor.name, instructor.gender);
        instructors.forEach(consumer);
    }
}
