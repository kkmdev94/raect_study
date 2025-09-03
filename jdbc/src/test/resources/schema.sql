-- [이 파일의 역할과 이유]
-- @SpringBootTest를 사용한 통합 테스트는 매번 새로운 내장 메모리 DB를 생성합니다.
-- 이 DB는 완전히 비어있으므로, 테스트에 필요한 테이블이 존재하지 않습니다.
--
-- 스프링 부트는 테스트 실행 시 `src/test/resources/schema.sql` 파일을 발견하면,
-- 자동으로 이 파일을 실행하여 데이터베이스 스키마(테이블 등)를 초기화해줍니다.
-- 따라서 이 파일은 테스트가 실행되기 전에 필요한 테이블을 생성하는 역할을 합니다.

drop table if exists member CASCADE;
create table member (
    member_id varchar(10),
    money integer not null,
    primary key (member_id)
);