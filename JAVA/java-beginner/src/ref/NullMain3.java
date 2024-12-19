package ref;

public class NullMain3 {

    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count = " + bigData.count); // 기본형은 초기값 0
        System.out.println("bigData.data = " + bigData.data); // new를 이용해 새로운 객체를 생성해야 하는데 객체를 생성하지 않앗으니 Data의 참조값 주소는 비어있다. 그래서 null이 출력된것 같다.
        //참조형의 초기값은 null이다.

        System.out.println("bigData.data.value" + bigData.data.value); // 참조값의 주소가 없는 상태에서 그 안에 value값을 가져오려 하니 오류가 발생한것 같다..
    }
}
