package collection.iterable;

import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> { // 반복할 수 있는 iterable에서 호출된 iterator를 통해 반복한다.
    private int currentIndex = -1;
    private int[] targetArr; //{1,2,3,4}

    public MyArrayIterator(int[] targetArr) {
        this.targetArr = targetArr;
    }

    @Override
    public boolean hasNext() { // '다음 값이 있는지 확인' 후 있다면 그 값을 next를 통해 호출하고 없다면 false를 반환한다.
        return currentIndex < targetArr.length - 1;
    }

    @Override
    public Integer next() { // hasnext를 통해 값이 있는지 확인하였고 값이 있다는 true를 반환받았기에 해당 next 메서드 실행 -> 전위연산자를 통해 값을 증가시킨후 targetArr에 있는 값을
                            // currentIndex값을 호출 -> 해당 Index에 있는 값을 불러와 반환한다.
//        currentIndex++; // 0
        return targetArr[++currentIndex]; // 전위 연산자.
    }
}
