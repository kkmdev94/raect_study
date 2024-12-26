package final1;

public class FinalFieldMain {

    public static void main(String[] args) {
        //final 필드 - 생성자 초기화
        System.out.println("생성자 초기화");
        ConstructInit constructInit1 = new ConstructInit(10); // 인스턴스를 생성하는거기에 주소가 달라서 변경가능, 단 final을 썻으므로 이 값은 변경 될 수 없다.
        ConstructInit constructInit2 = new ConstructInit(20); // x001, x002의 값은 10과 20으로 지정 되었지만 이제 x001과 x002는 10과 20으로 고정되어 변경이 불가능하다는 뜻.
        System.out.println(constructInit1.value);
        System.out.println(constructInit2.value);

        //final 필드 - 필드 초기화
        System.out.println("필드 초기화");
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        FieldInit fieldInit3 = new FieldInit();
        System.out.println(fieldInit1.value);
        System.out.println(fieldInit2.value);
        System.out.println(fieldInit3.value);

        // 상수
        System.out.println("상수 초기화");
        System.out.println(FieldInit.CONST_VALUE);

    }
}
