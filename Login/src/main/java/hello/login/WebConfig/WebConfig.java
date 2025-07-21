package hello.login.WebConfig;

import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import hello.login.web.interceptor.LogInterceptor;
import hello.login.web.interceptor.LoginCheckinterceptor;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer { // 스프링 인터셉터를 사용할때 상속받는다.


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")  // 여기 하위는 전부다 라는 뜻
                .excludePathPatterns("/css/**", "/*.ico", "/error"); // 모든것을 허용하지만 얘네는 뺀다,.

        registry.addInterceptor(new LoginCheckinterceptor()) // 인터셉터는 정말 세밀하게 설정이 가능하다.
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/memebers/add", "/login", "/logout", "/css/**", "/*.ico", "/error");

    }

//    @Bean // springBoot로 필터 등록할때 사용. WAS를 본인이 들고 띄우기에 같이 넣어준다.
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter()); // 우리가 만든 로그필터를 주입
        filterRegistrationBean.setOrder(1); // 필터의 순서를 정해준다. 숫자가 낮을수록 먼저 실행된다.
        filterRegistrationBean.addUrlPatterns("/*"); //어떤 URL 패턴에 할꺼냐를 정하는것인데 /*로 하면 모든 URL에 적용된다.

        return filterRegistrationBean;
    }

//    @Bean // springBoot로 필터 등록할때 사용. WAS를 본인이 들고 띄우기에 같이 넣어준다.
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }


}
