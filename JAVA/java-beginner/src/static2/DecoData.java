package static2;

public class DecoData {

    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {
//        instanceValue++; // 인스턴스 변수 접근, compile error
//        instanceMethod();// 인스턴스 메서드 접근, compile error
        // 이유는 : staticCall()은 static이 붙었기에 클래스 소속이다. 인스턴스 변수는 인스턴스를 생성하고 그 참조값을 알아야 할 수 있는데 나는 그것을 알 수가 없다. 그래서 인스턴스에 접근 할 수 없다.
        // 그래서 static은 static만 접근할 수 있다.

        /* 이해 한것 : DecoDataMain에서 staticCall을 호출 한다 -> 그러면 클래스 소속이기 때문에 호출을 하면 클래스.staticCall을 하는데 -> 인스턴스는 객체를 생성해야 즉, DecoData data1 = new DecoData()
         이렇게 생성을 해줘야 힙 영역에 인스턴스가 생성되는데 클래스.staticCall을 하므로써 생성된 인스턴드가 없으니 참조 값도 없어서 어떤걸 참조해야 하는 지 모르기에 오류가 발생하는 것이고,
         그래서 static 에서는 static 만이 사용이 가능하다. */

        staticValue++; // 정적 변수 접근
        staticMethod(); // 정적 메서드 접근
    }

    //예외
    // 외부에서 참조값이 넘어오는 경우는 가능하다. 아래의 예시 같은 경우 Main에서 호출하면 DecoData.staticCall(data) -> 이렇게 참조 값을 넘겨주면서 호출을 하기때문에 당연하게 되는 것이다.
    // DecoData.staticCall(x001)이 넘어오고 DecoData data = x001 이 되고 data.instanceValue 같은 경우 x001.instanceValue가 되기에 당연하게 되는 것이다.
    public static void staticCall(DecoData data) {
        data.instanceValue++;
        data.instanceCall();
    }

    public void instanceCall() {
        instanceValue++; // 인스턴스 변수 접근
        instanceMethod();// 인스턴스 메서드 접근

        staticValue++; // 정적 변수 접근 / DecoData.staticValue -> 생략되있어서 접근 가능
        staticMethod(); // 정적 메서드 접근
        //인스턴스 메서드에서는 두개 다 사용 가능하다.
    }

    private void instanceMethod() {
        System.out.println("instanceValue = " + instanceValue);
    }

    private static void staticMethod() {
        System.out.println("staticValue = "+ staticValue);
    }

}
