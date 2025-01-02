package pay.ex0;

public class PaySystem {

    public static Pay payOption(String option) {

        if (option.equals("kakao")) {
            return new KakaoPay();
        } else if (option.equals("naver")) {
            return new NaverPay();
        } else {
            return new DefultePay();
        }
    }
}
