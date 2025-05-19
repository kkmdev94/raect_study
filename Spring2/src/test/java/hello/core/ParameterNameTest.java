package hello.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderServiceImplLombok;
import org.junit.jupiter.api.Test;

public class ParameterNameTest {

    @Test
    void parameterNameCheck() {
        Constructor<?>[] constructors = OrderServiceImpl.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor);
            for (Parameter parameter : constructor.getParameters()) {
                System.out.println("  Parameter name: " + parameter.getName());
            }
        }
    }
}
