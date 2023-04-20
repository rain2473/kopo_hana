select * from member where MEMBER_ID = 'MID0000000000000007';
select * from book where rental_status = '대출가능' order by publishing_date;
INSERT INTO Member (rent_status, name, join_date, address, contact, birthday, age) 
VALUES ('대출가능', '이름이', TO_DATE(sysdate, 'YYYY-MM-DD'), 
'서울시 강남구 역삼동 123-4', '010-1234-4888', TO_DATE('1980-01-01', 'YYYY-MM-DD'), TRUNC((SYSDATE - TO_DATE('1980-01-01', 'YYYY-MM-DD')) / 365.25));
rollback;

update member set name = '박동원', birthday = '1990/02/23', age = TRUNC((SYSDATE - TO_DATE('1990/02/23', 'YYYY-MM-DD')) / 365.25) where MEMBER_ID = 'MID0000000000000007';

INSERT INTO resign SELECT * FROM member WHERE MEMBER_ID = 'MID0000000000000007';

select * from member;

select book_id, member_id, extension, rentaldate, returndate, remaindays from rent;

select * from rent;
select j.rental_id, j.BOOK_NAME, m.name as MEMBER_NAME, j.EXTENSION, j.RENTALDATE,j.RETURNDATE,j.REMAINDAYS
from 
(select r.*, b.name as BOOK_NAME
from rent r, book b
where r.book_id = b.book_id) j, member m
where j.member_id = m.member_id
order by member_name;

SELECT * FROM book  WHERE book_id = 'BID0000000000000016';

DELETE FROM rent WHERE rental_id = 'RID0000000000000004';

INSERT INTO member SELECT * FROM resign;

select book_id from book where name = '클린 코드';
select member_id from member where name = '박동원';

select extension from rent where book_id = 'BID0000000000000027' and member_id = 'MID0000000000000007';

INSERT INTO rent (book_id, member_id, extension, rentaldate, returndate, remaindays) 
VALUES ('BID0000000000000016', 'MID0000000000000007',
'연장가능', TO_DATE(sysdate, 'YYYY-MM-DD'), to_date(sysdate + 14, 'YYYY-MM-DD'), 14);

update rent set extension = '연장가', returndate능 = to_date(sysdate + 14, 'YYYY-MM-DD'), remaindays = 14 where rental_id = 'RID0000000000000004';

update member set rent_status = '대출중' where member_id = 'MID0000000000000007';
update book set rental_status = '대출중' where book_id = 'BID0000000000000016';

Book book = booklist.findById(BookId);
Member member = memberList.findById(memberId);
book.setRentalStatus(true);
member.setRentStatus(true);