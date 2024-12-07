package array;

public class EnhancedFor1 {

    public static void main(String[] args) {
        //향상된 포문 or ForEach 문이라고도 불린다.
        int[] numbers = {1, 2, 3, 4, 5};

        //일반 for문
        for (int i = 0; i < numbers.length; i++){
            int number = numbers[i];
            System.out.println(number);
        }

        //향상된 for문, for-each문
        for (int number : numbers){
            System.out.println(number);
        }

//        for (int number : numbers) { // 단축기 iter을 입력하면 향상된 for문이 나온다
//        }

        //for-each문을 사용할 수 없는 경우, 증가하는 index 값 필요
        for (int i = 0; i < numbers.length; i++) {  // 즉 int i 의 증가하는 i 값을 출력을 해야 하기 때문에 일반 for문을 사용해야된다.
            System.out.println("number" + i + "번의 결과는: " + numbers[i]);
        }
    }
}
