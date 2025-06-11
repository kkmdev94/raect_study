package hello.itemservice.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Data는 getter,setter,required,argument 등 다 생성해주기 때문에 너무 위험해서 주의해서 사용해야 한다. / 예측하기 힘든 오류가 발생 할 수 있다.
 * 필요한건 분리해서 쓰는게 좋고 일반적으로 흔히 DTO라고 불리는 데이터가 왔다갔다하는 컨트롤러에서는 데이터를 써도 되지만 여기서도 확인을 하고 쓰는 것이 좋다.
 */
//@Data
@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private int quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
