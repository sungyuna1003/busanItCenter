create table member(
    idx number primary key,-- �ڵ����� ����
    id varchar2(200) not null,--id
    name varchar2(200) not null,--�г���
    email varchar2(200) not null,--�̸���
    birth varchar2(200) not null,--�������
    password varchar2(200) not null,--��й�ȣ
    gender varchar2(200) not null,--����
    phone varchar2(200) not null,--�ڵ�����ȣ
    img varchar2(4000) not null--�̹��� ����
);

create sequence seqdesign;

-- ������ table- idx, �ּ�, �������, ������ ��ȭ��ȣ
create table trvl(
 tidx number primary key,
 place varchar2(200) not null,
 address varchar2(200) not null,
 pnumber varchar2(200) not null
);


-- ��- �����ڵ�,idx, �Ⱓ, ��¥ ,���� ����, ��� ����,�������,��� �ο���
create table design(
 dcode number primary key,
 idx number,
 period varchar2(200) not null,
 ddate varchar2(200) not null,--1��2��
 area varchar2(200) not null,
 dage varchar2(200) not null,
 gender varchar2(200) not null,
 nump varchar2(200) not null,
constraint fk_id foreign key(idx)
references member(idx)
);


--��-idx, �����ڵ�, ��¥ ,������-idx
create table mdesign(
 didx number primary key,
 dcode number,
 tidx number,
constraint fk_tidx foreign key(tidx)
references trvl(tidx),
constraint fk_dcode foreign key(dcode)
references design(dcode)
);


--������,��û table- ȸ��id, �����ڵ�(����),�ڱ�Ұ��� ����
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

-- ��� table ,�۹�ȣ , ȸ��idx , ����ۼ� ��¥, ����
create table Comments(
widx number primary key,
idx number,
wdate varchar2(200) not null,--sysdate
ctent varchar2(200) not null
);

ALTER TABLE comments
ADD FOREIGN KEY (idx) REFERENCES Member(idx);


--���� table -������ȣ,�޴»�� ���̵�, ������� ���̵�, ���� ����, ��������,������¥,�б� Ȯ��
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
