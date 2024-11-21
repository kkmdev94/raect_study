package loop.ex;

public class NestedEx2 {

    public static void main(String[] args) {
        int row = 10;

//        for (int i = 1; i <= row; i++) {
//            System.out.println();
//            for (int j = 1; j <= i; j++) {
//        }

        for (int i = 1; i <= row; i+=2) {
            for (int e = 1; e <= (row-i)/2; e++) { // row-i를 통해 row값에서 i를 빼고 /2를 통해 공백의 횟수를 구한다. 0이 되면 공백입력은 x
                System.out.print("e");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
