package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}
    //여기서 학습하는 내용은 알고 가면 좋은것이고 결론은 엔티티를 노출시키지 않는 것이다. / DTO 사용하기!!
    @Bean
    Hibernate5JakartaModule hibernate5Module() {
        Hibernate5JakartaModule module = new Hibernate5JakartaModule();
//        module.configure(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING, true);// 이렇게 하면 쓸대없는 쿼리가 정말 많이 나가서 성능상 문제가 생긴다.
        return module;
    }

}
