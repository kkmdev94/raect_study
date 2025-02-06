package nested.anonymous.ex;

public class Ex0RefMain {
    // 선생님 풀이 / 내 풀이는 Ex0MainRef1

//    public static void helloJava() {
//        System.out.println("프로그램 시작"); // 변하지 않는 부분
//        System.out.println("Hello Java"); // 변하는 부분
//        System.out.println("프로그램 종료"); // 변하지 않는 부분
    // 핵심은 변하는 부분과 변하지 않는 부분을 분리하는것. 이 분리로 인해 아래의 hello 메서드는 변하는 부분을 외부에서 받아오기에 재사용성이 매우 높아졌다.
//    }

    public static void hello(String str) {
        System.out.println("프로그램 시작");
        System.out.println(str);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello("Hello Java");
        hello("Hello Spring");
    }
}
