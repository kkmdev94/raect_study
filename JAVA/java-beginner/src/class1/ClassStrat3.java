package class1;

public class ClassStrat3 {

    public static void main(String[] args) {
        Student student1; // 객체를 변수로 선언
        student1 = new Student(); // <- 이것을 객체 또는 인스턴스라고 한다.(붕어빵)
        student1.name = "학생1";
        student1.age = 15;
        student1.grade =90;

        Student student2 = new Student(); // 객체를 변수로 선언(이렇게 사용하는게 낫다)
        student2.name = "학생2";
        student2.age = 16;
        student2.grade =80;

        System.out.println(student1);
        System.out.println(student2);

        System.out.println("이름 : " + student1.name + " 나이 : " + student1.age + " 성적 : " + student1.grade);
        System.out.println("이름 : " + student2.name + " 나이 : " + student2.age + " 성적 : " + student2.grade);
        // 사용자가 직접 정의하는 사용자 정의 타입 = 즉 설계도를 클래스라고 한다.
        // 그 설계도인 클래스를 사용해서 실제 메모리에 만들어진 실체를 객체 또는 인스턴스라고한다. == 클래스는 붕어빵틀 붕어빵틀을 직접 먹을 순 없으니
        // 이 틀을 가지고 먹을 수 있게 만들어진 내용물이 바로 붕어빵. 이 붕어빵을 객체 또는 인스턴스 라고 한다.
    }
}
