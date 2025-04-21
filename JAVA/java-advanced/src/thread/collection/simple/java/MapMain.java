package thread.collection.simple.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapMain {

    public static void main(String[] args) {
        Map<Integer, String> map1 = new ConcurrentHashMap<>(); // 순서 보장 X
        map1.put(3, "data3");
        map1.put(2, "data2");
        map1.put(1, "data1");
        System.out.println("map1 = " + map1);

        Map<Integer, String> map2 = new ConcurrentSkipListMap<>(); // comparator 사용 가능, 데이터의 정렬 순서를 유지.
        map1.put(3, "data3");
        map1.put(2, "data2");
        map1.put(1, "data1");
        System.out.println("map1 = " + map1);
    }
}
