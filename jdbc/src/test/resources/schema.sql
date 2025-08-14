drop table if exists member CASCADE;
create table member (
    member_id varchar(10),
    money integer not null,
    primary key (member_id)
);