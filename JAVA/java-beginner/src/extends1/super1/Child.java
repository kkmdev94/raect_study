package extends1.super1;

public class Child extends Parent {

    public String value = "child";

    @Override
    public void hello() {
        System.out.println("Child.hello");
    }

    public void call() {
        System.out.println("this value = " + this.value); // this 생략 가능
        System.out.println("super value = " + super.value);

        this.hello(); // this 생략 가능
        super.hello();
    }
}
/* 부모 클래스와 상속받은 자식 클래스의 메서드 이름이 같고, 부모 클래스의 값을 참조해야 할때
부모 클래스의 값을 참조해야 하는경우에는 super를 자기 자신을 참조할 때는 this를 사용한다. 단, 자기 자신을 참조할때는 this는 생략이 가능하다.

깨달은것 : this 생략 가능과 생략 불가능이 헷갈려서 확인을 해보았다. 생성자에서는 참조값을 무조건 넘겨받아야하니 나 자신을 참조할 수 없어서 this가 필요하다.
            메서드에서는 참조값을 나 자신으로 그냥 해도 되기에 this가 생략이 가능하다.
자세한 설명은 생성자(construct)의 MemberConstruct의 클래스 맨 아래에 설명으로 작성해 놓았다.
 */

