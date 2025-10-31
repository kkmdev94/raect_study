package hellojpa;

import jakarta.persistence.*;

/**
 * JPA의 기본 전략 자체가 싱글 테이블이다(한 테이블에 다 집어넣음 / Item의 테이블에 album, movie, book 등 을 다 넣음)
 * 그래서 다른 방식으로 사용하면
 *  - JOINED : 조인전략
 *  - TABLE_PER_CLASS : 구현 클래스마다 테이블 전략
 *  - DiscriminatorColumn -> DTYPE 이라 불리는 것은 어노테이션으로 추가하며 테이블에서는 컬럼하나로 들어간다. 이것은 해당 연결된 엔티티의 이름이 들어가며, 이름 변경도 가능하다.
 *  - public abstract class Item { // TABLE_PER_CLASS에서는 추상으로 만들어서 하게 되면 Item 테이블이 생성이 안된다.
 */

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // 정석이라고 보면 된다.
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 조회성능이 빠르고 쿼리가 단순 / 자식 엔티티가 매핑한 컬럼은 모두 null을 허용해야함, 단일 테이블에 모든것을 때려박아서 오히려 성능이 느려질 수 있음.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 쓰면 안된다고 보면 된다. 장단점을 생각할께 아니라 그냥 사용을 안한다고 보면 된다.
//@DiscriminatorColumn // -> 단일테이블 즉, 싱글테이블에서는 DTYPE을 명시 해주지 않아도 자동으로 들어간다.
//public class Item {
public abstract class Item { // TABLE_PER_CLASS에서는 추상으로 만들어서 하게 되면 Item 테이블이 생성이 안된다.

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
