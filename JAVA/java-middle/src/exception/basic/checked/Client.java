package exception.basic.checked;

public class Client {
    public void call() throws MyCheckedException{ // throws는 이 폭탄을 내가 처리할 수 없다 라고 하고 밖으로 던지는것
        // 문제 상황
        throw new MyCheckedException("ex"); // throw 실제 폭탄을 터트리는것, 즉 예외를 터트림
    }
}
