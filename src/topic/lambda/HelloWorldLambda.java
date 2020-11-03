package topic.lambda;

public class HelloWorldLambda {
    public static void main(String[] args) {
        HelloWorldInterface worldInterface = () -> "Hello World";
        System.out.println(worldInterface.sayHello());
    }
}
