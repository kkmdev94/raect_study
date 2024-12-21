package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    //추가
    MemberConstruct(String name, int age) {
        this(name, age, 50); // 중요!! this를 통한 생성자 호출은 생성자 코드의 첫줄에만 작성 할 수 있다. / 생성자 안에서만 사용 가능
//        this.name =name;
//        this.age = age;
//        this.grade = 50;
    }
    /*
    위의 this를 사용한 이유는 : 생성자 내부에서 다른 생성자를 호출할때 사용한다. grade를 제외한 name과 age는 중복이기에 굳이 다 작성할 필요 없이
    2개의 인자값을 받는 생성자를 생성하고 3번째 생성자를 오버로딩 하여 호출해서 인자값을 동일하게 넘겨준다. 이때 호출시 지역 변수 값을 2개만 작성한
    객체는 값이 50으로 고정되는 것 뿐이다.
     */

    MemberConstruct(String name) {
        System.out.println("name! " + name);
        this.name =name;
    }
    /*
    조금 이해가 갔다. 생성자는 얼마든지 늘릴 수 있다. 다만 그것을 구분하는것은 매개 변수로 구분을 짓는다.
    즉, 호출을 할때 매개변수의 갯수에 따라 얼마든지 원하는 생성자를 불러올 수 있다.
     */

    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name = " + name + ", age = " + age + ", grade = " + grade);
        this.name = name; // 멤버변수 = 지역변수
        this.age = age;
        this.grade = grade;
    }
}
