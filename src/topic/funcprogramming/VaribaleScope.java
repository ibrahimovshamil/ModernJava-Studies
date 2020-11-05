package topic.funcprogramming;

import java.util.List;

public class VaribaleScope {
//    static int k = 7;

    public static void main(String[] args) {
        int k = 0;

        List<Instructor> instructors = Instructors.getAll();
        instructors.forEach(instructor -> {
            System.out.println(instructor + " " + k);
        });

//        k = 6;
    }
}
