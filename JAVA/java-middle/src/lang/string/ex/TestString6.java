package lang.string.ex;

public class TestString6 {

    public static void main(String[] args) {
        String str = "start hello java, hello spring, hello jpa";
        String key = "hello";
        int count = 0;

        int index = str.indexOf(key);

        while (index >= 0) { // 1)
            index = str.indexOf(key, index + 1); //2)
            count++;
        }
        System.out.println("count = " + count);
    }
    /*
    선생님의 풀이 공식 설명(각 부분 주석)
    1) 왜 0보다 크거나 같냐면, 여기에다가 제가 아무 메세지나 넣어볼게요. 그럼 마이너스 1이 나오죠.
        그러니까 못 찾으면, 뭘 반환하냐면 얘가 여기 없는 단어를 치잖아요? 더 이상 못 찾으면 마이너스 1을 반환하죠. 그래서 끝까지 찾을 때까지라는 뜻이에요.
    2) 자, 인덱스는 0보다 크거나 같을 때까지 어떻게 하느냐, str.indexOf 해서 키를 넣을 거예요. 그리고 두 번째가 보시면 fromIndex는 어디서부터 찾을 거냐는 거예요.
        처음 hello 찾았죠? 그러면 Hello 찾으면 그다음에는 이 Hello 찾은 거에서 한 칸 다음부터 찾으면 되겠죠. 그래서 어떻게 하느냐, 인덱스에다 플러스 1을 해주는 겁니다.
        처음에 인덱스가 여기다가 카운트 이제 그게 맞으면 카운트 하나 증가시켜주고 자, 처음에 인덱스가 6이 나왔단 말이에요.
        그럼 여기서 한 칸 더해요. 그럼 여기서부터 다시 찾아요.
        자 이거 indexOf 로 찾았죠? 자, 이 결과를 인덱스에다가 넣어줘야 되는데 제가 안 넣어줘서 무한루프를 돌았네요?
     */
}
