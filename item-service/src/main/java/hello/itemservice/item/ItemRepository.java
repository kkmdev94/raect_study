package hello.itemservice.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    /**
     * 스프링 컨테이너 안에서 쓰면 어차피 싱글톤이라 스태틱 안써도 되지만 따로 뉴를 통해 HashMap 같은걸 사용해서 인스턴스를 만들게 되면 스태틱 안했을 때,
     * 따로 스토어같은 객체가 계속 생성된다.
     * 또한 실무에서는 HashMap을 사용하면 싱글톤으로 생성되서 멀티스레드 환경에서 심각한 오류가 발생하기에 실무에서는 사용하면 안된다.
     * static으로 만들어진 HashMap은 싱글톤이기에 여러스레드가 동시에 들어오면 오류가 발생하기에 실무에서는 Concurrent HashMap을 사용해야 한다.
     */
    private static final Map<Long, Item> store = new HashMap<>(); // static 사용했다는거 주의
    private static long sequence = 0L; // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); // 컬렉션으로 한번 감싸서 반환하면 ArrayList에 값을 넣어도 실제 스토에는 변함이 없기 때문에 감싼거다.(안전해짐)
    }

    public void update(Long itemid, Item updateParam) {
        Item findItem = findById(itemid);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
