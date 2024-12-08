package array;

import java.util.Scanner;

public class ArrayDiEx3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxCount = 10;
        String[] productName = new String[maxCount];
        int[] productPrices = new int[maxCount];
        int productCount =0;


        while (true) {
            System.out.println("1. 상품 등록 | 2. 상품 목록 | 3. 종료");
            System.out.print("메뉴를 선택하세요 : ");
            int select = sc.nextInt();

            if (select == 1) {

                if (productCount >= maxCount) {
                    System.out.println("상품 갯수가 10개를 초과 할 수 없습니다.");
                    continue;
                }

                sc.nextLine();

                System.out.print("상품 이름을 입력하세요 : ");
                productName[productCount] = sc.nextLine();

                System.out.print("상품 가격을 입력하세요 : ");
                productPrices[productCount] = sc.nextInt();

                productCount++;

            } else if (select == 2) {
                if (productCount == 0) {
                    System.out.println("등록된 상품이 존재하지 않습니다.");
                    continue;
                } else {
                    for (int i = 0; i < productCount; i++) {
                        System.out.print(productName[i] + " : ");
                        System.out.println(productPrices[i] + "원");
                    }
                }
            } else if (select == 3) {
                System.out.println("3번 종료를 입력하셨습니다.");
                System.out.println("프로그램을 종료합니다..");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
