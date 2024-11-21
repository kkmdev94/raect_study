package loop.ex;

public class NestedEx2 {

    public static void main(String[] args) {
        int row = 5;

        for (int i = 1; i <= row; i++) {
            System.out.println();
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
        }
    }
}
