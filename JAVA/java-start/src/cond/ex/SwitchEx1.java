package cond.ex;

public class SwitchEx1 {

    public static void main(String[] args) {

        String grade = "B";

        String score = switch (grade) {
            case "A" -> "berry good";
            case "B" -> "good score";
            case "C" -> "nice score";
            case "D" -> "soso";
            case "F" -> "fail";
            default-> "grade not case";
        };
        System.out.println(score);
    }
}
