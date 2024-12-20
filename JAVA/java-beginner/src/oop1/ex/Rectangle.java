package oop1.ex;

public class Rectangle {
    int width;
    int height;

    int calculateArea() {
        return width * height;
    }

    int calculatePerimeter() {
        return 2 * (width + height);
    }

    boolean isSquare() {
        return width == height;
    }
}
/* 매개 변수가 필요 없는 이유는 자기꺼를 사용하면 되기 때문이다.
선언한 int width와 height를 return값에서 사용하면 되기에 매개 변수가 필요가 없다.
객체한테 물어보고 답을 구하는 것이다 = 객체 지향
 */