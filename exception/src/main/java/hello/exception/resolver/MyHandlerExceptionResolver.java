package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

/**
 * ExceptionResolver가 ModelAndView를 반환하는 이유는 마치 try,catch를 하듯, Exception을 처리해서
 * 정상 흐름처럼 변경하는 것이 목적이다. 이름 그대로 Exception을 Resolver(해결)하는 것이 목적이다.
 * 예시로 든 IllegalArgumentException이 발생하면 원래의 흐름대로라면 500 에러가 나오지만
 * response.sendError(400)을 통해 HTTP 상태 코드를 400으로 지정하고 빈 ModelAndView를 반환하여 정상 흐름처럼 만드는 것이다.
 */

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                return new ModelAndView(); // 새로운 modelAndView를 반환해주므로써 리턴이 정상적으로 반환되면 예외를 삼켜버리는 것이다.
            }
        } catch (IOException e) {
            log.error("resolver ex", e);
            e.printStackTrace();
        }
        return null;
    }
}
