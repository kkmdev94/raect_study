package loop;

public class Nested1 {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            for (int j = 0; j < 3; j++) {
                System.out.println(i+""+j);
            }
            System.out.println("end");
        }
    }
}
