package lang.string.bulider;

public class StringBuilderMain1_1 {

    public static void main(String[] args) {
        StringBuilder sb =new StringBuilder();
        sb.append("A"); // append = 더하다 라는 뜻
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb = " + sb);

        sb.insert(4, "Java"); // insert = 추가하다 / 원하는 위치, 뒤에 더해줄 문자를 작성한다.
        System.out.println("insert = " + sb);

        sb.delete(4, 8); // delete = 지우다 / 원하는 위치부터 원하는 위치까지
        System.out.println("delete = " + sb);

        sb.reverse(); // reverse = 뒤집다
        System.out.println("reverse = " + sb );

        // StringBuilder -> String
        String string = sb.toString(); // 가변 객체인 StringBuilder를 불변 객체인 String으로 전환.
        System.out.println("string = " + string);
    }
}
