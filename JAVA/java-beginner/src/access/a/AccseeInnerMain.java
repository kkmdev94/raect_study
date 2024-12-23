package access.a;

public class AccseeInnerMain {

    public static void main(String[] args) {
        AccessData data = new AccessData();
        //public 호출 가능
        data.publicField = 1;
        data.publicMethod();

        //같은 패키지 default 호출 가능
        data.defaultField =2;
        data.defaultMethod();

        //private 호출 불가
//        data.privateField =3;
//        data.privateMethod();

        data.innerAccess();
        //메서드 자체가 public이라 외부에서 호출 할 수 있다 innerAccess() 메서드는 외부에서 호출되었지만 innerAccess() 메서드는
        // AccessData에 포함되어 있다. 이 메서드는 자신의 private 필드와 메서드에 모두 접근할 수 있다.
        // 물론 값만 접근 가능 private 수정은 당연히 안된다.
    }
}
