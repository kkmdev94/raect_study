package thread.collection.simple.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> copySet = new CopyOnWriteArraySet<>(); // 순서 보장 X
        copySet.add(1);
        copySet.add(3);
        copySet.add(2);
        System.out.println("copySet = " + copySet);

        Set<Integer> skipSet = new ConcurrentSkipListSet<>(); // 순서 보장. comparator 사용 가능
        skipSet.add(1);
        skipSet.add(3);
        skipSet.add(2);
        System.out.println("skipSet = " + skipSet);
    }
}
