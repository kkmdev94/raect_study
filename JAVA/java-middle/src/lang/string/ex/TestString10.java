package lang.string.ex;

public class TestString10 {

    public static void main(String[] args) {
        String fruits = "apple,banana,mango";

        String[] splits = fruits.split(",");
//        System.out.println(splits[0]);
        String fruitsJoin = String.join("->", splits);
        System.out.println("fruitsJoin = " + fruitsJoin);
    }
}
