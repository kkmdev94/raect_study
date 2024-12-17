package class2;

public class NullMain1 {

    public static void main(String[] args) {
        Data data = null;
        System.out.println("1. data = " + data);
        data = new Data();
        System.out.println("2. data = " + data);
        data = null;
        System.out.println("3. data = " + data);
    }

    //GC =  gabige collection
    // 메모리에 있는 아무것도 참조 하지 않는 참조값들을 청소해준다.
}
