package casting;

public class Casting3 {

    public static void main(String[] args) {
        long maxIntValue = 2147483647;
        long maxIntOver = 2147483648L;
        int intValut = 0;

        intValut = (int) maxIntValue;
        System.out.println("maxIntValue casting = " + intValut);

        intValut = (int) maxIntOver;
        System.out.println("maxIntOver casting = " + intValut);
    }
}
