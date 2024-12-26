package static2.ex;

public class MathArrayUtils {
//    private static int sum;
//    private static double average;
//    private static int max;
//    private static int count;
// 위 멤버 변수들을 사용하지 않은 이유는 여러곳에서 해당 클래스를 사용할 시 클래스의 변수 값이 여러곳에서 호출되는 메서드로 인해 값이 섞이게 될 수 있어 원하는 결과를 못 찾는다.

    private MathArrayUtils() {
        // 인스턴스 생성자를 막는다.
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static double average(int[] values) {
//        int count = 0;
//        int average = 0;
//        for (int i = 0; i < values.length; i++) {
//            count++;
//        }
//        average = sum(values) / count;
//        return average;
//        위 코드처럼 해도 상관없다 하지만 선생님의 풀이처럼 간략하게 한줄로 요약하게 풀어도 된다.
        return (double)sum(values) / values.length;
    }

    public static int min(int[] values) {
        int minvalue = values[0]; // min 또는 아래의 max 값을 구할때는 변수 하나를 만들어 배열의 0번째를 넣은 후 비교하게 한다.
        for (int i = 1; i < values.length; i++) {
            if (values[i] < minvalue) {
                minvalue = values[i];
            }
        }
        return minvalue;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}
