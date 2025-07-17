package hello.login.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId; // 사용자가 입력하는 ID
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
