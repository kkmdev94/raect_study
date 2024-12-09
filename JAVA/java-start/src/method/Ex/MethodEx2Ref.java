package method.Ex;

public class MethodEx2Ref {

    public static void main(String[] args) {
        String message = "Hello, world";
        printmessage(message, 3);
        printmessage("hello java", 5);
        printmessage("hello python", 7);
    }

    public static void printmessage(String message, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(message);
        }
    }
}
