package lang.string.bulider;

public class StringBuilderMain1_2 {

    public static void main(String[] args) {
        StringBuilder sb =new StringBuilder();
        String string = sb.append("A").append("B").append("C").append("D")
                .insert(4, "Java")
                .delete(4,8)
                .reverse()
                .toString();

        System.out.println("string = " + string);

        // method Chaining 기법을 이용. 자기 자신을 반환하는 객체만 사용이 가능하다.
    }
}
