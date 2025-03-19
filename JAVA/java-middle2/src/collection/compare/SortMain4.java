package collection.compare;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortMain4 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        List<MyUser> list = new LinkedList<>();
        list.add(myUser1);
        list.add(myUser2);
        list.add(myUser3);
        System.out.println("기본 데이터");
        System.out.println(list);

        System.out.println("Comparable 기본 정렬");
        list.sort(null); // Comparator 사용 안할꺼면 null을 넣어주면 된다.
//        Collections.sort(list); // 두개 다 결과는 같지만 list.sort를 더 권장 / 이유는 객체 스스로 정렬 메서드를 가지고 있기 떄문이다.
        System.out.println("list = " + list);

        System.out.println("IdComparator 정렬");
        list.sort(new IdComparator());
//        Collections.sort(list, new IdComparator());
        System.out.println("list1 = " + list);

        System.out.println("IdComparator 정렬");
        list.sort(new IdComparator().reversed());
        System.out.println("list1 = " + list);


    }
}
