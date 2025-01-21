package lang.math.test;

import java.util.Random;
import java.util.stream.IntStream;

public class testtt {

    public static void main(String[] args) {
        Random random = new Random(); //<- 왜 final을 썻을까? 메소드 호출시 초기화 되기에 값을 변하지 않게 하기 위해서?
        int[] lottoNum = new int[6];; // random으로 뽑은 숫자를 담을 배열
        int count = 0; // 배열의 갯수만큼 카운트 할 숫자

        for (int i = 0; i < lottoNum.length; i++) {
            int lottonumber = random.nextInt(45) + 1; // 랜덤 숫자 생성
            lottoNum[count] += lottonumber;
            count++;
//            if () {
//               //값이 중복이라면 넣지 않기.
//            }
        }
        System.out.print("로또번호 : ");
        for (int i : lottoNum) {
            System.out.print(i + " ");
        }
    }
}
