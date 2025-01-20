package lang.math.test;

import java.util.Random;

public class LottoNumber {
    private final Random random = new Random(); //<- 왜 final을 썻을까? 메소드 호출시 초기화 되기에 값을 변하지 않게 하기 위해서?
    private int[] lottoNum = new int[6]; // random으로 뽑은 숫자를 담을 배열
    private int numbers = 0; // 그 배열을 출력할때 사용할 기본형

    public int[] getLottoNum() {

        return lottoNum;
    }
}
