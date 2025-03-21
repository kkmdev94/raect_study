package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Integer max = Collections.max(list); // 가장 큰값
        Integer min = Collections.min(list); // 가장 작은 값

        System.out.println("max = " + max);
        System.out.println("min = " + min);

        System.out.println("list = " + list);
        Collections.shuffle(list); // 랜덤으로 섞음 ex) 카드게임 같은거 할때
        System.out.println("shuffle list = " + list);
        Collections.sort(list); // 정렬
        System.out.println("sort list = " + list);
        Collections.reverse(list); // 뒤집어서 정렬
        System.out.println("reverse list = " + list);


    }
}
