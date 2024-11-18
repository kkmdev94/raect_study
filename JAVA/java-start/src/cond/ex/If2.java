package cond.ex;

public class If2 {

    public static void main(String[] args) {
        int load = 20;

        if(load <= 1) {
            System.out.println("work");
        } else if (load <= 10) {
            System.out.println("bike");
        } else if (load <= 100) {
            System.out.println("car");
        } else if (load < 100) {
            System.out.println("airplan");
        }
    }
}
