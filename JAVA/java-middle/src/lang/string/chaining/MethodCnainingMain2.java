package lang.string.chaining;

public class MethodCnainingMain2 {

    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();
        ValueAdder adder1 = adder.add(1); // x001.add(1)
        ValueAdder adder2 = adder1.add(2); // x001.add(2)
        ValueAdder adder3 = adder2.add(3); // x001.add(3)

//        System.out.println("adder : " + adder.getValue());
        int result = adder3.getValue();
        System.out.println("result = " + result);

        System.out.println("result = " + adder1);
        System.out.println("result = " + adder2);
        System.out.println("result = " + adder3);
    }
}
