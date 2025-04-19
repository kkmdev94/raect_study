package thread.cas.increment;

public class BasicInteger implements INcrementInteger{

    private int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
