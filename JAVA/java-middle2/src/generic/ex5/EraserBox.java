package generic.ex5;

public class EraserBox<T> {

    public boolean instanceCheck(Object param) { //타입 이레이저로 인해 Object로 바뀌고 boolean은 Object와 비교하기 때문에 항상 참이나와서 불가능.
//        return param instanceof T; // 오류
        return false;
    }

    public void create() { // 타입 이레이저로 인해 Object로 바뀌기 때문에 new 를 허용하지 않는다.
//        return new T(); // 오류
        return;
    }
}
