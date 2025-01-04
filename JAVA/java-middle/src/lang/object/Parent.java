package lang.object;

// 부모가 없으면 묵시적으로 Object 클래스를 상속 받는다.
public class Parent {
// 즉, 위 클래스는 사실 public class Parent extends Object와 같다

    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
