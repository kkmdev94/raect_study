package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // true를 하면 데몬스레드가 false를 하면 사용자 스레드가 된다.
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + " : main() end");

    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try{
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) { // 예외를 던질 수가 없다 run에서 무조건 잡아야 한다. 그 이유는 뒤에 다른 챕터에 이유 설명.
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
