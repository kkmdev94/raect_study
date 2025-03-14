package collection.map.test.cart;

import java.util.*;


public class Cart {

    private Map<Product, Integer> cartMap = new HashMap<>(); // product는 상품명과 가격 Integer는 그 상품의 수량을 표기

    public void add(Product name, int value) {
        // 그냥 너으면 안되고 상품이 없을때만 집어 넣어야 한다.
        Integer existingValue = cartMap.getOrDefault(name, 0);
        // 그리고 상품을 추가하면 기존값이랑 다르게 대체되어야 한다.
        cartMap.put(name, existingValue + value);
    }


    public void minus(Product name, int value) {
        Integer minusValue = cartMap.get(name);
        int newValue = minusValue - value;
        if (newValue <= 0) {
            cartMap.remove(name);
        } else {
            cartMap.put(name, newValue);
        }
    }
    public void printAll() {
        System.out.println("== 모든 상품 출력 ==");
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            System.out.println("상품 : " + entry.getKey() + " 수량 : " + entry.getValue());
        }
    }

}
