package lang.immutable.change;

public class ImmutableMain {

    public static void main(String[] args) {
        ImmutalbeObj obj1 = new ImmutalbeObj(20);
        ImmutalbeObj obj2 = obj1.add(10);


        System.out.println("obj1 = " + obj1.getValue());
        System.out.println("obj2 = " + obj2.getValue());
    }
}
