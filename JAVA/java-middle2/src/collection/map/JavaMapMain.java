package collection.map;

import java.util.*;

public class JavaMapMain {

    public static void main(String[] args) {
        //주의 : Map의 Key로 사용되는 객체에는 hashCode와 equals를 반드시 구현해야 한다.
        run(new HashMap<>()); // key가 set과 동일하게 출력
        run(new LinkedHashMap<>()); // key가 linked처럼 입력한 순서대로 출력된다. / 노드 입력 방법은 그림 참조 / 저장될때는 key만 가지고 해시 코드 생성, 저장할때는 entry로 저장
        run(new TreeMap<>()); // key가 tree 구조 와 똑같이 들어간다.
    }

    private static void run(Map<String, Integer> map) {
        System.out.println("map = " + map.getClass());
        map.put("C", 10);
        map.put("A", 20);
        map.put("B", 30);
        map.put("1", 40);
        map.put("2", 50);

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator(); // iterator = 반복하다. 향상for문의 iter이 이 단어의 줄임말이다.
        while (iterator.hasNext()) { // has안에 다음데이터가 있는지 확인하고
            String key = iterator.next(); // 다음 데이터가 있다면 반환한다.
            System.out.println(key + "=" + map.get(key) + " ");
        }
    }
}
