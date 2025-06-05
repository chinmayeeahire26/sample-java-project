public class MyClass5 {
    public void myMethod() {
        String message = getGreetingMessage();
        System.out.println(message);
        String goodbye = getGoodbyeMessage();
        System.out.println(goodbye);
    }

    public String getGreetingMessage() {
        return "hello github";
    }

    private String getGoodbyeMessage() {
        return "goodbye github";
    }
}