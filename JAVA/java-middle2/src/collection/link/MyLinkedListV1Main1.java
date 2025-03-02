package collection.link;

public class MyLinkedListV1Main1 {

    public static void main(String[] args) {
        MyLinkedListV1 list = new MyLinkedListV1();
        System.out.println("== 데이터 추가");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);

        System.out.println("== 기능 사용 ==");
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get() = " + list.get(1));
        System.out.println("list.indexof('c') = " + list.indexof("c"));
        System.out.println("list.set(2,'z') = " + list.set(2, "z"));
        // c가 리턴된 이유는 set메서드에서 oldValue 즉 기존값을 반환하게 해놔서 그렇다. list를 출력해보면 2번째에는 정상적으로 z가 대입되어 있다.
//        System.out.println(list);

        System.out.println("== 범위 초과 ==");
        list.add("d");
        System.out.println(list);
        list.add("e");
        System.out.println(list);
        list.add("f");
        System.out.println(list);
    }
}
