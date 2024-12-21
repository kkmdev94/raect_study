package construct;

public class ConstructMain1 {

    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 80); // 객체 생성과 동시에 생성자를 통해 바로 호출을 해준다
        MemberConstruct member2 = new MemberConstruct("user2", 16, 90);

        MemberConstruct[] members = {member1, member2};

        for (MemberConstruct s : members) {
            System.out.println("이름 : " + s.name + " 나이 : " + s.age + " 점수 : " + s.grade);
        }
    }
}
/*
하나의 클래스에서 생성자를 여러개 할 수는 없는걸까? 이것도 찾아봐야겟다.
생성자는 인스턴스를 생성하고 나서 즉시 호출, 생성자 이름이 클래스이름과 같이 써야된다(이것은 규칙)
new 키워드를 사용해서 객체를 생성할 떄 마지막에 괄호()도 포함해야하는 이유가 바로 생성자 떄문이다.

장점
1. 중복 호출 제거 : 생성자가 없던 때에는 생성 직후 어떤 작업을 수행하기 위해 다음과 같이 메서드를 직접 한번더 호출해야 했다.
2. 제약 - 생성자 호출 필수 : 호출에 필요한 메서드를 누락했을때, 아무문제 없이 돌아가는 파일이 되어버리고 데이터가 누락되는 버그가 발생할 수 도 있다. /생성자 호출 시 빼 먹으면 빌드 오류가 난다.
    생성자의 진짜 장점은 객체를 생성할 때 직접 정의한 생성자가 있다면 직접 정의한 생성자를 반드시 호출해야 한다는게 장점이다.
    생성자를 메서드 오버로딩 처럼 여러개 정의할 수 있는데, 이경우에는 하나만 호출하면 된다.
    생성자를 사용하면 필수값 입력을 보장할 수 있다.
 */