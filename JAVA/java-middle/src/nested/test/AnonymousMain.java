package nested.test;

public class AnonymousMain {

    public static void main(String[] args) {
        hello hello = new hello() {
            @Override
            public void hello() {
                System.out.println("Hello.hello");
            }
        };
        hello.hello();
    }
}
