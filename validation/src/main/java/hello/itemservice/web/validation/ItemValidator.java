package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
        // isAssignableFrom -> == 보다 훨씬 낫다. / 해당 메서드는 넘어오는 클래스가 아이템에 있는 것과 같냐 라는 것과 자식 클래스도 검증이 가능해서 == 보다 훨씬 상위레벨이다.
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;


        //검증 로직(BindingResult를 통한 오류 검증) / errors에는 rejectValue가 있다.
        if (!StringUtils.hasText(item.getItemName())) {
            errors.rejectValue("itemName", "required");
        }
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            errors.rejectValue("price", "range", new Object[]{1000,1000000},null);
        }
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            errors.rejectValue("quantity", "max", new Object[]{9999},null);
        }

        // 특정 필드가 아닌 복합 룰 검증
        if (item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000) {
                errors.reject("totalPriceMin",new Object[]{10000, resultPrice}, null);
            }
        }
    }
}
