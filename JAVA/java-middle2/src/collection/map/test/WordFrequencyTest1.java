package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        int count = 0;

        String[] split = text.split(" ");
        Map<String, Integer> txt = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            txt.put(split[i], txt.getOrDefault(split[i], count) + 1);
//            System.out.println("split = " + split[i]); // 우연치 않게 맞았던 이유는 카운터를 1개씩 증겨시켜놨고, 매개변수의 값이 하나씩 올라가 있으니 우연치 않게 맞은것이다.
//            if (!txt.containsKey(split[i])) { // 자세한건 map의 memo에 남겨놧다.
//                txt.put(split[i], count++);
//            }
        }
        System.out.println(txt);
    }
}
