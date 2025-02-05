package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {

    private int outInstanceVar = 3;


    public Printer process(int paramVar) {
        int localVar = 1; // 지역 변수는 스택 프레임이 종료되는 순간 함께 제거된다.

        class LocalPrinter implements Printer { // 인터페이스도 구현 가능.
            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);
                //인스턴스는 지역 변수보다 더 오래 살아 남는다.
                System.out.println("localVar= " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        // 만약 localVar의 값을 변경한다면? 다시 캡처해야 하나??
//        localVar = 10; // 컴파일 오류
//        paramVar = 20; // 컴파일 오류
        // 변수 캡처 내용이 어렵다면 단순하게 지역 클래스가 접근하는 지역 변수의 값은 변경하면 안된다. 즉, final이거나 사실상 final이어야 한다.
        return printer;
    }

    public static void main(String[] args) {
        LocalOuterV4 localOuter = new LocalOuterV4();
        Printer printer = localOuter.process(2);
        printer.print();
    }
}
