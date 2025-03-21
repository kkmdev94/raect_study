package collection.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {

    public static void main(String[] args) {
        // 편리한 불변 컬렉션 생성
        List<Integer> list = List.of(1, 2, 3); // 불변이라 값을 바꿀 수 없다. add(추가), set(변경) 등 안된다.
        Set<Integer> set = Set.of(1, 2, 3);
        Map<Integer, String> map = Map.of(1, "one", 2, "two");

        System.out.println("list = " + list);
        System.out.println("set = " + set);
        System.out.println("map = " + map);

        // 중첩된 리스트 N이라는 클래스가 만들어지는데 앞에 Immutable이 붙으면서 불변이 된다.
        System.out.println("list.getClass() = " + list.getClass());

//        list.add(1); //java.lang.UnsupportedOperationException 예외 발생
    }
}
