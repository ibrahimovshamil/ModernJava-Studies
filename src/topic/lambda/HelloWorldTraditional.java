package topic.lambda;

public class HelloWorldTraditional implements HelloWorldInterface {

    @Override
    public String sayHello() {
        return "Hello World";
    }

    public static void main(String[] args) {
        HelloWorldInterface traditional = new HelloWorldTraditional();
        System.out.println(traditional.sayHello());
    }
}
