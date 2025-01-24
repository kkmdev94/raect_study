package enumeration.ex2;


// 회원 등급을 다루는 '클래스'를 만든다. = ClassGrade가 회원 등급을 다루는 클래스
public class ClassGrade {


    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();
    public static final ClassGrade VIP = new ClassGrade();

    // private 생성자 추가
    private ClassGrade() {}
}
