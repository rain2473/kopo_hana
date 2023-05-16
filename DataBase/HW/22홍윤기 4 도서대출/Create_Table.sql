REM  ***********************************************************************************************************
REM  SCRIPT 용도 : 도서 정보를 저장하는 테이블 생성
REM  작성자      : 홍윤기
REM  작성일      : 2023-04-15
REM  수정사항    : 23/04/15  최초생성
REM  ***********************************************************************************************************

drop SEQUENCE book_seq;
CREATE SEQUENCE book_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

alter table rent drop constraint fk_rent_book_id;
drop table book;
CREATE TABLE BOOK (
  book_id VARCHAR2(20) DEFAULT 'BID' || LPAD(book_seq.NEXTVAL, 16, '0') CONSTRAINT pk_book_id PRIMARY KEY,
  rental_status VARCHAR2(20) CONSTRAINT nn_book_rental_status NOT NULL,
  name VARCHAR2(100) CONSTRAINT nn_book_name NOT NULL,
  store_date DATE DEFAULT TO_CHAR(SYSDATE, 'YYYY/MM/DD')  CONSTRAINT nn_book_store_date NOT NULL,
  author VARCHAR2(100), 
  publisher VARCHAR2(100), 
  publishing_date DATE, 
  price NUMBER
);

ALTER TABLE book ADD CONSTRAINT ck_book_rental_status CHECK (trim(rental_status) IN ('대출가능', '대출중'));

drop SEQUENCE member_seq;
CREATE SEQUENCE member_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

alter table rent drop constraint fk_rent_member_id;
drop table member;
CREATE TABLE Member (
  member_id VARCHAR2(20) DEFAULT 'MID' || LPAD(member_seq.NEXTVAL, 16, '0') CONSTRAINT pk_member_id PRIMARY KEY,
  rent_status VARCHAR2(20) CONSTRAINT nn_member_rent_status NOT NULL,
  name VARCHAR2(100) CONSTRAINT nn_member_name NOT NULL,
  join_date DATE DEFAULT TO_CHAR(SYSDATE, 'YYYY/MM/DD') CONSTRAINT nn_member_join_date NOT NULL,
  address VARCHAR2(100), 
  contact VARCHAR2(15) CONSTRAINT uk_member_contact UNIQUE,
  birthday DATE, 
  age NUMBER
);

ALTER TABLE member ADD CONSTRAINT ck_member_rent_status CHECK (trim(rent_status) IN ('대출가능', '대출중'));
ALTER TABLE member ADD CONSTRAINT ck_member_contact CHECK (REGEXP_LIKE(contact, '^\d{3}-\d{4}-\d{4}$'));

drop table resign;
CREATE TABLE resign (
  member_id VARCHAR2(20) CONSTRAINT pk_resign_member_id PRIMARY KEY,
  rent_status VARCHAR2(20) CONSTRAINT nn_resign_member_rent_status NOT NULL,
  name VARCHAR2(100) CONSTRAINT nn_resign_member_name NOT NULL,
  join_date DATE DEFAULT TO_CHAR(SYSDATE, 'YYYY/MM/DD') CONSTRAINT nn_resign_member_join_date NOT NULL,
  address VARCHAR2(100), 
  contact VARCHAR2(15) CONSTRAINT uk_resign_member_contact UNIQUE,
  birthday DATE, 
  age NUMBER
);

ALTER TABLE resign ADD CONSTRAINT ck_resign_member_rent_status CHECK (trim(rent_status) = '대출가능');
ALTER TABLE resign ADD CONSTRAINT ck_resign_member_contact CHECK (REGEXP_LIKE(contact, '^\d{3}-\d{4}-\d{4}$'));

drop SEQUENCE rent_seq;
CREATE SEQUENCE rent_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

drop table rent;
CREATE TABLE RENT (
  Rental_id VARCHAR2(20) DEFAULT 'RID' || LPAD(rent_seq.NEXTVAL, 16, '0') CONSTRAINT pk_rent_rentalId PRIMARY KEY,
  book_id VARCHAR2(20) CONSTRAINT nn_rent_bookId NOT NULL,
  member_id VARCHAR2(20) CONSTRAINT nn_rent_memberId NOT NULL,
  extension VARCHAR2(20) CONSTRAINT nn_rent_extension NOT NULL,
  rentalDate DATE DEFAULT TO_CHAR(SYSDATE, 'YYYY/MM/DD') CONSTRAINT nn_rent_rental_date NOT NULL,
  returnDate DATE, 
  remainDays NUMBER
);
ALTER TABLE rent ADD CONSTRAINT uk_rent_bIdmId UNIQUE (book_id, member_id);
ALTER TABLE rent ADD CONSTRAINT ck_rent_extension CHECK (trim(extension) IN ('연장완료', '연장가능'));
ALTER TABLE rent ADD CONSTRAINT fk_rent_book_id FOREIGN KEY (book_id) REFERENCES book (book_id);
ALTER TABLE rent ADD CONSTRAINT fk_rent_member_id FOREIGN KEY (member_id) REFERENCES member (member_id);


