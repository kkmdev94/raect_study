package hello.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}
	/*
	localhost:8080에서 정적파일인 index로 가지 않고 home으로 먼저 찾아간 이유는 내장톰캣서버를 거쳐 스프링 컨테이너에 올라가 있는 컨트롤러를 먼져 찾는다.
	 */
}
