package class2;

public class VarChange2 {

    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA; // 인스턴스 복사 X 참조값만 복사.

        System.out.println("dataA 참조값 = " + dataA);
        System.out.println("dataB 참조값 = " + dataB);
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value); // dataA의 참조값을 복사해서 가져왔는데.. dataA의 참조값을 dataB에 복사는 햇는데 내부값은 어떻게 복사가 되었을까?

        //dataA 변경
        dataA.value = 20;
        System.out.println("dataA 참조값 = " + dataA); //20
        System.out.println("dataB 참조값 = " + dataB); //
        System.out.println("dataA.value = " + dataA.value); // 얘도 x001
        System.out.println("dataB.value = " + dataB.value); // 얘도 x001
        // dataA의 참조값을 복사 하는거라 dataA가 가르키는 벨류값은 20, 즉 A 건물을 찾아가는 주소지를 복사했기에 dataB에 담긴 것도 A의 주소지이기에 값이 같이 바뀐다.

        //dataB 변경
        dataB.value = 30;
        System.out.println("dataA 참조값 = " + dataA);
        System.out.println("dataB 참조값 = " + dataB);
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
        // dataB는 A의 주소지를 대입 = 복사해서 가져온 것이다. 그러면 B를 변경했을때 A는 왜 바뀌었을까? 내 생각은 B의 값도 결국 A의 주소지를 복사해서 가져온 것이기에 같은 주소지를 가르키고 있어서
        // 값이 같이 변경된것 같다. 아래는 설명을 듣고 이해한것을 적어놓아 보자.

        // 즉, dataA와 dataB는 같은 참조값을 가르키고 있다. 그러면 실제 있는거는 한개 뿐이고 실제 있는거의 값을 20으로 변경 했기 때문에 a,b 둘다 같은 곳을 가르키고 있어서 둘다 바뀐다.
        // 둘다 바뀐다라는 표현보다는 dataA가 가르키는 인스턴스를 복사하는게 아닌 참조 값만을 복사해서 전달한거라 인스턴스는 원래 하나고 주소지(즉,표지판만 두개이고) 가르키는곳은 하나이다.
        // dataA와 dataB가 다르게 나오고 싶었다면 Data dataB = new Data(); 로 새로 선언해 줬어야 했다.
        // 핵심은 Data dataB = dataA라고 했을때 변수에 들어있는 값을 복사해서 사용한다는 점이다.
    }
}
