package collection.array;

public class MyArrayListV3Main {

    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();
        //마지막에 추가 //O(1)
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        // 원하는 위치에 추가
        System.out.println("addLast");
        list.add(3, "addList"); //O(1)
        System.out.println(list);

        System.out.println("addFirst"); // 가장 오래걸림 / 0번에 들어가기 위해 모든 데이터를 다 밀어내야 한다.
        list.add(0,"addFirst"); //O(n)
        System.out.println(list);

        // 삭제
        Object removed1 = list.remove(4);
        System.out.println("removed(4) = " + removed1);
        System.out.println(list);

        Object removed2 = list.remove(0);//remove First O(n)
        System.out.println("removed2 = " + removed2);
        System.out.println(list);

        /*
        배열 리스트의 빅오
            - 데이터 추가
                - 마지막에 추가 : O(1)
                - 앞,중간에 추가 : O(n)
            - 데이터 삭제
                - 마지막에 삭제: O(1)
                - 앞,중간에 삭제 : O(n)
            - 인덱스 조회 : O(1)
            - 데이터 검색 : O(n)
        배열 리스트는 마지막에 데이터를 추가/삭제하는 경우에는 O(1)로 매우 빠르지만 중간 데이터를 추가/제거하는경우 O(n)으로 느리다.
        따라서 배열리스트는 데이터를 중간에 추가/삭제하는 변경 보다는, 데이터를 순서대로 입력하고(마지막에 추가하고) 순서대로 출력하는 경우에 효율적이다.
         */

    }
}
