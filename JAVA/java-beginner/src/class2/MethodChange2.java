package class2;

public class MethodChange2 {

    public static void main(String[] args) {
        Data dataA = new Data(); // Data 클래스를 호출 참조값 주소가 담겨있다.
        dataA.value = 10; //
        System.out.println("메서드 호출 전 : dataA.value = " + dataA.value); // x001의 10이다.
        System.out.println("dataA = " + dataA);
        changeReference(dataA); // 참조형 주소를 넘겨준다. 그래서 dataX도 dataA의 참조 주소를 가르킨다.
        System.out.println("메서드 호출 후 : dataA.value = " + dataA.value); // 20
    }

    public static void changeReference(Data dataX) { //x002
        System.out.println("datax = " + dataX);
        dataX.value = 20; // x002의 20
    }

    /* 위 코드도 int dataX = dataA -> 다만 여기서 다른것은 참조형 즉 주소값을 가져오는것이다.
    자바에서 변수에 값을 대입하는 것은 항상 값을 복사해서 대입한다. 즉, 변수 dataA는 참조값 x001을 가지고 있으므로 참조값을 복사해서 전달했다.
    따라서 변수 dataA, dataX 둘다 같은 참조값인 x001을 가지게 된다.
    이제 dataX를 통해서도 x001에 있는 Data 인스턴스에 접근할 수 있다.

    자바에서 메서드의 매개변수(파라미터)는 항상 값에 의해 전달된다. 그러나 이 값이 실제 값이냐, 참조(메모리 주소)값이냐에 따라 동작이 달라진다.
        - 기본형 : 메서드로 기본형 데이터를 전달하면, 해당 값이 복사되어 전달된다. 이 경우, 메서드 내부에서 매개변수(파라미터)의 값을 변경해도, 호출자의 변수값에는 영향이 없다.
                예시로 내 종이에 10을 쓰고 옆 사람 종이에 10을 써줬다가 옆 사람 종이에 10을 20으로 바꿧다고 내 종이의 10이 20으로 바뀌진 않는다.
        - 참조형 : 메서드로 참조형 데이터를 전달하면, 참조값이 복사되어 전달된다. 이 경우, 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경 하면, 호출자의 객체도 변경된다.
                종이에 주소지가 있다, 옆 사람 종이에도 같은 주소지를 적어줫다. 그리고 옆 사람이 그 주소지로 가서 건물에 낙서를 했다. 그러면 내 종이에 적혀있는 주소의 건물로 가면 같은 건물을
                가르키고 있기에 찾아간 건물에도 동일한 낙서가 되어 있다.
    */
}
