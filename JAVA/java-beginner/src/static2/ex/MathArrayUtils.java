package static2.ex;

public class MathArrayUtils {
    private static int sum;
    private static double average;
    private static int min;
    private static int max;
    private static int count;

    private MathArrayUtils() {
        // 인스턴스 생성자를 막는다.
    }

    public static int sum(int[] values) {
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static double average(int[] values) {
        for (int i = 0; i < values.length; i++) {
            count++;
        }
        average = sum / count;
        return average;
    }

    public static int min(int[] values) {
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) { // i가 min보다 작다면
                min = values[i];
            }
        }
        return min;
    }

    public static int max(int[] values) {
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}
