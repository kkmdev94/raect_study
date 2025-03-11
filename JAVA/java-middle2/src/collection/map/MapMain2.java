package collection.map;

import java.util.HashMap;

public class MapMain2 {

    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 90);
        System.out.println("studentMap1 = " + studentMap);

        studentMap.put("studentA", 80);
        System.out.println("studentMap2 = " + studentMap); // 같은 키에 저장시 기존 값 교체

        boolean containsKey = studentMap.containsKey("studentA"); // 해당 키가 존재 하는지 체크
        System.out.println("containsKey = " + containsKey);

        // 특정 학생의 값 삭제
        studentMap.remove("studentA"); // 값이 통째로 사라진다.
        System.out.println("studentMap = " + studentMap);
    }
}
