package hello.core.order;

public class Order {

    private Long memberId;
    private String tiemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String tiemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.tiemName = tiemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getTiemName() {
        return tiemName;
    }

    public void setTiemName(String tiemName) {
        this.tiemName = tiemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", tiemName='" + tiemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
