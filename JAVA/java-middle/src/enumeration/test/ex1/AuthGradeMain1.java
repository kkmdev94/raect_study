package enumeration.test.ex1;

public class AuthGradeMain1 {

    public static void main(String[] args) {
        AuthGrade[] values = AuthGrade.values();
        for (AuthGrade value : values) {
            printGrade(value);
        }
    }

    private static void printGrade(AuthGrade grade) {
        System.out.println("현재 레벨은 : " + grade.getLavel() + " 현재 등급은 : " + grade.getDescription() + " 입니다.");
    }
}
