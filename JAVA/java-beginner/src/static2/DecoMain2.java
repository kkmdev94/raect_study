package static2;

public class DecoMain2 {

    public static void main(String[] args) {
        String s = "hello java";
        String deco = DecoUtil2.deco(s); // method에 static을 붙여서 정적 메소드로 만들고 클래스에 붙어 바로 사용하게 했다.

        System.out.println("before: " + s);
        System.out.println("after: " + deco);
    }
}
// static 변수와 동일 하다. 다만 메서드이냐 변수이냐의 차이다.
