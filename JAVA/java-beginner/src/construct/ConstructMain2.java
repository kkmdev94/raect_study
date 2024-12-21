package construct;

public class ConstructMain2 {

    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 80); // 객체 생성과 동시에 생성자를 통해 바로 호출을 해준다
        MemberConstruct member2 = new MemberConstruct("user2", 16);
        MemberConstruct member3 = new MemberConstruct("user3",88);
        MemberConstruct member4 = new MemberConstruct("user4");

        MemberConstruct[] members = {member1, member2, member3, member4};

        for (MemberConstruct s : members) {
            System.out.println("이름 : " + s.name + " 나이 : " + s.age + " 점수 : " + s.grade);
        }
    }
}