-------------------------------------------------예시 데이터 삽입---------------------------------------------------------
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', 'Java의 정석', '남궁성', '도우출판사', to_date('2021-07-01', 'YYYY-MM-DD'), 30000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', '파이썬 라이브러리를 활용한 데이터 분석', '웨스 맥키니', '한빛미디어', to_date('2019-09-10', 'YYYY-MM-DD'), 35000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', 'Effective Java', 'Joshua Bloch', 'Addison-Wesley Professional', to_date('2018-01-01', 'YYYY-MM-DD'), 40000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', '자바 성능 튜닝 이야기', '김민수', '위키북스', to_date('2017-12-01', 'YYYY-MM-DD'), 28000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '데이터베이스 개론', '안티 헤로츠', '한빛아카데미', to_date('2021-03-01', 'YYYY-MM-DD'), 25000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', 'Head First Design Patterns', '에릭 프리먼', '한빛미디어', to_date('2019-03-20', 'YYYY-MM-DD'), 32000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', 'Effective Python', 'Brett Slatkin', 'Addison-Wesley Professional', to_date('2020-02-15', 'YYYY-MM-DD'), 35000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '트랜드 코리아 2023', '김민우', '트랜드비젼', to_date('2022-11-01', 'YYYY-MM-DD'), 27000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', '이펙티브 파이썬', 'Brett Slatkin', '인사이트', to_date('2016-12-20', 'YYYY-MM-DD'), 28000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', 'SQL 첫걸음', '아사이 아츠시', '한빛미디어', to_date('2022-01-01', 'YYYY-MM-DD'), 28000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '노인과 바다', '어니스트 헤밍웨이', '영우출판사', to_date('1990-05-01', 'YYYY-MM-DD'), 12000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', '1984', '조지 오웰', '인플루엔셜', to_date('2016-01-25', 'YYYY-MM-DD'), 14000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '마인드풀니스', '마크 윌리엄스', '다산북스', to_date('2015-12-01', 'YYYY-MM-DD'), 18000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '시선으로부터', '이창근', '문학동네', to_date('2022-03-05', 'YYYY-MM-DD'), 14000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '파이썬 머신러닝 완벽 가이드', '권철민', '위키북스', to_date('2019-09-10', 'YYYY-MM-DD'), 38000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '코스모스', '칼 세이건', '사이언스북스', to_date('2018-07-01', 'YYYY-MM-DD'), 24000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', '해리 포터와 마법사의 돌', 'J.K. 롤링', '문학수첩', to_date('2000-11-06', 'YYYY-MM-DD'), 16000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '행복한 여행', '김영하', '문학동네', to_date('2020-06-22', 'YYYY-MM-DD'), 14000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '인생은 소설이다', '김영하', '창비', to_date('2015-05-13', 'YYYY-MM-DD'), 15000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', '미움받을 용기', '기시미 이치로', '갤리온', to_date('2013-12-05', 'YYYY-MM-DD'), 14000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '아리랑', '조정래', '민음사', to_date('2018-10-22', 'YYYY-MM-DD'), 15000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출중', '소년이 온다', '한강', '문학동네', to_date('2021-09-20', 'YYYY-MM-DD'), 16000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '코어 자바스크립트', '정재남', '위키북스', to_date('2020-07-10', 'YYYY-MM-DD'), 45000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '하이큐!!', '후루다테 하루이치', '대원씨아이', to_date('2013-03-02', 'YYYY-MM-DD'), 6000);
INSERT INTO BOOK (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '나미야 잡화점의 기적', '히가시노 게이고', ' 현대문학', to_date('2012-02-01', 'YYYY-MM-DD'), 14000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '객체지향 사실과 오해', '조영호', '우아한형제들', to_date('2017-07-01', 'YYYY-MM-DD'), 27000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', 'Clean Code', '로버트 C. 마틴', '인사이트', to_date('2021-01-01', 'YYYY-MM-DD'), 32000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '모던 웹을 위한 JavaScript + jQuery 입문', '윤인성', '한빛미디어', to_date('2016-06-01', 'YYYY-MM-DD'), 25000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', 'Do it! 자바 프로그래밍 입문', '박은종', '이지스퍼블리싱', to_date('2020-08-01', 'YYYY-MM-DD'), 28000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '코어 자바스크립트', '김영보', '한빛미디어', to_date('2018-07-01', 'YYYY-MM-DD'), 35000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '코딩 인터뷰 완전 분석', '게일 라크만 맥도웰', '인사이트', to_date('2019-01-01', 'YYYY-MM-DD'), 29000);
INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', 'Head First Design Patterns', '에릭 프리먼', '한빛미디어', to_date('2018-06-01', 'YYYY-MM-DD'), 32000);

INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '김영수', TO_DATE('2022-08-15', 'YYYY-MM-DD'), '서울시 강남구 역삼동 123-4', '010-1234-5678', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 32);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '박민지', TO_DATE('2022-08-16', 'YYYY-MM-DD'), '서울시 송파구 잠실동 123-4', '010-2345-6789', TO_DATE('1995-05-01', 'YYYY-MM-DD'), 27);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '이동휘', TO_DATE('2022-08-17', 'YYYY-MM-DD'), '경기도 성남시 분당구 정자동 123-4', '010-3456-7890', TO_DATE('1998-10-01', 'YYYY-MM-DD'), 23);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '박서준', TO_DATE('2022-08-18', 'YYYY-MM-DD'), '서울시 강서구 화곡동 123-4', '010-4567-8901', TO_DATE('1988-06-01', 'YYYY-MM-DD'), 34);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '임영웅', TO_DATE('2022-08-19', 'YYYY-MM-DD'), '경기도 용인시 기흥구 동백동 123-4', '010-5678-9012', TO_DATE('1992-03-01', 'YYYY-MM-DD'), 30);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '손흥민', TO_DATE('2022-08-20', 'YYYY-MM-DD'), '서울시 마포구 동교동 123-4', '010-6789-0123', TO_DATE('1992-07-08', 'YYYY-MM-DD'), 29);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '강동원', TO_DATE('2022-08-21', 'YYYY-MM-DD'), '서울시 강남구 청담동 123-4', '010-7890-1234', TO_DATE('1981-01-18', 'YYYY-MM-DD'), 42);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '김지수', TO_DATE('2021-01-01', 'YYYY-MM-DD'), '서울시 강남구', '010-1534-5378', TO_DATE('1990-01-01', 'YYYY-MM-DD'), 33);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '박민주', TO_DATE('2021-01-02', 'YYYY-MM-DD'), '서울시 강동구', '010-2385-6739', TO_DATE('1995-03-15', 'YYYY-MM-DD'), 28);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '이승민', TO_DATE('2021-01-03', 'YYYY-MM-DD'), '서울시 강서구', '010-3455-7800', TO_DATE('2000-06-01', 'YYYY-MM-DD'), 21);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '장은정', TO_DATE('2021-01-04', 'YYYY-MM-DD'), '서울시 관악구', '010-4467-8901', TO_DATE('1985-12-31', 'YYYY-MM-DD'), 36);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '홍길동', TO_DATE('2021-01-05', 'YYYY-MM-DD'), '서울시 광진구', '010-5678-9013', TO_DATE('1992-09-18', 'YYYY-MM-DD'), 29);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '최지영', TO_DATE('2021-01-06', 'YYYY-MM-DD'), '서울시 구로구', '010-6789-0423', TO_DATE('2002-07-12', 'YYYY-MM-DD'), 19);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '김수빈', TO_DATE('2021-01-07', 'YYYY-MM-DD'), '서울시 노원구', '010-7890-1734', TO_DATE('1997-11-23', 'YYYY-MM-DD'), 26);
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '박지현', TO_DATE('2021-01-08', 'YYYY-MM-DD'), '서울시 도봉구', '010-8911-2345', TO_DATE('1989-05-05', 'YYYY-MM-DD'), 32);
INSERT INTO member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '김철수', TO_DATE('2022/03/15', 'yyyy/mm/dd'), '서울시 강남구 역삼동 123-1', '010-5234-5678', TO_DATE('1995/01/01', 'yyyy/mm/dd'), 28);
INSERT INTO member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '박영희', TO_DATE('2021/05/25', 'yyyy/mm/dd'), '서울시 관악구 신림동 321-3', '010-5678-1234', TO_DATE('1998/10/10', 'yyyy/mm/dd'), 25);
INSERT INTO member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '이수현', TO_DATE('2021/08/12', 'yyyy/mm/dd'), '서울시 강서구 화곡동 564-7', '010-9876-5432', TO_DATE('2000/05/20', 'yyyy/mm/dd'), 21);
INSERT INTO member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '홍길동', TO_DATE('2022/01/10', 'yyyy/mm/dd'), '서울시 종로구 효자동 87-4', '010-2222-3333', TO_DATE('1992/07/15', 'yyyy/mm/dd'), 31);
INSERT INTO member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '신영숙', TO_DATE('2023/02/01', 'yyyy/mm/dd'), '서울시 동대문구 장안동 456-8', '010-1111-2222', TO_DATE('1996/11/22', 'yyyy/mm/dd'), 27);
INSERT INTO member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '장미영', TO_DATE('2021/12/05', 'yyyy/mm/dd'), '서울시 강동구 성내동 432-1', '010-4444-5555', TO_DATE('1985/04/30', 'yyyy/mm/dd'), 38);
INSERT INTO member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '김민준', TO_DATE('2022/06/30', 'yyyy/mm/dd'), '서울시 송파구 잠실동 789-2', '010-7777-8888', TO_DATE('1994/09/14', 'yyyy/mm/dd'), 29);
commit;