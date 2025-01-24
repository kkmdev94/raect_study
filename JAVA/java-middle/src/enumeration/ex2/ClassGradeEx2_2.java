package enumeration.ex2;

public class ClassGradeEx2_2 {

    public static void main(String[] args) {
        int price = 10000;
        
        DiscountService discountService = new DiscountService();
//        ClassGrade newClassGrade = new ClassGrade();
        // ClassGrade가 들어가는것을 보고 객체를 새로 생성해야되나? 라는 생각을 충분히 할 수 있다.
        // 그러면 새로 생성자를 생성해버리고 해당 객체 newClassGrade는 새로운 참조값을 참조하므로 할인금액이 나올 수 없다.
        // ClassGrade에서 private으로 생성자를 막아버려야 된다.
//        int result = discountService.discount(newClassGrade, price);
//        System.out.println("result = " + result);
    }
}
