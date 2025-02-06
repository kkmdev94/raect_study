package nested.anonymous.ex;

public class Ex0MainRef1 {

    public void studys(String study) {
        String name = study;

        Hello hello = new Hello() {

            @Override
            public void print() {
                System.out.println("프로그램 시작");
                System.out.println(name);
                System.out.println("프로그램 종료");
            }
        };
        hello.print();
    }

    public static void main(String[] args) {
        Ex0MainRef1 ex0Main1 = new Ex0MainRef1();
        ex0Main1.studys("Hello Java");
        ex0Main1.studys("Hello Spring");
    }
}
