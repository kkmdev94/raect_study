package lang.immutable.change;

public class MutableMain {

    public static void main(String[] args) {
        MutalbeObj obj = new MutalbeObj(20); //참조 X001
        // X001.value = 20
        obj.add(10); // x001.value = 20 + 10

        // 계산 이후의 기존 값은 사라짐.
        System.out.println("obj = " + obj.getValue());
        //X001의 value는 add로 인해서 참조값 내부값이 바뀌는것.
    }
}
