package Poly.basic;

public class CastingMain2 {

    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조(다형성 참조)
        Parent poly = new Child(); // 여기 있는 인스턴스(객체)를 x001이라고 했을때
        //단 자식의 기능은 호출할 수 없다.
        //poly.childMethod();

        //일시적 다운캐스팅 - 해당 메서드를 호출하는 순간만 다운캐스팅
        ((Child) poly).childMethod();
    }
}
