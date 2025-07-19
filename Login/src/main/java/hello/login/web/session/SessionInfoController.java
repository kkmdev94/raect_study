package hello.login.web.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "세션이 없습니다.";
        }

        // 세션 데이터 출력
        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name={}, value={}", name, session.getAttribute(name)));

        log.info("sessionId={}", session.getId());
        log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval()); // 비활성화 되는 최대 시간. (인터벌이라 초로 구분한다.) 즉 1800초라는 뜻.
        log.info("getCreationTime={}", new Date(session.getCreationTime())); // 생성일자 / 기본값이 long이라 new Date로 넣어준다.
        log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime())); // 마지막에 접근한 시간. 똑같이 Date로 감싸준다.
        log.info("isNew={}", session.isNew()); // 새로 생성된것인지 확인

        return "세션 출력";
    }
}
