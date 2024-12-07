package array;

public class Array1Ref4 {

    public static void main(String[] args) {
        int[] students = {90, 80,70, 60, 50}; //배열의 생성과 초기화
        /*
       int[] students;
       students = {90, 80,70, 60, 50}; <- 이거는 배열인지 아닌지 자바가 모르기에 실행할 수 없는 코드가 된다. 즉, 선언과 초기화를 동시에 해야한다.
         */

        for (int i = 0; i < students.length; i++) {
            System.out.println("학생" + (i+1) + "점수 : " + students[i]);
        }

    }
}
