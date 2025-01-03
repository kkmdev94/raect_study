package polyex.pay1;

public class PayMain0 {

    public static void main(String[] args) {
        PayService payService = new PayService();

        //Kakao 결제
        String option = "kakao";
        int amount1 = 5000;
        payService.processPay(option, amount1);

        //Naver 결제
        String option2 = "naver";
        int amount2 = 7000;
        payService.processPay(option2, amount2);

        //잘못된 결제 수단 선택
        String option3 = "bad";
        int amount3 = 10000;
        payService.processPay(option3, amount3);
    }
}
