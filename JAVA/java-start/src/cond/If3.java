package cond;

public class If3 {

    public static void main(String[] args) {
        int age = 14;

        if (age <= 7) {
            System.out.println("child");
        } else if(age  >= 8 && age <= 13) {
            System.out.println("elementary school student");
        } else if(age  >= 14 && age <= 16) {
            System.out.println("middle school student");
        } else if(age  >= 17 && age <= 19) {
            System.out.println("high school student");
        }else{
            System.out.println("man & woman");
        }
    }
}
