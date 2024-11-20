package loop.ex;

public class ForEx2 {

    public static void main(String[] args) {
        int num = 2;

        for (int count = 1; count <= 10; count++) { // 아래방식도 가능하지만 해당 방식이 좀더 깔끔하고 명확하다.
            System.out.println(num);
            num+=2;
        }

//        for (int num = 2, count = 1; count <= 10; num += 2, count++) { //하나의 포문 안에서 여러개의 변수 선언과 증감식을 선언할 수 있다.
//            System.out.println(num);
//        }
    }
}
