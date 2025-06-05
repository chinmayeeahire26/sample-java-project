public class MyClass5 {

    public void myMethod() {
        String message = getGreetingMessage();
        System.out.println(message);
        String goodbye = getGoodbyeMessage();
        System.out.println(goodbye);
    }

    public String getGreetingMessage() {
        return buildGreeting();
    }

    private String getGoodbyeMessage() {
        return "goodbye github";
    }

    private String buildGreeting() {
        return "hello github";
    }
}
