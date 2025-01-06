package lang.immutable.change;

public class ImmutableMain2 {

    public static void main(String[] args) {
        ImmutalbeObj obj1 = new ImmutalbeObj(20);
        obj1.add(10);

        System.out.println("obj1 = " + obj1.getValue());
        /*
            obj1.getValue()가 10이 나온 이유는 add 메서드는 ImmutableObj 타입으로
            ImmutableObj의 새로운 객체를 리턴 받고 있는데 리턴 받은 값을 받지 않아서
            즉 ImmutableObj obj2 = obj.add(10)을 그냥 버리고 있어서 add 메소드가 더해진
            값이 안나오는 것이다.

            obj1은 불변객체이므로 생성자를 통해 만들어진 값인 10은 절대로 변하지 않는다.
            ImmutableObj obj2에 다가 새로 생성된 객체를 대입해주고 obj2를 호출해야 확인이 가능하다.
         */
    }
}
