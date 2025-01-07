package lang.string.equals;

public class StringEqualsMain0 {

    public static void main(String[] args) {
//        String str3 = new String("hello");
        String str3 = "hello";
        String str4 = str3;
        System.out.println("리터럴 == 비교 : " + (str3 == str4));
        System.out.println("리터럴 equals 비교 : " + str3.equals(str4));

        str4 = "java";
        System.out.println("str3 : " + str3);
        System.out.println("리터럴 == 비교 : " + (str3 == str4));
        System.out.println("리터럴 equals 비교 : " + str3.equals(str4));
        /*
        리터럴을 사용하면 문자열 풀을 사용하여 문자열 풀에 x003.hello 라는 참조값을 만들어 놓고
        저장을 해놓는다 그리고 프로그램을 실행하면서 문자열 풀에서 값을 찾아오는 것이다.(이것에 대한 설명은 노션에 자세히)
        그러면 str3에서 x003이라는 참조값을 풀에 만들어 놓고 str4에 str3을 대입해서 넣어 놧으면 같은 참조값을 가르키는 상황인데,
        여기서 x003이라는 같은 참조값을 가진 상태에서 str4에 java라는 단어를 대입하면 이것도 리터럴로 인해 x003의 참조값이 아닌
        새로운 인스턴스 x004를 생성하고 문자열 풀에 들어가는 것일까? 원래 배운대로라면 같은 참조값을 가르키는 것이기에,
        str3도 java로 변해야 되는게 맞지 않을까? 아니면 String 클래스는 불변 객체라 그런것일까?
         */
    }
}
