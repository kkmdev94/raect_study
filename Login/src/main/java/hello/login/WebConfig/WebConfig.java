package hello.login.WebConfig;

import hello.login.web.filter.LogFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean // springBoot로 필터 등록할때 사용. WAS를 본인이 들고 띄우기에 같이 넣어준다.
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter()); // 우리가 만든 로그필터를 주입
        filterRegistrationBean.setOrder(1); // 필터의 순서를 정해준다. 숫자가 낮을수록 먼저 실행된다.
        filterRegistrationBean.addUrlPatterns("/*"); //어떤 URL 패턴에 할꺼냐를 정하는것인데 /*로 하면 모든 URL에 적용된다.

        return filterRegistrationBean;
    }
}
