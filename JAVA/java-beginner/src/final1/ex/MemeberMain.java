package final1.ex;

public class MemeberMain {

    public static void main(String[] args) {
        Member member = new Member("myId", "kim");
        member.print();
        member.changeData("seo");
        member.print();
    }
}
