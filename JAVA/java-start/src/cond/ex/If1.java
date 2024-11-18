package cond.ex;

public class If1 {

    public static void main(String[] args) {
        int student = 87;

        if (student >= 90) {
            System.out.println("A");
        } else if (student >= 80) {
            System.out.println("B");
        } else if (student >= 70) {
            System.out.println("C");
        } else if (student >= 60) {
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }
}
