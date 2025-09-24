package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 * 상속관계 맵핑에서 상속관계 전략을 부모클래에서 잡아서 지정을 해야되는데 이떄 사용하는 어노테이션.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
