package generic.test.ex2;

public class Pair<T, T1> {

    private T value;
    private T1 value2;


    public void setFirst(T value) {
        this.value = value;
    }

    public void setSecond(T1 value2) {
        this.value2 = value2;
    }

    public T getFirst() {
        return value;
    }

    public T1 getSecond() {
        return value2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value=" + value +
                ", value2=" + value2 +
                '}';
    }
}
