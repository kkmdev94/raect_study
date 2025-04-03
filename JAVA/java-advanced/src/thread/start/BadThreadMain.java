package thread.start;

public class BadThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start"); // main은 이 메서드의 main이 아니라 자바가 만들어주는 기본 스레드라고 보면 된다.

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");
        helloThread.run(); // main thread가 실행한다. / 하나의 스택 단일 스레드로 돌아간다.
        System.out.println(Thread.currentThread().getName() + " : start() 호출 후");

        System.out.println(Thread.currentThread().getName() + " :  main() end");
    }
}