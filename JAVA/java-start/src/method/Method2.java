package method;

public class Method2 {

    public static void main(String[] args) {
//        String str = printHeader(); //반환타입이 void이기 때문에 반환 값을 받으면 컴파일 오류가 발생한다.
        printHeader();
        System.out.println("프로그램이 동작합니다.");
        printFooter(15);
    }

    // 리턴값 즉, 반환해야되는 값이 없을때는 void를 집어 넣어줘야 한다.
    public static void printHeader() { //매개변수가 없을 경우 비워두고 정의하면 된다.
        System.out.println("= 프로그램을 시작합니다 =");
        return; // 반환값이 없을 경우 생략이 가능하다.
    }

    public static void printFooter(int i) {
        if (i <= 10) {
            System.out.println("= 프로그램을 종료합니다. = ");
            return;
        }
        System.out.println("!");
    }
}

/* 즉 현재 예제에서 사용하는 메서드는 반환 타입도 매개변수도 없다
그래서 public static void printFooter() 처럼 매개변수가 없을 경우 () 안을 비워주면되고 호출할떄도
printHeader() 처럼 ()안을 비워주면 된다.
또한 public static void printFooter() 처럼 int나 String이 아닌 void로 반환 타입이 없을 경우
String str = printFooter() 와 같이 타입을 반환 하려 하면 오류가 발생한다.
그리고 또한 반환 타입이 없을 경우 return은 생략이 가능하다.
 */