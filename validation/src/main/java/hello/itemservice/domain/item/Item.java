package hello.itemservice.domain.item;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;


@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000원 넘게 입력해 주세요.") // 사전작업이 복잡하고 기능이 부실하여 비추천.
public class Item {

//<<<<<<< HEAD // 기존 공부 버전
//    // 그룹스를 통해 해당 체크 사항에서만 작동되어 체크를 한다. 즉, id는 UpdateCheak만 있기에 수정에서만 체크하고, 등록에서는 안한다.
//
//    @NotNull(groups = UpdateCheck.class) // 수정 요구사항 추가
//    private Long id;
//
//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
//    private String itemName;
//
//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(min=1000,max=1000000)
//    private Integer price;
//
//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Max(value = 9999, groups = {SaveCheck.class}) // 수정 요구사항 추가
//=======

//    @NotNull(groups = UpdateCheck.class) // 수정 요구사항 추가
    private Long id;

//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Max(value = 9999, groups = {SaveCheck.class})
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
