package static2;

//import static static2.DecoData.staticCall; // 클래스 명에서 alt+enter를 통해 static 메서드를 import 시킬 수 있다. 이러면 클래스 명을 생략하고 해당 클래스의 메서드를 호출 할 수 있다.

public class DecoDataMain {

    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
        DecoData.staticCall(); //1

        System.out.println("2. 인스턴스 호출1");
        DecoData data1 = new DecoData();
        data1.instanceCall(); // 1 , 2

        System.out.println("3. 인스턴스 호출2");
        DecoData data2 = new DecoData();
        data2.instanceCall(); // 1 , 3

        //추가
        //인스턴스를 통한 접근
        DecoData data3 = new DecoData();
        data3.staticCall(); // 클래스 변수에서 했던것과 똑같이 가능은 하지만 이유는 동일하게 인스턴스 소속인지 오해를 부를 수 있기에 사용 X

        //클래스를 통한 접근
        DecoData.staticCall();
    }
}
