package nested.inner;

public class InnerOuterMain {

    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();
        InnerOuter.Inner inner = outer.new Inner();
        inner.print();

        System.out.println("innerClass = " + inner.getClass());
    }
}

/*
 정적 중첩 클래스에서는 static을 이용하여 외부 참조를 허용하지 않아 바로 호출이 가능하지만, 내부 클래스일 경우 Inner는 InnerOuter를 참조하고 있기에
 그 값을 알기 위해서 참조값을 알아야 한다. 즉 InnerOuter를 먼져 생성하고 InnerOuter의 참조값이 X001이라면 X001.new Inner를 통해 새로운 인스턴스를
 만들 수 있는 것이다.

 내부 클래스건 정적 중첩 클래스건 둘다 다른 인스턴스인데 static을 사용하면 바깥 클래스의 참조값을 사용을 안하니 바깥 클래스.정적 중첩 클래스로 호출이 가능하고,
 내부 클래스는 바깥 클래스의 참조값을 호출 할 수 있는대신 그 값을 알아야 하기에 바깥 클래스.new 내부클래스로 생성해준다.(단독 생성 불가)
 */
