package hello.itemservice.web.basic;

import hello.itemservice.item.Item;
import hello.itemservice.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // lombok 어노테이션중 하나로 기본 생성자를 생략하게 해준다. 단 하나만 있을때만 가능.
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item /*, Model model*/) { // 이로 인해서 모델도 없어도 된다.

        itemRepository.save(item);
//        model.addAttribute("item", item); // @modelAttribute의 () 안에 있는 item을 통해 모델의 addAttribute 기능을 자동 추가 할 수 있다.
        // 그래서 item.html에서 th:onclick="|location.href='@{/basic/items/{itemId}/edit(itemId=${item.id})}'|" 이런식으로 item.id에서 그 item을 자동 추가할 수 있다.

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        // V2에서 @ModelAttribute의 ("item")도 지우게 된다면 파라미터의 클래스 명이 Item인데 해당 파라미터로 받는 클래스의 첫글자를 소문자로
        // 변경해서 모델 애트리뷰트에 담기게 된다. 즉, 지금은 클래스명이 Item이니 item으로 담기고, HelloData라면 helloData로 이렇게 바뀌어서 담기게 된다.
        // 파라미터로 넘어오는 클래스 명이 해당 호출값과 다르다면 오류가 발생하므로 같은 값만 집어 넣어야 한다.
        itemRepository.save(item);

        return "basic/item";
    }

    @PostMapping("/add")
    public String addItemV4(Item item) {

        itemRepository.save(item);

        return "basic/item";
    }

    /**
     * 테스트용 데이터 추가.
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }
}
