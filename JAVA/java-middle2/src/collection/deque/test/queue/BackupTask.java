package collection.deque.test.queue;

public class BackupTask implements Task{
    @Override
    public void exectue() {
        System.out.println("자료 백업...");
    }
}
