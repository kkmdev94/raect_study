package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest2 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        // 선생님 로직이고 1번이 내가 풀은 것이다.
        String[] split = text.split(" ");
        Map<String, Integer> txt = new HashMap<>();
        for (String word : split) {
            Integer count = txt.get(word);
            if (count == null) {
                count = 0;
            }
            count++;

            txt.put(word, count);
        }
        System.out.println(txt);
    }
}
