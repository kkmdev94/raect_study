package collection.set.test;

import java.util.*;

public class UniqueNamesTest2 {

    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        Set<Integer> set = new LinkedHashSet<>(List.of(inputArr)); // 간단하게 set을 만들 수 있다.
//        Set<Integer> set = new LinkedHashSet<>();

//        for (Integer s : inputArr) { // list.of에 컬렉션을 넣고 생성을 하면 루프를 돌면서 값을 넣는 로직을 줄일 수 있다.
//            set.add(s);
//        }

        for (Integer s : set) {
            System.out.println(s);
        }
    }
}
