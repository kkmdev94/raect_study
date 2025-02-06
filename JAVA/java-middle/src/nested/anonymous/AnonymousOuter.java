package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {

    private int outInstanceVar = 3;

    public void process(int paramVar) {
        int localVar = 1;

        Printer printer = new Printer() { // 인터페이스를 생성한게 아닌, Printer라는 이름의 인터페이스를 구현한 익명 클래스를 생성. Printer를 상속(구현)하면서 바로 생성하는 것.
            // 익명 클래스는 부모 클래스를 상속 받거나, 또는 인터페이스를 구현해야 하기에, 상위 클래스나 인터페이스가 없으면 사용할 수 없다.
            // 또한 이름이 없기에 생성자를 가질 수 없다.(기본 생성자만 사용됨)
            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar= " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        };
        printer.print();
        System.out.println("printer.getClass = " + printer.getClass());
        // printer.getClass = class nested.anonymous.AnonymousOuter$1 -> 익명 클래스는 이름이 없어서 갯수로 표시된다.
    }

    public static void main(String[] args) {
        AnonymousOuter main = new AnonymousOuter();
        main.process(2);
    }
}
