package oop1.ex;

public class RectangleOopMain {

    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.width = 8;
        rec.height = 8;

        int area = rec.calculateArea();
        System.out.println("넓이" + area);

        int perimeter = rec.calculatePerimeter();
        System.out.println("둘레 길이" + perimeter);

        boolean square = rec.isSquare();
        System.out.println("정사각형 여부 : " + square);
    }
}
