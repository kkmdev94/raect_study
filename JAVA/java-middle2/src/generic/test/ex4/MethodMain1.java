package generic.test.ex4;

public class MethodMain1 {

    public static void main(String[] args) {
        Integer i =10;
        Object object = GenericMethod.objMethod(i);

        // 타입 인자(Type Argument) 명시적 전달.
        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);

        // 상한 지정 NumberMethod
        Integer integerValue = GenericMethod.<Integer>numberMethod(30);

        Double dole = GenericMethod.<Double>numberMethod(102.2);

        // 타입 추론
        System.out.println("타입 추론");
        Integer value = GenericMethod.genericMethod(i);
        Integer value1 = GenericMethod.numberMethod(10);
        Double Value2 = GenericMethod.numberMethod(20.0);
    }
}
