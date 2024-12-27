package extends1.overriding;

public class ElectricCar extends Car {

    public void charge() {
        System.out.println("충전합니다.");
    }

    @Override //새로 재정의 /  메서드 오버라이딩 / @는 애노테이션이라 한다.
    public void move() {
        System.out.println("전기차를 빠르게 이동합니다.");
    }
}

//애노테이션은 주석과 비슷한데, 프로그램이 읽을 수 있는 특별한 주석이라 생각하면된다. 자세한 설명은 추후.
// @Override 없어도 동작은 가능, 하지만 무조건 서술 이유는? -> 제대로 오버라이드를 하기 정확하게 오버라이드를 안하면 컴파일 오류를 일으키기 위해 존재 / 표식을 남기는 것이다.
