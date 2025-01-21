package lang.math.test;

import java.util.Random;

public class LottoNumber {
    private final Random random = new Random(); //<- 왜 final을 썻을까? 메소드 호출시 초기화 되기에 값을 변하지 않게 하기 위해서?
    private int[] lottoNum; // random으로 뽑은 숫자를 담을 배열
    private int count = 0; // 배열의 갯수만큼 카운트 할 숫자

    public int[] getLottoNum() {
        lottoNum = new int[6];
        for (int i = 0; i < lottoNum.length; i++) {
            int lottonumber = random.nextInt(45) + 1; // 랜덤 숫자 생성
            if (unLottoNum(lottonumber)) {
                lottoNum[count] = lottonumber;
                count++;
            }
        }
        return lottoNum;
    }

    private boolean unLottoNum(int lottonumber) {
        for (int i = 0; i < count; i++) {
            if (lottoNum[i] == lottonumber) {
                return false;
            }
        }
        return true;
    }
}
