package collection.set;

import collection.set.member.Member;

public class MyHashSetV2Main2 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        Member hi = new Member("hi");
        Member jpa = new Member("JPA"); //HashSet에서 대소문자는 꼭 구분해야된다. code값이 달라질 수 있다.
        Member java = new Member("java");
        Member spring = new Member("spring");

        System.out.println("hi.hashCode() = " + hi.hashCode());
        System.out.println("jpa.hashCode() = " + jpa.hashCode());
        System.out.println("java.hashCode() = " + java.hashCode());
        System.out.println("spring.hashCode() = " + spring.hashCode());

        set.add(hi);
        set.add(jpa);
        set.add(java);
        set.add(spring);
        System.out.println(set);
        /*
            기존 Member에서 hashCode 메서드에서 return 값을 objects.hash가 아닌 Objects.hashCode를 했더니 값이 완전히 다르게 나왔었다
            이러한 부분을 되게 조심하고 hashCode return값에서 Objects.hash와 Objects.hashCode의 차이점에 대해 조금 알아보자 왜 다른지 궁금하다.
         */

        //검색
        Member searchValue = new Member("JPA");
        boolean result = set.contains(searchValue);
        System.out.println("set.contains("+ searchValue +") = " + result);
    }
}
