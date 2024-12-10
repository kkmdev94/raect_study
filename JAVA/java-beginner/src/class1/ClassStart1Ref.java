package class1;

import java.util.Scanner;

public class ClassStart1Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("학생 수를 입력해 주세요 : ");
        int student = sc.nextInt();

        String[] studentName = new String[student];
        int[] studentAge = new int[student];
        int[] studentStudy = new int[student];

        while (true) {

            for (int i = 0; i < student; i++) {
                sc.nextLine();
                System.out.print("학생의 이름을 입력해 주세요 : ");
                studentName[i] = sc.nextLine();
                System.out.print("학생의 나이를 입력해 주세요 : ");
                studentAge[i] = sc.nextInt();
                System.out.print("학생의 점수를 입력해 주세요 : ");
                studentStudy[i] = sc.nextInt();
            }

            for (int i = 0; i < student; i++) {
                    System.out.println("이름 : " +studentName[i] + " 나이 : " + studentAge[i] + "성적 : " + studentStudy[i]);
            }
            return;
        }
    }
}
