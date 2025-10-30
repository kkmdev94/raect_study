package hellojpa;

import jakarta.persistence.*;

@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMEBER_ID")
    private Member3 member3;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
