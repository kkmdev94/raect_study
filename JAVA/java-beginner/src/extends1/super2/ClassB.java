package extends1.super2;

public class ClassB extends ClassA {

    public ClassB(int a) {
//        super(); //기본 생성자 생략 가능 / 매개 변수 없는 기본 생성자의 경우에는 생략하면 자바가 자동으로 만들어 준다.
        this(a, 0); // 첫줄에 this가 와도 괜찮지만 결국 같은 클래스 내의 다른 생성자를 호출하기에 결국 하나의 생성자에서는 무조건 super가 나와야 한다.
        System.out.println("ClassB 생성자 a = " + a);
    }

    public ClassB(int a, int b) {
        super();
        System.out.println("ClassB 생성자 a = " + a + " b " + b);
    }
}
// 상속을 받으면 부모 클래스에서 매개 변수(파라미터)를 받는 생성자가 없다면 super는 생략이 가능하지만. ClassB처럼 매개 변수(파라미터)를 받는 생성자가 생기는 순간
// ClassB를 상속받는 자식에서는 무조건 super를 한번은 생성해야 한다.