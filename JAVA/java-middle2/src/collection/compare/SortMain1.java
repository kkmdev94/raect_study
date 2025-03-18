package collection.compare;

import java.util.Arrays;

public class SortMain1 {

    public static void main(String[] args) {
        Integer[] array = {3, 2, 1};
        System.out.println(Arrays.toString(array));

        System.out.println("기본 정렬 후"); // 여기서의 정렬은 순서대로 오름차순 내림차순으로 정렬 시키는 그 의미의 정렬이다.
        Arrays.sort(array); // sort는 오름차순
        System.out.println(Arrays.toString(array));
    }
}
