package hello.login.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        // 필터와 다르게 afterCompletion으로 넘길 수 있다 request의 set을 통해 logId로 uuid를 받고 아래에서 request의 get을 통해 logId를 호출하면 되기 때문.
        // 또한 uuid는 싱글톤이기에 전역 변수로 선언하면 트랜젝션에 의해 바꿔치기 당할 수 있어 전역변수로 선언하면 안된다.
        request.setAttribute(LOG_ID, uuid);

        // @RequestMapping: HandlerMethod / mvc1편이 어려웠으니 우리가 일반적으로 사용하는 요 컨트롤러는 캐스팅 인스턴스로 이타입이 맞는지 확인하고 이렇게 사용하면된다.
        // 정적 리소스 : ResourceHttpRequestHandler
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler; // 호출할 컨트롤러 메서드의 모든 정보가 포함되어 있다.

        }

        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);

//        return false; // false로 하면 여기서 컨트롤러 호출 안하고 끝난다.
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandel [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        Object logId = (String) request.getAttribute(LOG_ID);

        log.info("RESPONSE [{}][{}][{}]", logId, requestURI, handler);

        if (ex != null) {
            log.error("afterCompletion error!!", ex);
        }
    }
}
