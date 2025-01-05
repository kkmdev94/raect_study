package lang.object.equals;

import java.util.Objects;

public class UserV2 {
    private String id;

    public UserV2(String id) {
        this.id = id;
    }

    // 정확한 equals의 구현 alt + insert
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserV2 userV2 = (UserV2) object;
        return Objects.equals(id, userV2.id);
    }

//    @Override
//    public boolean equals(Object obj) { //
//        UserV2 user = (UserV2) obj; // 부모는 자식을 담을 수 없다. Object에는 id가 없기에 다운캐스팅진행.
//        return id.equals(user.id);
//        /* 나랑 <- UserV2랑 obj로 넘어온 이 값이 같은지를 비교하는 것이다.
//        즉 UserV2 클래스에서 생성자로 넘어온 ID와 equals에서 넘어오는 id값이 같은지 비교하는 것이다.
//        UserV2.id == obj.id 이것과 같은가에 대한 결과비교하는데 String 객체는 equals를 사용하여 비교하는 것이다.
//
//         그래서 return id.equals(user.id)는 결국
//         boolean result = UserV2.id == user.id로 String 타입이라 equals를 사용하여
//         return id.equals(user.id) <- 이 문장이 완성된 것이다.
//         */
    //}
}
