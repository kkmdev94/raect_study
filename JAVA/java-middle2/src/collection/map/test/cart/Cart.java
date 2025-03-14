package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;


public class Cart {

    private Map<Product, Integer> cartMap = new HashMap<>(); // product는 상품명과 가격 Integer는 그 상품의 수량을 표기

    public void add(Product name, int value) {
        cartMap.put(name, value);
    }

    public void printAll() {
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            System.out.println("상품 : " + entry.getKey() + " 수량 : " + entry.getValue());
        }
    }
}
