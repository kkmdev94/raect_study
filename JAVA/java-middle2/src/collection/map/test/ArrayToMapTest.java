package collection.map.test;

import java.util.*;

public class ArrayToMapTest {

    public static void main(String[] args) {
//        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};
//        for (String[] s : productArr) {
//            System.out.println("s = " + Arrays.toString(s));
//        }
        // Map으로 변환
        run(new HashMap<>());
    }

    private static void run(Map<String, Integer> map) {
        map.put("Java", 10000);
        map.put("Spring", 20000);
        map.put("JPA", 30000);

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("제품 : " + key + ", 가격 : " + map.get(key));
        }
    }
}
