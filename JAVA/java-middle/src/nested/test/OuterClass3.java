package nested.test;

public class OuterClass3 {

    public void myMethod() {

        class print implements hello {

            @Override
            public void hello() {
                System.out.println("LocalClass.hello");
            }
        }
        print print = new print();
        print.hello();
    }
}
