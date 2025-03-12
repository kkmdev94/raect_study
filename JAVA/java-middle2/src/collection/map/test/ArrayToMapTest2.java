package collection.map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayToMapTest2 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
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
