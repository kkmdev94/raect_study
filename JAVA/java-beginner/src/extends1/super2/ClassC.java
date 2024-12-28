package extends1.super2;

public class ClassC extends ClassB{

    public ClassC() {
//        super(); // ClassB에서는 생성자가 존재하므로 기본 생성자를 넣을 수 없어 생략할 수 없다
        super(10,20);  //그래서 이렇게 첫줄에 생성자와 참조값을 넣어주어야 한다.
        System.out.println("ClassC 생성자");
    }
}
// ClassA를 상속 받은 ClassB는 ClassA에서 기본적으로 매개 변수를 참조하는 생성자가 없어서 생성자의 맨 앞에 super()가 생략이 가능했다.
// 하지만 ClassB를 상속받은 ClassC는 ClassB에서 이미 매개 변수(패러미터)를 받는 생성자가 2개나 존재 하므로
// super()의 생략이 불가능 하여 생성자 호출시 참조값을 반듯이 적어야 한다.
