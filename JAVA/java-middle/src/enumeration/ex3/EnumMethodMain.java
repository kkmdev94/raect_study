package enumeration.ex3;

import java.util.Arrays;

public class EnumMethodMain {

    public static void main(String[] args) {
        // 모든 ENUM 반환
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values));
        for (Grade value : values) {
            System.out.println("name = " + value.name() + ", ordinal = " + value.ordinal()); // ordinal -> 해당 배열의 순서
        }

        //String -> ENUM 변환
        String input = "GOLD";
        Grade grade = Grade.valueOf(input);
        System.out.println("grade = " + grade); // toString() 오버라이딩 가능
    }
}
