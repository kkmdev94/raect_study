package hellojpa;

import jakarta.persistence.*;

/**
 * JPA의 기본 전략 자체가 싱글 테이블이다(한 테이블에 다 집어넣음 / Item의 테이블에 album, movie, book 등 을 다 넣음)
 * 그래서 다른 방식으로 사용하면
 *  - JOINED : 조인전략
 *  - TABLE_PER_CLASS : 구현 클래스마다 테이블 전략
 *  - DiscriminatorColumn -> DTYPE 이라 불리는 것은 어노테이션으로 추가하며 테이블에서는 컬럼하나로 들어간다. 이것은 해당 연결된 엔티티의 이름이 들어가며, 이름 변경도 가능하다.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
