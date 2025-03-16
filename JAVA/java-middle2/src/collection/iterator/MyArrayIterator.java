package collection.iterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayIterator implements Iterator<Integer> {
    private int currentIndex = -1;
    private int[] targetArr;

    public MyArrayIterator(int[] targetArr) {
        this.targetArr = targetArr;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return 0;
    }
}
