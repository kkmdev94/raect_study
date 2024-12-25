package static1;

public class Data3 {
    public String name;
    public static int count; //static / 멤버 변수에 static을 붙이게 되면 static 변수, 정적 변수 또는 클래스 변수라고 한다.

    public Data3(String name) {
        this.name = name;
        count++;
        // 원래는 Data3.count++; 이렇게 해야되는데, Data3의 생성자와 같이 자신의 클래스에 있는 정적 변수는 클래스명 생략 가능
        // name, count는 둘다 멤버 변수(필드)이다. 이 둘은 static이 붙은 것과 아닌 것에 따라 분류.
    }
}
