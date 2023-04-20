alter table pollution rename column 지역코드 to region_code;
alter table pollution rename column 대분류 to Big_;
alter table pollution rename column 소분류 to Small_;
alter table pollution rename column 주소 to address;
alter table pollution rename column 번호 to id;

alter table pollution rename column region_code to 지역코드;
alter table pollution rename column Big_ to 대분류;
alter table pollution rename column Small_ to 소분류;
alter table pollution rename column address to 주소;
alter table pollution rename column id to 번호;

select * from pollution;

-- 영업장수 순으로 조회하는것
select region_code, address, Big_, Small_, count(region_code) as 영업장수 
from pollution
group by region_code, address, Big_, Small_
order by count(region_code) desc
;

-- 영업장수 1위만 조회하는것
select *
from (select region_code, address, Big_, Small_, count(region_code) as 영업장수 
from pollution
group by region_code, address, Big_, Small_
order by count(region_code) desc
)
where ROWNUM = 1;

-- 영업장수 1위지역 인구 조회
select count(address1) as 인구 , count(region_code) as 영업장수, 
trim(substr(address1,1, instr(address1,' ', '1' , '1'))) as 대분류,
substr(address1,instr(address1,' ', '1' , '1')+1, instr(address1,' ', '1' , '1')) as 소분류
from customer, 
(select *
from (select region_code, address, Big_, Small_, count(region_code) as 영업장수 
from pollution
group by region_code, address, Big_, Small_
order by count(region_code) desc
)where ROWNUM = 1
)
GROUP BY 
trim(substr(address1,1, instr(address1,' ', '1' , '1'))),
substr(address1,instr(address1,' ', '1' , '1')+1, instr(address1,' ', '1' , '1'))
;
-- 영업장수 1위 지역 customer 조회
select id, name, address1, 
mobile_no, credit_limit, email, account_mgr, birth_dt, gender
from customer
where address1 
like '%'||
(select Small_
from (select region_code, Big_, Small_, count(region_code) as 영업장수 
from pollution
group by region_code, address, Big_, Small_
order by count(region_code) desc
)
where ROWNUM = 1)
||'%'
;

select region_code, Big_, Small_, count(region_code) as 영업장수 
from pollution
group by region_code, address, Big_, Small_
order by count(region_code) desc;

