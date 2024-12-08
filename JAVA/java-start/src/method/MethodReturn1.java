package method;

public class MethodReturn1 {

    public static void main(String[] args) {
        boolean result = odd(3);
        System.out.println(result);
    }

    public static boolean odd(int i) {
        if (i % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
// 반환 타입에서는 무조건 return이 있어야 한다.
// 그리고 return 문을 만나면 즉시 해당 메서드를 빠져나간다.