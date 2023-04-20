insert into member (rent_status, name, join_date, address, contact, birthday, age) VALUES ('대출가능', '김찰스', TO_CHAR(sysdate, 'YYYY-MM-DD'), '서울시 강남구 역삼동 123-4', '010-5492-5678', TO_CHAR('1990-01-01', 'YYYY-MM-DD'), TRUNC((SYSDATE - TO_DATE('" + 1990-01-01 + "', 'YYYY-MM-DD')) / 365.25));

select To_date(To_char(sysdate, 'YYYY-MM-DD')) from dual;