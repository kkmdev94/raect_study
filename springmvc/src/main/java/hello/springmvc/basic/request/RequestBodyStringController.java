package hello.springmvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);

        responseWriter.write("ok");
    }

    /**
     * HttpEntity : HTTP header, body 정보를 편리하게 조회 (자세한건 뒤에서 후술)
     *  - 메시지 바디 정보를 직접 조회
     *  - 요청 파라미터를 조회하는 기능과 관계 없음 : '@RequestParam' X , '@ModelAttribute' X
     * HttpEntity는 응답에도 사용 가능
     *  - 메시지 바디 정보 직접 반환
     *  - 헤더 정보 포함 가능
     *  - view 조회 X
     *
     *  요청 파라미터와 많이 헷갈려 하는게 요청 파라미터란
     *   - 겟이 쿼리 스트링이 오는거, 쿼리 파라미터가 오는것 그것 또는 html form 방식으로 데이터 전송하는 방식(컨텐츠 타입 애플리케이션/x-www...)
     *   이거인 경우에만 RequestParam, ModelAttribute를 사용.
     */
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {

        String messageBody = httpEntity.getBody();

        log.info("messageBody={}", messageBody);

        return new HttpEntity<>("ok");
    }

    @PostMapping("/request-body-string-v3-1") // 이렇게도 가능하지만 결국 HttpEntity를 상속받은 것이다.
    public HttpEntity<String> requestBodyStringV3C(RequestEntity<String> httpEntity) throws IOException {

        String messageBody = httpEntity.getBody();

        log.info("messageBody={}", messageBody);

        return new ResponseEntity<String>("ok",HttpStatus.CREATED);
    }

    // 실무에서도 제일 많이 사용. 이렇게 메시지 바디를 직접 조회하는 기능은 요청 파라미터를 조회하는 @RequestParam, @ModelAttribute와는 전혀 관계없다.
    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {

        log.info("messageBody={}", messageBody);

        return "ok";
    }
}
