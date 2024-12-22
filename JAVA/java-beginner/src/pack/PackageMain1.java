package pack;


public class PackageMain1 {

    public static void main(String[] args) {
        Data data = new Data();
        pack.a.User user = new pack.a.User(); // 기존 방식대로라면 사용자와 다른 위치의 pack를 불러올때는 이렇게 풀 네임을 작성해야 했다.
    }
}
