package hello.springtx.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders") // DB 테이블 매핑 이때 테이블 이름은 orders라는 의미이다.
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String username; // 정상, 예외, 잔고부족
    private String payStatus; // 대기, 완료
}
