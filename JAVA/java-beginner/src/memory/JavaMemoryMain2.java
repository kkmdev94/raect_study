package memory;

public class JavaMemoryMain2 {

    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end");
    }

    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10); // method1에서 Data data1이라는 지역 변수를 가지고 있고 이것은 스택 영역에서 관리 / new Data(10)을 선언하면서 힙 영역에 x001의 value 값을 메모리에 할당
        method2(data1);
        System.out.println("method1 end");

    }

    static void method2(Data data2) {
        System.out.println("method2 start");
        System.out.println("data.value = " + data2.getValue());
        System.out.println("method2 end");
    }
}
