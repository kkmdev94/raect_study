package array;

public class Array1Ref2 {

    public static void main(String[] args) {
        int[] students; // 배열 변수 선언
        students = new int[5]; //연결된 그릇이 5개가 있다 / int가 5개가 있다 라는 뜻

        // 변수 값 대입
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        for (int i = 0; i < students.length; i++) {
            System.out.println("학생" + (i+1) + "점수 : " + students[i]);
        }

//        System.out.println("학생1 점수 : " + students[0]);
//        System.out.println("학생2 점수 : " + students[1]);
//        System.out.println("학생3 점수 : " + students[2]);
//        System.out.println("학생4 점수 : " + students[3]);
//        System.out.println("학생5 점수 : " + students[4]);
    }
}
