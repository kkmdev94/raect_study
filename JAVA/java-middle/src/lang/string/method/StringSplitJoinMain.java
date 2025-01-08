package lang.string.method;

public class StringSplitJoinMain {

    public static void main(String[] args) {
        String str = "Apple,Banana,Orange";

        //은근히 쓰이는게 많은 split과 join

        //spilt
        String[] splitStr = str.split(","); // ,를 기준으로 자른다. 자른값을 split에 넣는다.
        for (String s : splitStr) { //향상 for문으로 돌려서 추출
            System.out.println(s);
        }

        // join의 불편한 예 / 마지막에 - 들어가는 것을 막기위한 for문
//        String joinstr1 = "";
//        for (int i = 0; i < splitStr.length; i++) {
//            String string = splitStr[i];
//            joinstr1 += string;
//            if (i != splitStr.length - 1) {
//                joinstr1 += "-";
//            }
//        }
//        System.out.println(joinstr1);

        //join
        String joinedStr = String.join("-", "A", "B", "C");
        System.out.println("연결된 문자열 = " + joinedStr);

        // 문자열 배열 연결
        String joinedStr2 = String.join("-", splitStr);
        System.out.println("연결된 문자배열 = " + joinedStr2);
    }
}
