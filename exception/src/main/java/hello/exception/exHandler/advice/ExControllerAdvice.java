package hello.exception.exHandler.advice;

import hello.exception.exHandler.ErrorResult;
import hello.exception.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ExceptionHandler 애노테이션을 선언하고, 해당 컨트롤러에서 처리하고 싶은 예외를 지정해주면 된다. 해당 컨트롤러에서
 * 예외가 발생하면 이 메서드가 호출된다. 참고로 지정한 예외 또는 그 예외의 자식 클래스는 모두 잡을 수 있다.
 *
 * 스프링의 우선순위는 항상 자세한 것이 우선권을 가진다. 예를 들어서 부모, 자식 클래스가 있고 다음과 같이 예외가 처리된다.
 *
 * @ExceptionHandler(부모예외.class)
 * public String 부모예외처리()(부모예외 e) {}
 *
 * @ExceptionHandler(자식예외.class)
 * public String 자식예외처리()(자식예외 e) {}
 *
 * @ExceptionHandler 에 지정한 부모 클래스는 자식 클래스까지 처리할 수 있다. 따라서 자식예외 가 발생하면 부모 예외처리() , 자식예외처리() 둘다 호출 대상이 된다.
 * 그런데 둘 중 더 자세한 것이 우선권을 가지므로 자식예외처리()가 호출된다. 물론 부모예외 가 호출되면 부모예외처리() 만 호출 대상이 되므로 부모예외처리() 가 호출된다.
 *
 * 다양한 예외
 * 다음과 같이 다양한 예외를 한번에 처리할 수 있다.
 *
 * @ExceptionHandler({AException.class, BException.class})
 * public String ex(Exception e) {
 *  log.info("exception e", e);
 * }
 *
 * 예외 생략
 * @ExceptionHandler 에 예외를 생략할 수 있다. 생략하면 메서드 파라미터의 예외가 지정된다.
 *
 * @ExceptionHandler
 * public ResponseEntity<ErrorResult> userExHandle(UserException e) {}
 *
 * 파리미터와 응답
 * @ExceptionHandler 에는 마치 스프링의 컨트롤러의 파라미터 응답처럼 다양한 파라미터와 응답을 지정할 수 있다.
 * 자세한 파라미터와 응답은 다음 공식 메뉴얼을 참고하자.
 * https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-annexceptionhandler-args
 *
 * @ControllerAdvice
 *  @ControllerAdvice 는 대상으로 지정한 여러 컨트롤러에 @ExceptionHandler , @InitBinder 기능을 부여해주는 역할을 한다.
 *  @ControllerAdvice 에 대상을 지정하지 않으면 모든 컨트롤러에 적용된다. (글로벌 적용)
 *  @RestControllerAdvice 는 @ControllerAdvice 와 같고, @ResponseBody 가 추가되어 있다. @Controller , @RestController 의 차이와 같다.
 *
 *  대상 컨트롤러 지정 방법
 * // Target all Controllers annotated with @RestController
 * @ControllerAdvice(annotations = RestController.class)
 * public class ExampleAdvice1 {}
 *
 * // Target all Controllers within specific packages
 * @ControllerAdvice("org.example.controllers")
 * public class ExampleAdvice2 {}
 *
 * // Target all Controllers assignable to specific classes
 * @ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
 * public class ExampleAdvice3 {}
 *
 * https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-anncontroller-advice (스프링 공식 문서 참고)
 */

@Slf4j
//@RestControllerAdvice
//@RestControllerAdvice(annotations = RestController.class) // RestController가 적용된 컨트롤러만 적용.
@RestControllerAdvice(basePackages = "hello.exception.api")
public class ExControllerAdvice {

    /**
     * 그림에서 본것처럼 터진 에러가 Dispatcher Servlet을 통해 예외 해결 시도를 하기위해 Exception Resolver를 호출하고,
     * 첫번째로 물어보는게 ExceptionHandlerResolver를 호출을 하고, 호출된 ExceptionHandlerResolver는 ExceptionHandler라는 애노테이션을 찾아서
     * 있으면 가장 먼저 호출을 해준다. 그리고 해당 흐름을 정상으로 만들기 위해 에러를 먹어버리고 정상흐름을 던져주기 때문에 Status가 200으로 나온다. 그래서,
     * ResponseStatus를 통해 Status를 변경해준다.
     *
     * 또한 이 컨트롤러에서는 RestController라서 Json으로 반환해서 값을 보내준다.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(UserException e) { // @ExceptionHandler와 반환값의 에러가 같다면 위 애노테이션처럼 생략하고 파라미터에 넣어도 된다.
        log.error("[exceptionHandler] ex", e);
        ErrorResult errorResult = new ErrorResult("USER_EX", e.getMessage());
        return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST);
    }

    /**
     * 최상위 Exception으로  공통으로 처리하거나 놓친 부분 즉, 위에서 처리되는 UserException이나 IllegalArgumentException은 해당 에러의 자식까지는 잡을 수 있지만
     * 그 외 다른 오류는 잡을 수 없기에, 혹시 놓쳤거나 아니면 공통으로 처리하거나, 혹은 RuntimeException같이 부모가 바로 Exception인 경우 처리를 하기위해
     * Exception 오류 하나는 만들어 놓는다.
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }

}
