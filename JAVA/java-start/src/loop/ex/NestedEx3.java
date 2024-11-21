package loop.ex;

public class NestedEx3 {

    public static void main(String[] args) {
        int row = 10;

        for (int i = 1; i <= row; i+=2) {
            for (int e = 10; e >= (row-i)/2; e--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (row-i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
