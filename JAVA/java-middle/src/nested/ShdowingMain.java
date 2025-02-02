package nested;

public class ShdowingMain {

    public int value = 1;
//    public Inner inner;
//
//    public ShdowingMain(int value) {
//        this.inner = new Inner();
//        this.value = value;
//    }
//
//    void go() {
//        inner.go();
//    }

    class Inner {
        public int value = 2;

        void go() {
            int value  = 3; // 지역 변수 우선
            System.out.println("value = " + value);
            System.out.println("this.value = " + this.value);
            System.out.println("ShdowingMain.thi.value = " + ShdowingMain.this.value);
        }
    }

    public static void main(String[] args) {
        ShdowingMain smain = new ShdowingMain();
        Inner inner = smain.new Inner();
        inner.go();
//        smain.go();
    }
}
