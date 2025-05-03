package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template.html"; // 해당 템플릿을 view로 하고 모델을 이용해서 렌더링해서전달.
    }

    @GetMapping("hello-string")
    @ResponseBody // -> HTML의 body가 아니라 HTTP에서 header 부와 body부가 있는데 여기서 body 부에 데이터를 내가 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello!! " + name; // 따라서 html을 거치지 않고 return 값에서 바로 수정한 값이 출력된다.(예제 예시)
    }

    @GetMapping("hello-api")
    @ResponseBody // json으로 반환하는게 기본이다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello { // Hello 클래스 안에서 static클래스로 만들면 해당 클래스 안에서 해당 클래스를 또 사용할 수 있다.
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
