package extends1.ex3;

public class CarMain {

    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar(); // ElectricCar(Type) electricCar(변수명) = new ElectricCar()(인스턴스 생성) -> Type 변수명 = new 인스턴스 이렇게 생성되는 것이다.
        electricCar.move();
        electricCar.charge();
        electricCar.openDoor();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
        gasCar.openDoor();

        HydrogenCar hydrogenCar = new HydrogenCar();
        hydrogenCar.move();
        hydrogenCar.fillHydrogen();
        hydrogenCar.openDoor();
    }
}
// 그래서 메모리 구조에서는 인스턴스 생성을 위해 new를 통해 호출하면 ElectricCar 뿐 아니라 상속 관계인 Car도 호출하게 되고 하나의 인스턴스에는 호출된 클래스가 전부 하나의 인스턴스에 포함되어 있다.
// 생성된 인스턴스의 타입을 참조하여 상속된 객체의 참조값(주소지)를 찾아가고 우선적으로 호출된 타입의 클래스에 우선 접속하여 해당 메서드를 찾는다. 찾는 메서드가 존재하면 불러오고
// 해당 메서드가 없다면 상속된 부모의 값을 찾아간다. 거기도 없다면 컴파일 오류를 이르킨다.
