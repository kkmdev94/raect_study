package loop.ex;

import java.util.Scanner;

public class ScannerWhileEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("이름을 입력하세요 (종료를 입력하면 종료) : ");
            String name = sc.nextLine();

            if (name.equals("종료")) { //String 클래스에서 equlas 메소드를 통해 문자열을 비교, 즉 String 클래스를 통해 문자열을 비교하려면 equlas 메소드를 통해 비교
                System.out.println("종료를 입력하여 프로그램을 종료합니다.");
                break;
            }

            System.out.print("나이를 입력하세요 : ");
            int age = sc.nextInt();
            sc.nextLine(); //nextInt에서 입력한 enter \n을 while문을 통해 다시 위로 돌아갔을때 nextLine에서 \n을 인식해버려서 공백으로 인식 그래서 처리를 위해 한번 처리해준다.

            System.out.println("입력한 이름 : " + name + " 나이 : " + age);
        }
    }
}
