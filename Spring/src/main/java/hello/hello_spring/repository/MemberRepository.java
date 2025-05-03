package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional에 대해 간단하게 적자면, 값을 찾을 때 값이 null 일경우 null을 그대로 반환하는게 아닌 optional로 감싸서 반환. 자세한건 뒤에서 설명.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
