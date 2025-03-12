package collection.map.test;

import java.util.*;

public class CommonKeyValueSum1 {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 4);
        map2.put("C", 5);
        map2.put("D", 6);

        // 문제는 map2의 value값을 어떻게 구할것이냐 인데...
        Map<String, Integer> map3 = new HashMap<>();
        Set<String> keySet = map1.keySet();
        for (String key : keySet) {
            Integer value = map1.get(key);
            if (map2.containsKey(key)) {
                map3.put(key, value + map2.get(key));
            }
        }
        System.out.println(map3);
    }
}
