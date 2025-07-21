package hello.login.web.filter;

import hello.login.web.SessionConst;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    // whitelist 작성 ( 해당 페이지들은 체크 없이 접속이 가능하다.)
    private static final String[] whitelist = {"/", "/members/add", "/login", "/logout", "/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            log.info("인증 체크 필터 시작{}", requestURI);

            if (isLoginCheckPath(requestURI)) {
                log.info("인증 체크 로직 실행 {}", requestURI);
                HttpSession session = httpRequest.getSession(false); // 세션을 뒤져본다.
                // 만약에 세션이 null이거나 로그인 멤버 값도 없다면. 미인증 사용자가 요청한것이므로 쫒아내야된다.
                if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {

                    log.info("미인증 사용자 요청 {}", requestURI);
                    //로그인으로 redirect
                    //sendRedirect를 통해 로그인이 안된 사람이 상품관리에 들어가려 하면 로그인 창으로 보낸다
                    httpResponse.sendRedirect("/login?redirectURL=" + requestURI);
                    return; // 여기가 중요, 미인증 사용자는 다음으로 진행하지 않고 끝!. 즉 되돌려 보낸다.
                }
            }

            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e; // 예외 로깅 가능하지만, 톰캣까지 예외를 보내줘야 한다.
        }finally {
            log.info("인증 체크 필터 종료 {}", requestURI);
        }
    }

    /**
     * 화이트 리스트의 경우 인증 체크 X
     */
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI); // 화이트리스트와 URI가 매칭이 되는지 확인. !를 통해 부정으로 만들고 화이트 리스트를 제외한 페이지는 인증체크를 해야함.
    }
}
