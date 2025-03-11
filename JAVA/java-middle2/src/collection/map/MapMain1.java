package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain1 {

    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>(); // key는 중복 x, value는 중복 O

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);

        System.out.println(studentMap);

        // 특정 학생의 값 조회
        Integer result = studentMap.get("studentD");
        System.out.println("result = " + result);

        System.out.println("KeySet 활용");
        Set<String> keySet = studentMap.keySet();// 키만 반환 / set 자료 구조로 반환 -> 이유는 순서 보장 x 중복 x set의 자료구조와 같아서 set으로 반환된다.
        for (String key : keySet) {
            Integer value = studentMap.get(key); // 키값만 반환을 해주니 map.get을 이용해 키의 값을 value에 담아준다.
            System.out.println("key= " + key + ", value = " + value); // 그래서 key만 가져오는것인데 키와 밸류를 둘다 가져왔다.
        }

        System.out.println("entrySet 활용"); // 위 KeySet과 다른점은 KeySet은 key값만 가져오지만 entrySet은 키-값을 전부다 가져온다.
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet(); // Map 안의 모든 키-값 쌍을 Set 구조로 가져온다.
        for (Map.Entry<String, Integer> entry : entries) { // 안에 들어있는 키-값을 모두 가져오기 위한 루프
            String key = entry.getKey(); // entry.getkey와 getvalue로 각각의 키와 값을 얻은 후
            Integer value = entry.getValue();
            System.out.println("key1= " + key + ", value1 = " + value); // 출력
        }

        System.out.println("values 활용"); // value만 꺼낸다. 이때 values는 중복이 가능하기에 컬럭센으로 꺼낸다.
        Collection<Integer> values = studentMap.values();
        for (Integer value : values) {
            System.out.println("value = " + value);
        }
    }
}
