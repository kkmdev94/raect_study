package construct.ex;

public class BookMain {

    public static void main(String[] args) {
        Book book1 = new Book(); //요 안에는 기본 생성자가 자동으로 생성되어 있다.
        book1.displayInfo();

        Book book2 = new Book("Hello Java", "Seo");
        book2.displayInfo();

        Book book3 = new Book("JPA 프로그래밍", "kim", 700);
        book3.displayInfo();
    }
}
