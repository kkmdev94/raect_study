package lang.object.tostring;

public class ToStringMain2 {

    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 5);

        System.out.println("1. 단순 toString 호출");
        System.out.println(car.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());

        System.out.println();

        System.out.println("2. println 내부에서 toString 호출");
        System.out.println(car); //println 내부에서 toString을 통해 object를 호출한다.
        System.out.println(dog1); // 따라서 위의 코드와 아래 코드는 똑같다.
        System.out.println(dog2);

        System.out.println();

        System.out.println("3. Object 다형성 활용");
        ObjectPrinter.printer(car);
        ObjectPrinter.printer(dog1);
        ObjectPrinter.printer(dog2);

        // 메서드 오버라이딩을 통해 재정의 된 toString이나 hashCode가 있어서 객체의 참조값을
        // 보지 못하는 경우에 사용.
        String value = Integer.toHexString(System.identityHashCode(dog1));
        System.out.println("value = " + value);
        String value2 = Integer.toHexString(System.identityHashCode(dog2));
        System.out.println("value2 = " + value2);
    }
}
