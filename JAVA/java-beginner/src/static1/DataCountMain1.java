package static1;

public class DataCountMain1 {

    public static void main(String[] args) {
        Data1 data1 = new Data1("A");
        System.out.println("A count = " + data1.count);

        Data1 data2 = new Data1("B");
        System.out.println("B count = " + data2.count);

        Data1 data3 = new Data1("C");
        System.out.println("C count = " + data3.count);

        // 객체를 새로 생성하기에 당연히 카운터는 초기화가 되어서 0이 되기에 1 , 1 , 1이 나온다.
    }
}
