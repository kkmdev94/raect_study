package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;

/**
 * 트랜잭션 = 트랜잭션 템플릿
 */
@Slf4j
public class MemberServiceV3_2 {

//    private final PlatformTransactionManager transactionManager;
    private final TransactionTemplate txTemplate;
    private final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_2(PlatformTransactionManager transactionManager , MemberRepositoryV3 memberRepository) {
        this.txTemplate = new TransactionTemplate(transactionManager);
        this.memberRepository = memberRepository;
    }

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {

        txTemplate.executeWithoutResult((status) ->{
            try {
                // 비즈니스 로직
                bizLogic(toId, money, fromId);
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });

//        전부다 삭제
//        // 트랜잭션 시작
//        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());//옵션은 뒤에서 설명.
//
//        try {
//            // 비즈니스 로직 수행
//            bizLogic(toId, money, fromId);
//            transactionManager.commit(status); // 정상 수행되면 커밋을 실행
//        } catch (Exception e){
//            transactionManager.rollback(status); // 실패시 롤백
//            throw new IllegalStateException(e);
//        }
    }

    private void bizLogic(String toId, int money, String fromId) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);
    }

    private static void validation(Member toMember) { // 문제가 생기면 오류 발생.
        if (toMember.getMemberId().equals("ex")){
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
