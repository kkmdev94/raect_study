package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController { // 이것의 핵심은 Provider든 프록시든 진짜 객체를 조회하는 필요한 시점까지 지연처리 하는 것이다.

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo") // 매핑으로 로그-데모 요청이 오면
    @ResponseBody // 뷰 화면 없이 문자를 바로 반환.
    public String logDemo(HttpServletRequest request) throws InterruptedException { // 자바에서 제공하는 표준 서블릿 규약에 의한 http request 정보를 받을 수 있다. 즉, 고객 요청 정보를 받을 수 있음.
//        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString(); // getRequestURLㅇ을 통해 어떤 URL로 요청했는지 알 수 있다.

        System.out.println("myLogger = " + myLogger.getClass());
        // 여기서 확인하면 CGLIB라는 라이브러리로 내 클래스를 상속받은 가짜 프록시 객체를 만들어서 주입한다. 그리고 그 이후 요청이 오면 그때 내부에서 진짜 내 MyLogger를 스프링 컨테이너에서
        // 찾아서 빈을 위임해 준다.
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(2000);
        logDemoService.logic("testId");
        return "OK";
    }
}
