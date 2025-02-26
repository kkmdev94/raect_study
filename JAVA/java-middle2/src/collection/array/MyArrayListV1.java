package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5; //리스트를 생성할 떄 사용하는 기본 배열의 크기

    private Object[] elementData; // 다양한 타입의 데이터를 보관하기 위해 Object 배열 사용
    private int size = 0; // 리스트의 크기는 size를 이용, 리스트를 표현하기 위해 내부에서 배열을 사용하는 것. 배열의 크기를 뜻하는 capacity와는 다르다.
    // 예를 들어 배열의 크기(Capcity)가 5인데 입력된 데이터가 하나도 없으면 size는 0이된다. 즉, 실제로 들어와있는 데이터의 갯수를 표현

    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV1(int initialCapacity) { // 배열의 크기를 다르게 하고싶다면 이 생성자를 이용하면 된다.
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(Object e) { // 리스트에 데이터를 추가, 추가하면 size가 하나 증가.
        elementData[size] = e;
        size++;
    }

    public Object get(int index) { // 인덱스의 항목을 조회
        return elementData[index];
    }

    public Object set(int index, Object element) { // 인덱스에 있는 항목을 변경
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexof(Object o) { // 검색 기능, 순차 탐색에서 인수와 같은 데이터가 있는 인덱스의 위치를 반환. 없으면 -1을 반환
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() { // size 크기의 배열을 새로 만든다.(복사) 여기서 toString() 출력시 size 이후 의미 없는 값을 출력하지 않기 위해 사용.
        return Arrays.toString(Arrays.copyOf(elementData, size)) + "size = " + size + ", capacity = " + elementData.length;
    }
}
