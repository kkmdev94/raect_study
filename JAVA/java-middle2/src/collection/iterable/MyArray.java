package collection.iterable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer>{ // iterable -> 순회 할 수 있다

    private int[] numbers;

    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() { // iterable을 통해 반복이 가능하다는것을 알리고 iterator(반복자)를 반환(호출)한다.
        return new MyArrayIterator(numbers);
    }
}
