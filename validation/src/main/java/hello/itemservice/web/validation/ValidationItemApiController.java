package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    @PostMapping("/add")
    public Object additem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {

        log.info("API 컨트롤러 호출");

        // 컨트롤러 호출이 안됨. 그 이유는 JSON이 객체로 바뀌어야 그다음인 벨리데이션을 가는데 오브젝트 즉, 객체화를 만드는데 실패해서 컨트롤러 호출도 못하고 예외가 터짐.
        // 여기서 POSTMAN 테스트로 가격에 문자열을 넣었을때 객체를 만드는데 실패했다, 대신 처음 데이터 생성 시 수량 제한인 9999를 넘겼을때는 객체화는 성공하고
        // 벨리데이션 오류를 뱉었다.
        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 errors={}", bindingResult);
            return bindingResult.getAllErrors();
        }

        log.info("성공 로직 실행");
        return form;
    }
}
