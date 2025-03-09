package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV3<E> implements MySet<E> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    private LinkedList<E>[] buckets; // 아무거나 다 받을 수 있다. 세상 모든것을 담을 수 있는 Object이기 떄문에.

    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV3() { // 기본생성 Default Capacity 16개 기반의 배열이 만들어짐
        initBuckets();
    }

    public MyHashSetV3(int capacity) { // capacity를 매개변수로 받아서 capacity를 내가 셋팅하는 생성자
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(E value) {
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(E searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<E> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }

    public boolean remove(E value) {
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];
        boolean result = bucket.remove(value);
        /*
        리무브 조심해야될 점 :
            - 리무브는 두가지 종류가 있다. 하나는 인덱스를 지우는 법, 하나는 래퍼 타입으로 오브젝트형으로 넘겨서 링크드 리스트 안에 있는 값을 지우는 방법 두가지가 있다.
            ctrl + P로 인트형인지 오브젝트 형인지 확인이 가능하며, 인트형을 매개변수로 넘겨주면 인덱스 자체가 삭제되는거고 래퍼 타입으로 넘겨주어야만 인덱스 값 안의 내용을 찾아서 지운다.
         */
        if (result) {
            size--;
            return true;
        } else {
            return false;
        }
    }

    private int hashIndex(E value) {
//        int hashCode = value.hashCode();
//        int hashIndex = Math.abs(hashCode) & capacity; //  abs는 항상 절대값으로 반환해주기에 -를 없앤다
//        return hashIndex;
        return Math.abs(value.hashCode()) % capacity; // inline valiable
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV3{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
