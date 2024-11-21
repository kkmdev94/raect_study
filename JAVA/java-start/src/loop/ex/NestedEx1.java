package loop.ex;

public class NestedEx1 {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(i + "단시작");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " x " + j + "= " + i*j);
            }
            System.out.println();
            System.out.println(i + " 단 종료");
            System.out.println();
        }
    }
}
