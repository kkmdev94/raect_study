package lang.string.ex;

public class TestString9 {

    public static void main(String[] args) {
        String email = "hello@example.com";
        String[] result = email.split("@");

        for (int i = 0; i < result.length; i++) {
            if (0 == i) {
                System.out.println("Id : " + result[i]);
            } else {
                System.out.println("Domain : " + result[i]);
            }
        }
//        선생님 답안지.
//        String idResult = result[0];
//        String domainResult = result[1];
//        System.out.println("ID : " + idResult);
//        System.out.println("Domain : " + domainResult);
    }
}
