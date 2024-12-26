package final1;

public class FianlRefMain {
    public static void main(String[] args) {
        final Data data = new Data(); // 참조형,
        /* final Data data; (변수 선언)
        data = new Data() <- 같은 의미*/
//        Data data2 = new Data();
//        data2 = new Data();

//        data = new Data(); // 컴파일 오류남

        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}
