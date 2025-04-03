package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start"); // main은 이 메서드의 main이 아니라 자바가 만들어주는 기본 스레드라고 보면 된다.

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");
        helloThread.start(); // 절대 HelloThread에 있는 run() 메서드를 호출하면 안된다. / start 명령을 통해 thread-0이 호출되고 스택이 생성된다.
        System.out.println(Thread.currentThread().getName() + " : start() 호출 후");

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
/*
   start() 메서드는 스레드를 실행하는 아주 특별한 메서드이다.
   start()를 호출하면 HelloThread 스레드가 run() 메서드를 실행한다.

   !주의 : run() 메서드가 아니라 반드시 start() 메서드를 호출해야 별도의 스레드에서 run() 코드가 실행된다.

   단일 스레드로 작동을 시켰기에 main이 먼저 실행 된 후 -> thread-0이 run 메서드를 실행 시킨건줄 알았는데 결과를 반복해보니 순서가 조금씩 바뀌는게 보였다.
   다른 이유가 있다. 그것에 대해서는 아래에 서술

   start 메서드를 통해 thread-0의 스택을 새로 생성하고 스레드를 작동시킨다. 즉, main은 main의 명령을 진행하고
   start 메서드를 통해 생성된 thread-0은 thread-0 자기만의  명령 즉, run()을 실행시키고 동작한다.
   스레드 간 실행 순서는 보장하지 않는다.
   즉, 스레드는 동시에 실행되기 때문에 스레드 간에 실행 순서는 얼마든지 달라질 수 있다. 그래서 결과값이 바뀌는 것이였다.

   스레드는 순서오 ㅏ실행 기간을 모두 보장하지 않는다. 이것이 바로 멀티 스레드이다.
 */