package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // Lombok을 이용해 @를 사용해 게터,세터, 생성자, toString 등등 지원을 해준다.
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfasdf"); // 이렇게 set을 바로 진행 할 수 있다. get도 가능.

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
