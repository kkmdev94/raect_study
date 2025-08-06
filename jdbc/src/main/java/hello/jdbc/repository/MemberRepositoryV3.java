package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
 * JDBC -ConnectionParam
 */
@Slf4j
public class MemberRepositoryV3 {

    private final DataSource dataSource;

    public MemberRepositoryV3(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId()); //SQL의 파라미터 바인딩 ?로 되어 있는 곳
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate(); // 실행.
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally {
//            pstmt.close(); // 만약에 close에서 Exception이 터지면, 아래 close가 호출이 안된다. 그래서 아래에서 만들어서 호출을 할 예정
//            con.close();
            // 리소스 정리(close)는 역순으로 해야한다. 위에서 보면 con을 먼저 획득하고 con을 통해 pstmt를 만들었기 때문에 종료할때는 pstmt를 먼저 종료하고 con을 종료해야한다.
            close(con, pstmt, null);
        }
    }

    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);

            rs = pstmt.executeQuery();// select 에서는 executeQuery를 사용.
            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id")); // rs.String 타입으로 조회 즉, rs로 조회를 한다 아래의 Money도 동일
                member.setMoney(rs.getInt("money"));
                return member;
            } else {
                // rs.next는 처음에 커서라는게 생성되는데 처음에는 아무것도 가르키고 있지 않는다. 그래서 next를 통해 다음 데이터가 있는지 확인을 하기위해 호출을 해줘야 한다.
                // 그래서 else에서는 데이터가 있는지 확인했을때 데이터가 없으면 예외를 던져주는 것이다.
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }
        } catch (SQLException e) {
            log.info("db error",e);
            throw e;
        }finally {
            close(con, pstmt, rs);
        }
    }

    public Member findById(Connection con, String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
//            con = getConnection(); // 기존 사용하던 커넥션을 파라미터로 받기에 GetConnection을 통해 새로운 커넥션을 호출하면 큰일난다.
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);

            rs = pstmt.executeQuery();// select 에서는 executeQuery를 사용.
            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else {
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }
        } catch (SQLException e) {
            log.info("db error",e);
            throw e;
        }finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(pstmt);
//            JdbcUtils.closeConnection(con); // 서비스 계층에서 시작된 커넥션을 파라미터로 받고 처리 후 해당 커넥션을 이어가야 하기 때문에 여기서 닫아주는게 아닌
                                              // 서비스 계층에서 닫아주어야 한다.
        }
    }

    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money=? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId );
            int resultSize = pstmt.executeUpdate(); // 쿼리를 실행하고 영향을 받은 row 수를 반환.
            log.info("resultSize={}", resultSize);
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally {
            close(con, pstmt, null);
        }
    }

    public void update(Connection con, String memberId, int money) throws SQLException {
        String sql = "update member set money=? where member_id=?";

//        Connection con = null;
        PreparedStatement pstmt = null;

        try {
//            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId );
            int resultSize = pstmt.executeUpdate(); // 쿼리를 실행하고 영향을 받은 row 수를 반환.
            log.info("resultSize={}", resultSize);
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally {
            JdbcUtils.closeStatement(pstmt);
//            JdbcUtils.closeConnection(con); // 위 findById와 동일한 이유.
        }
    }

    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally {
            close(con, pstmt, null);
        }
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);
    }

    private Connection getConnection() throws SQLException {
        Connection con = dataSource.getConnection();
        log.info("get connection={}, class={}", con.getClass()
        );
        return con;
    }
}
