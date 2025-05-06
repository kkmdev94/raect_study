package hello.hello_spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DI를 통해서 JPA와 매핑 id 같은경우 자동생성 + 자동증가 이니 Generatede를 통해 IDENTITY 설정
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public Member setId(Long id) {
        this.id = id;
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
