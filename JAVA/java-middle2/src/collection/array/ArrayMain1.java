package collection.array;

import java.util.Arrays;

public class ArrayMain1 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        // index 입력 : O(1) -> 빅오 표현법 : 데이터를 몇번의 계산만으로 찾냐라는 표기법으로 자세한건 뒤에서 다룬다.
        System.out.println("==index 입력 : O(1)==");
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(Arrays.toString(arr));


        System.out.println("index 변경: O(1)==");
        arr[2] = 10;
        System.out.println(Arrays.toString(arr));

        System.out.println("==index 조회: O(1)==");
        System.out.println("arr[2] = " + arr[2]);

        System.out.println("==배열 검색: O(n)==");
        System.out.println(Arrays.toString(arr));
        int value = 10;
        for (int i = 0; i < arr.length; i++) { // 배열의 검색은 배열의 크기만틈 연산이 필요하다. 즉, 배열의 크기가 n이면 연산도 n만큼 필요하므로 성능이 매우 좋지 않다.
            System.out.println("arr[" + i + "]: " + arr[i]);
            if (arr[i] == value) {
                System.out.println(value + " 찾음");
                break;
            }
        }
    }
}
