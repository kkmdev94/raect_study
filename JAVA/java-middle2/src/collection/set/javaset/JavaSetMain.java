package collection.set.javaset;

import java.util.*;

public class JavaSetMain {

    public static void main(String[] args) {

        run(new HashSet<String>()); // hashCode 기반으로 출력 / 순서 보장 X / O(1)
        run(new LinkedHashSet<String>()); // 링크 구조를 통해 입력한 순서대로 출력 / 순서 보장 O / O(1)
        run(new TreeSet<String>()); // 데이터의 순서대로 정렬을 해서 보여준다. / O(log n)

    }

    private static void run(Set<String> set) {
        System.out.println("set = " + set.getClass());

        set.add("C");
        set.add("B");
        set.add("A");
        set.add("1");
        set.add("2");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) { // 다음 데이터가 있는지 확인
            System.out.print(iterator.next() + " "); // 있으면 다음 데이터를 반환
        }
        System.out.println();
    }
}
