create table tbl_reply (
  reply_no number,
  board_no number not null,
  reply    varchar2(500) not null,
  replyer  varchar2(10) not null,
  reply_date date default sysdate
);
create sequence reply_seq;
alter table tbl_reply add constraint pk_reply primary key (reply_no);

create table tbl_member (
 member_id varchar2(100) primary key,
 member_pw varchar2(100) not null,
 member_name varchar2(50) not null,
 responsibility varchar2(10) default 'User' not null
);

create table tbl_board (
 board_no number,
 title varchar2(100) not null,
 content varchar2(1000) not null,
 writer varchar2(50) not null,
 view_cnt number default 0,
 creation_date date default sysdate,
 last_update_date date default sysdate,
 image varchar2(100));




