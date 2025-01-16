package lang.wrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AutoBoxingMain2 {

    public static void main(String[] args) {
        //Primitive -> Wrapper
        int value = 7;
        Integer boxedValue = value; // 오토 박싱(Auto-boxing)

        // Wrapper -> Primitive
        int unboxedValue = boxedValue; // 오토 언방식(Auto-Unboxing)

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
        
        Class clazz = new MyInteger(value).getClass();
        System.out.println("clazz.getSuperclass() = " + clazz.getSuperclass());
    }
}
