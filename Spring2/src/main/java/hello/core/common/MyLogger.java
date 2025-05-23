package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
//@Scope(value = "request") // ObjectProvider가 없으면 오류 발생, 즉 request로 받는 값이 없어서 오류가 발생하는것이라 Controller와 Service에 ObjectProvider를 썼었다.
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // Scope와 proxy
// TARGET_CLASS를 추가 할때 -> 적용대상이 인터페이스가 아닌 클래스 즉 아래의 MyLogger처럼 클래스면 타겟 클래스를
// 적용대상이 클래스가 아닌 인터페이스면 INTERFACES를 선택한다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }
}
