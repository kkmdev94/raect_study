package static1;

public class DataCountMain3 {

    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count = " + Data3.count); //static이 붙은 멤버 변수는 클래스에 직접 붙어서 사용하기에 Data3.count를 쓴다

        Data3 data2 = new Data3("B");
        System.out.println("B count = " + Data3.count);

        Data3 data3 = new Data3("C");
        System.out.println("C count = " + Data3.count);

        // Data3.count -> 클래스에 직접 접근해서 사용한다.
        // static이 붙은 멤버 변수는 메서드 영역에서 관리한다. / static이 붙은 멤버 변수 count는 인스턴스 영역에서 생성 X 메서드 영역에서 관리
        // static 변수는 공용으로 사용한다는 뜻이다.
        // static 변수 = 클래스인 붕어빵 틀이 특별히 관리하는 변수. 붕어빵 틀은 1개이므로 클래스 변수도 하나만 존재, 반면에 인스턴스인 붕어빵은 인스턴스의 수만 만큼 변수가 존재
        // 위의 문제를 예시로 name은 여러개지만 count는 여러 인스턴스에서 사용하기에 클래스 변수로 1개로 존재하기에 static이 붙어서 공용으로 사용한다.

        // 추가
        // 인스턴스를 통한 접근
        Data3 data4 = new Data3("D");
        System.out.println(data4.count);
        // 데이터4에 있는 count에 접근 -> static이 붙은 정적 영역이라 메소드 영역에 있는 count로 넘어감 / 권장 X 이렇게 하면 count가 인스턴스 변수인지 static이 붙은건지 오해할 수 있다.

        // 클래스를 통한 접근
        System.out.println(Data3.count);
    }
}
