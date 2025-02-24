package generic.ex4;

public class GenericMethod {
    // class에 적용되는 제네릭타입과 메서드 하나에만 적용되는 제네릭 메서드는 완전히 다른거다.

    public static Object objMethod(Object obj) {
        System.out.println("Object print: " + obj);
        return obj;
    }

    public static <T> T genericMethod(T t) {
        System.out.println("Generic print: " + t);
        return t;
    }

    public static <T extends Number> T numberMethod(T t) {
        System.out.println("Number print: " + t);
        return t;
    }
}
