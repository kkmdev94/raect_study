package exception.ex4;
import exception.ex4.exception.SendExceptionV4;

import java.util.Scanner;

public class MainV5 {

    public static void main(String[] args) {
        NetworkServiceV5 service = new NetworkServiceV5();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자 : ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }

            try {
                service.sendMessage(input);
            } catch (Exception e) {
                exceptionHandler(e);
            }

            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }

    // 공통 예외 처리
    private static void exceptionHandler(Exception e) {
        //공통 처리
        System.out.println("사용자 메시지 : 죄송하빈다. 알 수 없는 문제가 발생해습니다.");
        System.out.println("== 개발자용 디버깅 메시지 ==");
        e.printStackTrace(System.out); // 스택 트레이스 출력
//         e.printStackTrace();
        // 위 printStackTrace의 차이점은 out 과 err 의 차이점이 있다. err로 하면 콘솔에서 글자를 빨간색으로 출력해주는데
        // out을 사용하지 않고 기본값(err를 사용하는것과 같다)을 사용하면 출력하는 콘솔의 스트림의 성향이 달라 좀 꼬여서 출력이된다. 그리고 일반적으로는 err를 사용하다.
        // 실무에서는 err나 out을 사용하지 않고 Slf4J, logback 같은 별도의 라이브러리를 사용한다.(나중에 스프링 들어가면 배운다.)

        // 필요하면 예외 별로 별도의 추가 처리 기능 (만들어놓은 에러를 보면 new를 통해서 새로 인스턴스를 생성해서 넘기는 것으로 객체가 넘어오는 것이다.)
        if (e instanceof SendExceptionV4 sendEx) {
            System.out.println("[전송 오류] 전송 데이터 : " + sendEx.getSendDate());
        }
    }
}
