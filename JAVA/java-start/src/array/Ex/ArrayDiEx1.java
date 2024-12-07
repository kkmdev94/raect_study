package array.Ex;

import java.util.Scanner;

public class ArrayDiEx1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] students = new int[4][3];
        String[] subjects = {"국어", "영어", "수학"};

        for (int row = 0; row < students.length; row++) {
            System.out.println((row+1) + "번 학생의 성적을 입력하세요 : ");
            for (int col = 0; col < students[row].length; col++) {
                System.out.print(subjects[col] + "점수 : ");
                students[row][col] = sc.nextInt();
            };
        }

        for (int i = 0; i < students.length; i++) {
            int total = 0;
            for (int j = 0; j < students[i].length; j++) {
                total += students[i][j];
            }
            double average = total / 3.0;
            System.out.println((i+1) + "번 학생의 총점: " + total + ", 평균 : " + average );
        }
    }
}
