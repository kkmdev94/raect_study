package construct;

public class MethodInitMain3 {

    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        member1.initMember("user1",15,80);

        MemberInit member2 = new MemberInit();
        member2.initMember("user2",16,90);

        MemberInit[] members = {member1,member2};

        for (MemberInit s : members) {
            System.out.println("이름 : " + s.name + " 나이 : " + s.age + " 점수 : " + s.grade);
        }
    }
}
