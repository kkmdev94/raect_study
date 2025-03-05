package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

    static final int CAPACITY = 20;

    public static void main(String[] args) {
        // {1, 2, 5, 8, 14 ,99}
        LinkedList<Integer>[] list = new LinkedList[CAPACITY]; // linkedlist 안에 []을 이용해 배열을 만든다 / 링크드리스트를 하나의 바구니라고 보면 이 바구니를 여러 개, 배열로 만드는 것.
        //  즉 위에 것은 링크드리스트를 생성한게 아니라 배열을 만든 것이다. 배열은 배열인데 링크드 리스트를 넣을 수 있는 배열을 만든 것이다.
        System.out.println("Arrays.toString(list) = " + Arrays.toString(list));
        for (int i = 0; i < CAPACITY; i++) {
            list[i] = new LinkedList<>(); // 즉 배열 안에 링크드리스트가 생성된다는 것이다. 0번 배열에 링크드리스트가 있고 1번 배열에 링크드리스트가 있다는 뜻이다.
        }
        System.out.println("list = " + Arrays.toString(list));

        add(list, 1);
        add(list, 2);
        add(list, 5);
        add(list, 8);
        add(list, 14);
        add(list, 99);
        add(list, 9); // 중복
        System.out.println("Arrays.toString(list) = " + Arrays.toString(list));

        // 검색
        int searchValue = 7;
        boolean contains = contains(list, searchValue);
        System.out.println("contains("+ searchValue + ") = " + contains);
    }

    private static void add(LinkedList<Integer>[] list, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = list[hashIndex]; //O(1)
        if (!bucket.contains(value)) { // O(n)
            bucket.add(value);
        }
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }

    private static boolean contains(LinkedList<Integer>[] list, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = list[hashIndex];
        return bucket.contains(value);
    }
}
