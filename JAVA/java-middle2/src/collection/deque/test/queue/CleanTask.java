package collection.deque.test.queue;

public class CleanTask implements Task{
    @Override
    public void exectue() {
        System.out.println("사용하지 않는 자원 정리...");
    }
}
