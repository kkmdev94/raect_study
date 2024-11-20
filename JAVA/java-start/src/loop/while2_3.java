package loop;

public class while2_3 {

    public static void main(String[] args) {
        int i = 1;
        int endNum = 3;

        while(endNum >= i) {
            int sum = i + i++;
            System.out.println(sum);
        }
    }
}
