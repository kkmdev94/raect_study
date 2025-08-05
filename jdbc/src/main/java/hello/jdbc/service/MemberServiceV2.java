package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜잭션 = 파라미터 연동, 풀을 고려한 종료.
 */
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final DataSource dataSource;
    private final MemberRepositoryV2 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {

        Connection con = dataSource.getConnection();
        try {
            con.setAutoCommit(false); // 트랜잭션 시작 - false를 통한 오토커밋 비활성화

            // 비즈니스 로직 수행
            bizLogic(con, toId, money, fromId);

            con.commit(); // 정상 수행되면 커밋을 실행
        } catch (Exception e){
            con.rollback(); // 실패시 롤백
            throw new IllegalStateException(e);
        }finally {
            release(con);
        }
    }

    private void bizLogic(Connection con, String toId, int money, String fromId) throws SQLException {
        Member fromMember = memberRepository.findById(con, fromId);
        Member toMember = memberRepository.findById(con, toId);

        memberRepository.update(con, fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(con, toId, toMember.getMoney() + money);
    }

    private static void validation(Member toMember) { // 문제가 생기면 오류 발생.
        if (toMember.getMemberId().equals("ex")){
            throw new IllegalStateException("이체중 예외 발생");
        }
    }

    private static void release(Connection con) {
        if (con != null) {
            try {
//                    con.close(); // 그냥 클로즈하면 pool에 돌아갈 때 우리가 설정한 Autocommit이 false인 상태로 들어간다 그래서 그냥 종료하면 안된다.
                con.setAutoCommit(true); // 커넥션 풀 고려
                con.close();
            } catch (Exception e) {
                log.info("error", e);
            }
        }
    }
}
