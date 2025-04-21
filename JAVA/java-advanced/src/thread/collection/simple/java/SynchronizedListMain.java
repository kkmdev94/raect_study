package thread.collection.simple.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListMain {

    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("data1");
        list.add("data2");
        list.add("data3");
        System.out.println(list.getClass());
        System.out.println("list = " + list);
    }
    /*
    위 코드는 자바에서 제공하는 proxy로 위 코드는 결론적으로 하자마녀
    new SynchronizedRandomAccessList<>(new ArrayList()); 와 같은 의미이다.
    Collections는 다양한 synchronized를 지원한다. List, Map, Set, Collection 등을 다 지원한다.

    단점은 동기화에 대한 최적화가 이루어지지 않는다.
    - 동기화 오버헤드 발생
    - 전체 컬렉션에 대해 동기화가 이루어지기 때문에 잠금 범위가 너무 넓어질 수 있다. 즉, 모든 메서드에 대해 동기화를 적용하다보면 병렬 처리의 효율성이 저하되고, 특정 스레드가 컬렉션을
    사용 중이면 다른 스레드들이 대기해야 하는 상황이 발생한다.
    - 정교한 동기화가 불가능하다.
     */
}
