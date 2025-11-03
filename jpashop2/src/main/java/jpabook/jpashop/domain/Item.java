package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
//@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@Inheritance(strategy =  InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Item { // 아이템만 단독으로 테이블에 저장할 일이 있냐 없냐로 판단 후 없다는 가정하에 추상클래스로 만듬.

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories;

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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
