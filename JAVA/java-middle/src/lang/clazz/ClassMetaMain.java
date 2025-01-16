package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaMain  {

    public static void main(String[] args) throws ClassNotFoundException{
        //Class 조회
        Class clazz = String.class; //1. 클래스에서 조회
        //Class clazz1 = new String().getClass(); // 2. 인스턴스에서 조회
        // new String은 인스턴스
        //Class clazz2 = Class.forName("java.lang.String"); //3. 문자열로 조회

        //모든 필드 출력
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
//            System.out.println("field = " + field);
//            System.out.println("field = " + field.getType() + " " + field.getName());
        }

        // 모든 메서드 출력
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
//            System.out.println("method = " + method);
//            System.out.println("method = " + method.getName() + " " + method.getParameterTypes());
        }

        // 상위 클래스 정보 출력
        System.out.println("Superclass: " + clazz.getSuperclass().getName());
        // String에 들어가 보면 extends가 없고 implements만 있다. 익스텐즈가 없으면 자동으로 Object가 온다.
        // Object는 모든 클래스의 부모 클래스이기 때문이다.
        
        // 인터페이스 정보 출력
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("Interface:  " + i.getName());
        }
    }
}
