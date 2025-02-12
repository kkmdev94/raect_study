package exception.basic.unchecked;

public class Client {

    public void call() { // throws MyUncheckedException 안해도 된다. RuntimeException은 컴파일러에서 체크를 하지 않고 그냥 터친다.
        throw new MyUncheckedException("ex");
    }
}
