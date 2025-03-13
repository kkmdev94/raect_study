package collection.map.test;

import java.util.*;

public class ItemPriceTest1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);

        List<String> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        int price = 1000;
        for (String key : keySet) {
            Integer value = map.get(key);
            if (value >= price) {
                list.add(key);
            }
        }
        System.out.println(list);
    }
}
