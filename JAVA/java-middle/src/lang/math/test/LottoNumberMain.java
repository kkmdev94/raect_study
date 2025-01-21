package lang.math.test;

public class LottoNumberMain {

    public static void main(String[] args) {
        LottoNumber lottoNumber = new LottoNumber();
        System.out.print("로또 번호 : ");
        for (int i : lottoNumber.getLottoNum()) {
            System.out.print(i + " ");
        }
    }
}
