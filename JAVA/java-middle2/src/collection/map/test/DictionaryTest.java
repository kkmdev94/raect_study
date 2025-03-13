package collection.map.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DictionaryTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> dictionary = new HashMap<>();

        System.out.println("== 단어 입력 단계 ==");
        while (true) {
            System.out.print("영어 단어를 입력하세요 (종료는 'q') : ");
            String key = sc.nextLine();
            if (key.equals("q")) {
                break;
            }
            System.out.print("한글 뜻을 입력하세요 : ");
            String value = sc.nextLine();

            dictionary.put(key, value);
        }

        System.out.println("== 단어 검색 단계 ==");
        while (true) {
            System.out.print("찾을 영어 단어를 입력하세요 (종료는 'q') : ");
            String searchKey = sc.nextLine();

            if (searchKey.equals("q")) {
                break;
            }
            if (dictionary.containsKey(searchKey)) {
                String korean = dictionary.get(searchKey);
                System.out.println(searchKey + "의 뜻 : " + korean);
            } else {
                System.out.println(searchKey + "은(는) 사전에 없는 단어입니다.");
            }
        }
    }
}
