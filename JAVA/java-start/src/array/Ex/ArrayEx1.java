package array.Ex;

public class ArrayEx1 {

    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50, 40};
        int total = 0;

//        for (int i = 0; i < students.length; i++) {
//            total += students[i];
//        }
        for (int student : students) { // i값 즉, index 값을 출력할 필요가 없기에 향상된 for문을 사용해도 가능하다.
            total += student;
        }
        double average = (double) total / students.length;

        System.out.println("점수 총합 : " + total);
        System.out.println("점수 평균 : " + average);
    }
}