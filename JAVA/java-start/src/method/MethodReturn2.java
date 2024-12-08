package method;

public class MethodReturn2 {

    public static void main(String[] args) {
        agecut(10);
        agecut(20);
    }

    public static void agecut(int i) {
        if (i <= 18) {
            System.out.println(i + "살, 미성년자는 출입을 하실 수 없습니다.");
            return; //리턴을 만나서 빠져 나오게 된다.
        }

        System.out.println(i + "살, 성인이므로 출입을 하실 수 있습니다.");
    }
}
