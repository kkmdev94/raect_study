package construct.ex;

public class Book {
    String title;
    String author;
    int page;

    Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    Book(String title, String author) {
        this(title,author,0);
    }

    Book() { // 이미 생성자가 생성되어 있어서 기본 생성자를 자동으로 생성해주지 않기에 생성해주어야 한다.
        this("", "", 0); //이떄 값을 비워놓으면 null 값이 들어가기에 String은 "" 공백을 넣어줘야한다.
    }

    void displayInfo() {
//        System.out.println("제목 : " + this.title + ", 저자 : " + this.author + ", 페이지 : " + this.page);
        System.out.println("제목 : " + title + ", 저자 : " + author + ", 페이지 : " + page); // 어짜피 멤버 변수를 가져와서 출력하기에 this가 필요가 없다.
    }
}
// 생성자 강의 정리 부분에서 this에 대해 한번 더 정리해주니 그부분을 몇번 훑어보자