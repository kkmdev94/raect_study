package Poly.basic;

public class CastingMain1 {

    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조(다형성 참조)
        Parent poly = new Child(); // 여기 있는 인스턴스(객체)를 x001이라고 했을때
        //단 자식의 기능은 호출할 수 없다.
        //poly.childMethod();

        //다운캐스팅(부모 타입 -> 자식 타입)
        Child child = (Child) poly; // poly에 x001이 담겨있는데 이것을 Child로 강제형변환으로 변경 시킬 수 있다.
        child.childMethod();
    }
}
