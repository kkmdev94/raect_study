package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain2 {

    public static void main(String[] args) {
        // 중복 등록
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberOnlyHash m1 = new MemberOnlyHash("A");
        MemberOnlyHash m2 = new MemberOnlyHash("A");
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));
        /*
        두개의 해쉬코드를 비교했을때 둘의 참조값이 다르다. 내부적으로 equals를 재정하지 않았으면 MyHashSet의 contains의 내부에서 순차비교시 equals를 사용하는데 Object의 equlals를
        상속받아서 사용한다. 따라서 인스턴스 참조값을 비교하기에 m1과 m2는 비교에 실패하고
        System.out.println("System.identityHashCode(m1) = " + System.identityHashCode(m1));
        System.out.println("System.identityHashCode(m2) = " + System.identityHashCode(m2));
        이에 따라 중복데이터가 없다고 판단한 자바는 add 메서드에서 중복이 없는것으로 파악하여 m1,m2를 모두 저장하는 것이다.
         */
        set.add(m1);
        set.add(m2);
        System.out.println(set);

        // 검색 실패
        MemberOnlyHash searchValue = new MemberOnlyHash("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);
    }
}
