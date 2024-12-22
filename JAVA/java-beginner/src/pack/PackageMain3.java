package pack;

import pack.a.User;

public class PackageMain3 {

    public static void main(String[] args) {
        User user = new User(); // 자주사용하는애를 import하고 자주 안쓰는 친구를 풀네임으로 작성한다.
        pack.b.User userB = new pack.b.User(); // 클래스 이름이 같으면 기본적으로 하나는 풀네임으로 작성해줘야 한다.
    }
}
