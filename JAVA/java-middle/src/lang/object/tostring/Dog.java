package lang.object.tostring;

public class Dog {

    private String dogName;
    private int age;

    public Dog(String dogName, int age) {
        this.dogName = dogName;
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "dogName = " + dogName + "/" + "age=" + age;
//    }


    @Override
    public String toString() { // 생성자 생성하는 alt+insert를 통해 toString 오버라이딩이 가능.
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                '}';
    }
    // 내가 원하는 모양으로 출력하고 싶으면 직접 출력 / 그게 아니면 인텔리제이의 도움을 받아 생성하면 편하다.
}
