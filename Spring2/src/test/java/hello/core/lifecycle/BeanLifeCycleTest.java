package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
//        NetworkClient client = ac.getBean(NetworkClient.class);
//        NetworkClient2 client = ac.getBean(NetworkClient2.class);
        NetworkClient3 client = ac.getBean(NetworkClient3.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

//        @Bean // 구버전 사용 호출
//        public NetworkClient networkClient() {
//            NetworkClient networkClient = new NetworkClient();
//            networkClient.setUrl("http://hello-spring.dev");
//            return networkClient;
//        }

//        아래의 networkClient3 방법을 스프링에서도 권장하긴 하나 해당 방법의 유일한 단점인 외부 라이브러리에 적용을 못하므로 외부 라이브러리를 초기화 하거나 종료 해야 하면 networkClient2 번의
//        @Bean 방법을 사용한다.

//        @Bean(initMethod = "init", destroyMethod = "close")
//        public NetworkClient2 networkClient() {
//            NetworkClient2 networkClient = new NetworkClient2();
//            networkClient.setUrl("http://hello-spring.dev");
//            return networkClient;
//        }

        @Bean
        public NetworkClient3 networkClient() {
            NetworkClient3 networkClient = new NetworkClient3();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
