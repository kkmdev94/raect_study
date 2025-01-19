package lang.wrapper.test;

public class WrapperTest4 {

    public static void main(String[] args) {
        String str = "100";

        Integer integer1 = Integer.valueOf(str); // 우선 이 스트링을 인티저로 바꾸는 거는 오토 박싱 이런 게 안된다.

        int intValue = integer1; // AutoUnboxing

        Integer integer2 = intValue; //AutoBoxing

        System.out.println("integer1 = " + integer1);
        System.out.println("intValue = " + intValue);
        System.out.println("integer2 = " + integer2);
    }
}
