package lang.wrapper;

public class AutoBoxingMain1 {

    public static void main(String[] args) {
        //Primitive -> Wrapper
        int value = 7;
        Integer boxedValue = Integer.valueOf(value); // 기본형을 래퍼로

        // Wrapper -> Primitive
        int unboxedValue = boxedValue.intValue(); // 래퍼를 기본형으로

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
