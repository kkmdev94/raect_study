package hello.exception.api;

import hello.exception.exHandler.ErrorResult;
import hello.exception.exception.UserException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApiExceptionV2Controller {

    /**
     * 그림에서 본것처럼 컨트롤러에서 터진 에러가 Dispatcher Servlet을 통해 예외 해결 시도를 하기위해 Exception Resolver를 호출하고
     * 첫번째로 물어보는게 ExceptionHandlerResolver를 호출을 하고, 호출된 ExceptionHandlerResolver는 ExceptionHandler라는 애노테이션을 찾아서
     * 있으면 가장 먼저 호출을 해준다. 그리고 해당 흐름을 정상으로 만들고 예외를 던져주기 때문에 Status가 200으로 나오기에
     * ResponseStatus를 통해 Status를 변경해준다.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @GetMapping("/api2/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }
        if (id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력 값");
        }
        if (id.equals("user-ex")) {
            throw new UserException("사용자 오류");
        }

        return new MemberDto(id, "hello " + id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String memberId;
        private String name;
    }
}
