package hello.springtx.order;

/**
 * 잔고가 부족하면 발생하는 Exception
 */
public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
