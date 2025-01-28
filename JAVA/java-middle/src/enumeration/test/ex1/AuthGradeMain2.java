package enumeration.test.ex1;

import enumeration.ref3.Grade;

import java.util.Scanner;

public class AuthGradeMain2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN] : ");
        String auth = sc.nextLine();

        AuthGradeSc authGradeSc = AuthGradeSc.valueOf(auth.toUpperCase());
        System.out.println("당신의 등급은" + authGradeSc.getDescription() + "입니다.");
        System.out.println("== 메뉴 목록 ==");

        if (auth.equals("GUEST")) {
            System.out.println("- 메인 화면");
        } else if (auth.equals("LOGIN")) {
            System.out.println("- 메인 화면");
            System.out.println("- 이메일 관리 화면");
        } else if (auth.equals("ADMIN")) {
            System.out.println("- 메인 화면");
            System.out.println("- 이메일 관리 화면");
            System.out.println("- 관리자 화면");
        }
    }
}
