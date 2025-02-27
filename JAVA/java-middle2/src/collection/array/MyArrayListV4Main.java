package collection.array;

import java.util.ArrayList;

//  참고 : https://inpa.tistory.com/entry/JAVA-%E2%98%95-ArrayList-%EA%B5%AC%EC%A1%B0-%EC%82%AC%EC%9A%A9%EB%B2%95#thankYou
public class MyArrayListV4Main {

    public static void main(String[] args) {
        MyArrayListV4<String> stringList = new MyArrayListV4<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
//        stringList.add(1); // 제네릭으로 스트링을 선언하여서 숫자는 못들어간다.
        String string = stringList.get(0);
        System.out.println("string = " + string);

        MyArrayListV4<Integer> intList = new MyArrayListV4<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
//        intList.add("a"); // 제네릭으로 Integer를 선언하여서 문자는 못들어옴
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);

//        ArrayList<Integer> l = new ArrayList<>();
    }
}
