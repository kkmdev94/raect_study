package collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;

public class TaskScheduler {

    private Queue<Task> tasks = new ArrayDeque<>();


    public void addTask(Task task) {
        tasks.offer(task);
    }


    public int getRemainingTasks() {
//        return tasks.toArray().length;
        return tasks.size();
    }

    public void processNextTask() {
        Task poll = tasks.poll();
        if (poll != null) {
            poll.exectue();
            // interface로 만들어서 상속받아 놓고 호출하는걸 생각을 못했다 좀더 생각을 확장적으로
            // 가져보자
        }
    }
}
