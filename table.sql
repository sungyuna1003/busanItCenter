create table member(
    idx number primary key,-- 자동증가 숫자
    id varchar2(200) not null,--id
    name varchar2(200) not null,--닉네임
    email varchar2(200) not null,--이메일
    birth varchar2(200) not null,--생년월일
    password varchar2(200) not null,--비밀번호
    gender varchar2(200) not null,--성별
    phone varchar2(200) not null,--핸드폰번호
    img varchar2(4000) not null--이미지 저장
);

create sequence seqdesign;

-- 여행지 table- idx, 주소, 여행장소, 여행지 전화번호
create table trvl(
 tidx number primary key,
 place varchar2(200) not null,
 address varchar2(200) not null,
 pnumber varchar2(200) not null
);


-- 대- 여행코드,idx, 기간, 날짜 ,구별 선택, 희망 연령,희망성별,희망 인원수
create table design(
 dcode number primary key,
 idx number,
 period varchar2(200) not null,
 ddate varchar2(200) not null,--1박2일
 area varchar2(200) not null,
 dage varchar2(200) not null,
 gender varchar2(200) not null,
 nump varchar2(200) not null,
constraint fk_id foreign key(idx)
references member(idx)
);


--중-idx, 여행코드, 날짜 ,여행지-idx
create table mdesign(
 didx number primary key,
 dcode number,
 tidx number,
constraint fk_tidx foreign key(tidx)
references trvl(tidx),
constraint fk_dcode foreign key(dcode)
references design(dcode)
);


--동행자,신청 table- 회원id, 여행코드(복합),자기소개글 내용
create table meet(
idx number,
dcode number,
mtent varchar2(400) not null,
primary key(idx,dcode)
);

ALTER TABLE meet
ADD FOREIGN KEY (idx) REFERENCES Member(idx);

ALTER TABLE meet
ADD FOREIGN KEY (dcode) REFERENCES design(dcode);

-- 댓글 table ,글번호 , 회원idx , 댓글작성 날짜, 내용
create table Comments(
widx number primary key,
idx number,
wdate varchar2(200) not null,--sysdate
ctent varchar2(200) not null
);

ALTER TABLE comments
ADD FOREIGN KEY (idx) REFERENCES Member(idx);


--쪽지 table -쪽지번호,받는사람 아이디, 보낸사람 아이디, 쪽지 제목, 쪽지내용,보낸날짜,읽기 확인
create table notes (
no  number primary key,
idx number,
rid  varchar2(200),
sid  varchar2(200),
title varchar2(255) not null,
ntent varchar2(255) not null, 
ndate date,
modea char(1)
);

ALTER TABLE notes
ADD FOREIGN KEY (idx) REFERENCES member(idx);



create table travel(  
UC_SEQ number primary key,
MAIN_TITLE varchar2(400) not null,
GUGUN_NM varchar2(400) not null,
LAT dECIMAL(8,6) not null,
LNG dECIMAL(8,5) not null,
GRIDX NUMBER NOT NULL,
GRIDY NUMBER NOT NULL,
PLACE varchar2(400) not null,
TITLE	varchar2(400) not null,
SUBTITLE	varchar2(400) not null,
ADDR1	varchar2(400) not null,
CNTCT_TEL	varchar2(400) not null,
HOMEPAGE_URL	varchar2(400) not null,
TRFC_INFO	varchar2(600) not null,
USAGE_DAY	varchar2(400) not null,
HLDY_INFO	varchar2(400) not null,
USAGE_DAY_WEEK_AND_TIME	varchar2(400) not null,
USAGE_AMOUNT	varchar2(400) not null,
MIDDLE_SIZE_RM1	varchar2(400) not null,
MAIN_IMG_NORMAL	varchar2(400) not null,
MAIN_IMG_THUMB varchar2(400) not null,
ITEMCNTNTS	varchar2(4000) not null
);
