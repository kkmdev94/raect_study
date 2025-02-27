package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV2(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(Object e) {
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
    }

    // 코드 추가
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        // 배열을 새로 만들고, 기존 배열을 새로운 배열에 복사
//        Object[] newArr = new Object[newCapacity];
//        for (int i = 0; i < elementData.length; i++) {
//            newArr[i] = elementData[i];
//        }

        // 위 과정을 한줄로 바꿀 수 있는것이 copyOf이다. B라는 새로운 배열을 만들고 A의 데이터를 B에 넣는다. 그러면 짧았던 배열의 길이가 넓어진다..
//        Object[] newArr = Arrays.copyOf(elementData, newCapacity);
        // 마지막에 elementData 가 newArr를 볼 수 있게 참조를 바꿔버린다.
//        elementData = newArr;

        // 위 내용을 한줄로 줄이는 것
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public Object get(int index) { // 인덱스의 항목을 조회
        return elementData[index];
    }

    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexof(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + "size = " + size + ", capacity = " + elementData.length;
    }
}
