package lang.string.chaining;

public class MethodCnainingMain1 {

    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();
        adder.add(1);
        adder.add(2);
        adder.add(3);

//        System.out.println("adder : " + adder.getValue());
        int result = adder.getValue();
        System.out.println("result = " + result);
    }
}
