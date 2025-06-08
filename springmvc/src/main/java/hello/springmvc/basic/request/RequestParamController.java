package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    /**
     * 컨트롤러면서 스트링이면 뷰 리저버를 통해 OK라는 뷰를 찾게 되고 OK라는 문자를 http 메세지에 넣어준다.
     * 이떄 클래스 상단에 RestController를 넣어도 되지만 뷰 리저버를 통해 반환하는 메서드에 상단에 @ResponseBody를 적어주면
     * return으로 반환되는 값을 HTTP 응답 메세지에 넣어서 반환해준다. 즉, RestController와 같은 효과이다.
     */
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) { // 요청 파라미터와 이름이 같으면 생략하고 v4처럼 만들 수 있다.

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            // 기본값은 true / required는 해당 파라미터가 꼭 들어와야 된다 라는 의미. 즉 기본은 원래 있어야 한다가 맞지만 false로 하면 빠져도 된다.
            // 해당 값을 돌렸을때 int형은 null이 들어갈 수 없어 500에러를 보냈지만 Integer(객체라 null이 가능)로 변환해서 하니 null이 들어가서 가능했다.
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            // default는 해당 파라미터에 넘어오는 값이 없다면 내가 지정한 값으로 넘겨주겟다는 뜻.
            // default가 들어가는 순간 required는 의미가 없어진다. true는 기본값이고, false로 해도 default로 지정한 값이 넘어가기 때문에
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age) {

        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    // 파라미터의 값이 1개가 확실하면 map을 사용해도 되지만 그렇지 않다면 MulitValueMap을 사용해 여러개를 받아와야 한다.
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    // 기존의 방식
//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
//        log.info("helloData={}", helloData);
//
//        return "ok";
//    }

    /**
     * 프로퍼티란?
     * 예시를 들자면, 객체에 'getUsername(), 'setUsername' 메서드가 있으면 이 객체는 'username'이라는 프로퍼티를 가지고 있다.
     * 'username'이라는 프로퍼티의 값을 변경하면 set이 호출되고, 조회를 하면 get이 호출되는것이다.
     *
     * 즉, getXxx, setXxx이 호출되면 앞의 get,set은 떼고 대문자를 소문자로 Xxx -> xxx로 만들어서 프로퍼티를 찾는 것이다.
     * 그리고 이렇게 대문자 -> 소문자로 변경하는 것을 수정자 프로퍼티라고 한다.
     */
    // 위의 방식을 ModelAttribute를 통해 간략화가 가능하다.
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) { //@ModelAttribute도 생략이 가능

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok";
    }
}
