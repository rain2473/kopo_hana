-----------------------------------example--------------------------------------
SELECT * FROM emp;
SELECT * FROM customer;

DELETE FROM emp WHERE deptno = 10;

DELETE form customer WHERE ROWNUM <= 10;

ROLLBACK;

SELECT * FROM tab;

DESC emp;

SELECT * FROM emp;

DESC emp;

SELECT * FROM dept;
-------------------------------------DESC---------------------------------------
desc emp;
desc dept;
------------------------------------SELECT--------------------------------------
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp;

SELECT * FROM emp;

SELECT empno, ename, hiredate
FROM emp;

SELECT sal, job, empno, ename
FROM emp;

SELECT empno, empno, empno, ename, job, sal
FROM emp;

SELECT empno, sal, 2022, 'HAPPY NEW YEAR'
FROM emp;
-------------------------------------����---------------------------------------
SELECT ename, sal, sal * 12, hiredate, hiredate - 7, hiredate + 100
FROM emp;

SELECT sal, sal + 300 * 12, (sal + 300 ) * 12
FROM emp;

SELECT ename, comm, comm + 300
FROM emp;

SELECT ename, sal + 12, sal * 12 AS annual_salary
FROM emp;

SELECT ename, mgr manager, sal * 12   AS annual_sal, comm + 300 "Special Bonus"
FROM emp;

SELECT ename, comm + 300 ���ʽ�, comm + 300 AS "Special Bonus"
FROM emp;
----------||���ڿ� ����||----------
SELECT ename || job FROM emp;

SELECT dname || ' �μ��� ' || loc || ' ������ ��ġ�մϴ�.' AS loc
FROM dept;

SELECT ename || '''S JOB IS ' || job AS job_list
FROM emp;

SELECT ename || '"S JOB IS ' || job AS job_list
FROM emp;

SELECT sal, sal * 100, sal || '00', to_char(sal) || '00'
FROM emp; --�߿�
--------------DUAL---------------
desc dual;

SELECT * FROM dual;

SELECT sysdate FROM dual;

SELECT 2025 * 12345, to_char(2025 * 12345, '999,999,999'), 
to_char(2025 * 12345, '999,999,999') AS cal
FROM dual;
--------------WHERE--------------
SELECT * FROM emp WHERE deptno = 10;

SELECT deptno, ename, sal, job
FROM emp
WHERE sal > 2000;

SELECT deptno, ename, sal, job
FROM emp
WHERE deptno = 10 AND sal > 2000;

SELECT deptno, ename, sal, job
FROM emp
WHERE deptno = 10 OR sal > 2000;

SELECT deptno, sal, job
FROM emp
WHERE deptno = 10 AND sal > 2000 OR job = 'MANAGER';

SELECT deptno, sal, job
FROM emp
WHERE (deptno = 10 AND sal > 2000 ) OR job = 'MANAGER';

SELECT deptno, sal, job
FROM emp
WHERE deptno = 10 AND ( sal > 2000 OR job = 'MANAGER' );

SELECT deptno, ename, sal, job
FROM emp
WHERE job = 'MANAGER';

SELECT deptno, ename, job
FROM emp
WHERE 1 = 1; -- TRUE ������ ��� ���
SELECT deptno, ename, job
FROM emp
WHERE 1 = 2; --FALSE ������ ��� ��� ����
SELECT deptno, ename, sal, job
FROM emp
WHERE (deptno, job, mgr) = ((10, 'MANAGER', 7839));
--------------NULL ����----------------
SELECT 300 / 0 FROM dual; -- DIVISORZERO ����
SELECT 300 + 400, 300 + NULL, 300 / NULL
FROM dual; -- �׳� NULL�� ��
SELECT ename, sal, comm, comm + sal * 0.3 AS bonus
FROM emp; -- �׳� NULL�� ��
--------------NULL ��----------------
SELECT ename, sal, comm
FROM emp
WHERE comm > - 1;

SELECT ename, sal, comm
FROM emp
WHERE comm = NULL;

SELECT ename, sal, comm
FROM emp
WHERE comm <> NULL;

SELECT ename, sal, comm
FROM emp
WHERE comm IS NULL;

SELECT ename, sal, comm
FROM emp
WHERE comm IS NOT NULL;
--------------NULL ����----------------
SELECT ename, length(ename), comm, length(comm)
FROM emp; --LENGTH�� ���ڿ� ����
SELECT sal, comm, abs(sal - comm) + 300
FROM emp;

SELECT comm, nvl(comm, 0), decode(comm, NULL, 0, comm) AS nvl_simul
FROM emp;

SELECT concat('Commission is ', comm), 'Commission is ' || comm
FROM emp; -- NULL ����
SELECT COUNT(sal)  AS sal_cnt, COUNT(comm) AS comm_cnt, SUM(comm) AS comm_sum
FROM emp;
---------------����--------------
SELECT empno || ',' || ename || ',' || job || ',' || sal || ',' || deptno AS "TO CSV"
FROM emp;

SELECT to_char(systimestamp, 'YYYY.MM.DD HH24:MI:SS.FF2')
FROM dual;

SELECT to_char(systimestamp, 'YYYY.MM.DD HH24:MI:SS.FF3')
FROM dual;

----------------03.31-----------------
----------------Order By--------------
SELECT ename, hiredate, sal, comm
FROM emp
ORDER BY ename;

SELECT ename, hiredate, sal, comm
FROM emp
ORDER BY ename ASC;

SELECT ename, hiredate, sal, comm
FROM emp
ORDER BY hiredate DESC;

SELECT ename, hiredate, sal, comm
FROM emp
ORDER BY ename;

SELECT ename, hiredate, sal, comm
FROM emp
ORDER BY 2;

SELECT ename, sal * 12 AS ����
FROM emp
ORDER BY ����;

SELECT ename, hiredate, sal, comm
FROM emp
ORDER BY comm * 12;

SELECT ename, hiredate, sal, comm
FROM emp
ORDER BY comm * 12 NULLS FIRST;

SELECT deptno, job, ename
FROM emp
ORDER BY deptno;

SELECT deptno, job, ename
FROM emp
ORDER BY deptno, job;

SELECT deptno, job, ename
FROM emp
ORDER BY deptno, job DESC;

SELECT * FROM customer
ORDER BY credit_limit DESC;

SELECT * FROM customer
WHERE name = '������';
----------------DISTINCT---------------------
SELECT job FROM emp;

SELECT UNIQUE job FROM emp;

SELECT DISTINCT job FROM emp;

SELECT DISTINCT deptno, job FROM emp;

SELECT job FROM emp ORDER BY job;
SELECT DISTINCT JOB, DISTINCT DEPTNO FROM EMP; 
SELECT JOB, DISTINCT DEPTNO FROM EMP;
SELECT COMM FROM EMP WHERE COMM IS NOT NULL; 
SELECT DISTINCT COMM FROM EMP;

SELECT DISTINCT NAME FROM customer;
------------------BETWEEN-----------------
SELECT ENAME,SAL,HIREDATE FROM EMP WHERE SAL between 1000 and 2000; 
SELECT ENAME,SAL,HIREDATE FROM EMP WHERE SAL >= 1000 and SAL <= 2000;
SELECT ENAME,SAL,HIREDATE FROM EMP WHERE SAL between 2000 and 1000;
SELECT ENAME,SAL,HIREDATE FROM EMP WHERE ENAME BETWEEN 'C' AND 'K'; 
SELECT ENAME,SAL,HIREDATE FROM EMP WHERE HIREDATE BETWEEN '81/02/20' AND '82/12/09';
SELECT ENAME,SAL,HIREDATE FROM EMP
WHERE HIREDATE BETWEEN to_date('81/02/20','YY/mm/dd') AND to_date('82/12/09','YY/mm/dd'); 
SELECT ENAME,HIREDATE,
TO_CHAR(HIREDATE,'YYYY/MM/DD'),
TO_CHAR(HIREDATE,'YYYY/MM/DD HH24:MI:SS'),
TO_CHAR(HIREDATE,'RRRR/MM/DD HH24:MI:SS'),
TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS')
FROM EMP; 
SELECT ENAME,SAL,HIREDATE FROM EMP
WHERE HIREDATE BETWEEN to_date('81/02/20��,��rr/mm/dd') AND to_date('82/12/09','yy/mm/dd'); 
SELECT ENAME,SAL,HIREDATE FROM EMP
WHERE HIREDATE BETWEEN to_date('1981/02/20','yyyy/mm/dd') AND to_date('1982/12/09','yyyy/mm/dd'); 
SELECT ENAME,SAL,HIREDATE FROM EMP
WHERE HIREDATE BETWEEN to_date('81/02/20','rr/mm/dd') AND to_date('82/12/09','rr/mm/dd'); 
SELECT ENAME,SAL,HIREDATE FROM EMP
WHERE HIREDATE BETWEEN to_date('2081/02/20','yyyy/mm/dd') AND to_date('2082/12/09','yyyy/mm/dd'); 
--------------------LIKE------------------
SELECT ENAME FROM EMP WHERE ENAME like 'A%';
SELECT ENAME FROM EMP WHERE ENAME like '_A%'; 
SELECT ENAME FROM EMP WHERE ENAME like '%L%E%';
SELECT ENAME FROM EMP WHERE ENAME like '%LE%';
SELECT ENAME FROM EMP WHERE ENAME like '%A%';
SELECT ENAME FROM EMP WHERE ENAME NOT like '%A%';
SELECT ENAME,HIREDATE FROM EMP WHERE HIREDATE like '81%';
SELECT ENAME,SAL FROM EMP WHERE SAL like 2%;
SELECT ENAME,SAL FROM EMP WHERE SAL like '2%';
SELECT ENAME,SAL FROM EMP WHERE TO_CHAR(SAL) like '2%';

SELECT * FROM CUSTOMER WHERE NAME LIKE '��%' AND ADDRESS1 LIKE '%���ǵ�%';
-----------------IN---------------------
SELECT EMPNO, JOB FROM EMP WHERE EMPNO IN (7369,7521,7654);
SELECT EMPNO, JOB FROM EMP WHERE EMPNO = 7369 or EMPNO = 7521 or EMPNO=7654;
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB IN ('clerk','manager'); 
SELECT EMPNO,ENAME,HIREDATE FROM EMP WHERE HIREDATE IN ('81/05/01','81/02/20');
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP 
WHERE (JOB,DEPTNO) in (('MANAGER',20),('CLERK',20)); 
-----------------ANY, ALL----------------------
SELECT ENAME, SAL FROM EMP WHERE SAL > (1500,2450,3000);
SELECT ENAME, SAL FROM EMP WHERE SAL > ANY(1500,2450,3000);
SELECT ENAME, SAL FROM EMP WHERE SAL >= ALL(1500,2450,3000);
SELECT ENAME, SAL FROM EMP WHERE SAL = ANY (1500,2450,3000);
SELECT ENAME, SAL FROM EMP WHERE SAL = SOME (1500,2450,3000);
SELECT ENAME, SAL FROM EMP WHERE SAL IN (1500,2450,3000);
SELECT ENAME, SAL FROM EMP WHERE SAL = ALL (1300,2450,3000);
---------------------����--------------------
SELECT * FROM SALGRADE ;
SELECT * FROM SALGRADE WHERE 3000 BETWEEN LOSAL AND HISAL;
SELECT * FROM EMP;
UPDATE EMP SET ENAME = '_'||ENAME WHERE JOB = 'ANALYST';
SELECT * FROM EMP;
select * from emp where ename like '%\_%' ESCAPE '\';
ROLLBACK;

-----------------------04.03----------------------

--------------------------decode------------------------
SELECT DEPTNO, ENAME, DECODE(DEPTNO,10,'ACCOUNTING',20,'RESEARCH',30,'SALES','ETC')
FROM EMP 
ORDER BY DEPTNO;
SELECT COMM, DECODE(COMM,NULL,0,COMM) FROM EMP;
SELECT GREATEST(3000,1500,2100,5000),LEAST(3000,1500,2100,5000) FROM DUAL ;
SELECT DEPTNO, ENAME, SAL, 
DECODE(GREATEST(SAL,4800),SAL,'HIGH',DECODE(GREATEST(SAL,3000),SAL,'MID','LOW'))
FROM emp
ORDER BY DEPTNO;
--------------------------case-------------------------
SELECT DEPTNO,ENAME, -- Simple case
CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
WHEN 20 THEN 'RESEARCH'
WHEN 30 THEN 'SALES'
ELSE 'ETC' 
END AS DEPARTMENT 
FROM EMP
ORDER BY DEPTNO;
SELECT DEPTNO, ENAME, SAL,
CASE WHEN SAL >= 4800 THEN 'HIGH'
WHEN SAL BETWEEN 3000 AND 4799 THEN 'MID'
WHEN SAL >= 1000 AND SAL <=2999 THEN 'LOW'
ELSE 'Passion pay'
END SAL_GRADE
FROM EMP
ORDER BY DEPTNO;
SELECT DEPTNO, ENAME, COMM,
CASE WHEN COMM >= 1000 THEN 'Great'
WHEN COMM >= 500 THEN 'Good'
WHEN COMM >= 0 THEN 'Bad'
ELSE 'Dreadful'
END COMM_GRADE
FROM EMP
ORDER BY DEPTNO;
SELECT SAL, CASE 
WHEN SAL >= 1000 THEN 1 
WHEN SAL >= 2000 THEN 2
WHEN SAL >= 3000 THEN 3
WHEN SAL >= 4000 THEN 4
WHEN SAL >= 5000 THEN 5
ELSE 0
END AS SAL_GRADE
FROM EMP
ORDER BY SSELECT SAL, CASE 
WHEN SAL >= 5000 THEN 5 
WHEN SAL >= 4000 THEN 4
WHEN SAL >= 3000 THEN 3
WHEN SAL >= 2000 THEN 2
WHEN SAL >= 1000 THEN 1
ELSE 0
END "Sal Grade"
FROM EMP
ORDER BY SAL;
---------------rownum-----------------------------
SELECT ROWNUM,ENAME,DEPTNO,SAL FROM EMP;
SELECT ROWNUM,ENAME,DEPTNO,SAL FROM EMP ORDER BY DEPTNO,SAL; 
SELECT ROWNUM,ENAME,DEPTNO,SAL FROM EMP WHERE DEPTNO IN (10,20) ORDER BY DEPTNO,SAL;
SELECT ENAPTNO,SAL FROM EMP WHERE ROWNUM = 1;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM = 3;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM > 3;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM <= 3;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM < 3;
--------------------------and / or--------------------------
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 AND SAL > 2000;
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 OR SAL > 2000;
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL > 2000 OR SAL > 2000;
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP 
WHERE DEPTNO = 10 AND SAL > 2000 OR JOB = 'CLERK'; 
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP
WHERE (DEPTNO = 10 AND SAL > 2000) OR JOB = 'CLERK'; 
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP 
WHERE DEPTNO = 10 AND (SAL > 2000 OR JOB = 'CLERK');
SELECT ENAME,JOB,SAL FROM EMP WHERE JOB != 'CLERK';
SELECT ENAME,JOB,SAL FROM EMP WHERE JOB NOT IN('CLERK','MANAGER');
-------------------------functions------------------------
SELECT ENAME,EMPNO,SAL,COMM FROM EMP;
SELECT ENAME,LOWER(ENAME),UPPER(LOWER(ENAME)),LENGTH(ENAME),
ABS(SAL-EMPNO),COMM 
FROM EMP;
SELECT ENAME,substr(ENAME,1,3) FROM EMP
WHERE HIREDATE between to_date('81/01/01','RR/MM/DD') and to_date('82/12/31','RR/MM/DD')
ORDER BY length(ENAME);
SELECT AVG(SAL),SUM(SAL),SUM(COMM),COUNT(*) FROM EMP;
SELECT DEPTNO,COUNT(*),SUM(SAL),AVG(SAL) FROM EMP 
GROUP BY DEPTNO;
SELECT DEPTNO,JOB,COUNT(*),SUM(SAL),AVG(SAL) FROM EMP
GROUP BY DEPTNO,JOB
ORDER BY DEPTNO,JOB;
-----------------------functions-singlerow-----------------------
SELECT ENAME, lower(ENAME) ,upper(ENAME), initcap(ENAME) FROM EMP;
SELECT ENAME, substr(ENAME,1,3), substr(ENAME,4), substr(ENAME,-3,2) FROM EMP;
SELECT ENAME, instr(ENAME,'A'), instr(ENAME,'A',2), instr(ENAME,'A',1,2) FROM EMP;
SELECT ENAME, rpad(ENAME,10,' '),rpad(ENAME,10), rpad(ENAME,10,'*'),lpad(ENAME,10,'*+') FROM EMP; 
SELECT length(rpad('X',1000,'X')), rpad('X',1000,'X') FROM DUAL;
SELECT length(rpad('Xsdf',10,'X')), rpad('Xsdf',10,'X') FROM DUAL;
SELECT ENAME, REPLACE(ENAME,'S','s') FROM EMP;
SELECT ENAME, concat(ENAME,JOB), ENAME||JOB FROM EMP;
SELECT ltrim(' ���ѹα� '), rtrim(' ���ѹα� '),trim(' ' from ' ���ѹα� '), trim('*' from '**���ѹα�**') FROM dual;
SELECT trim('��' from '�����'), ltrim('�����','��'), rtrim('�����','��') FROM dual;
SELECT length('abcd'), substr('abcd',2,2), length('���ѹα�'), substr('���ѹα�',2,2) FROM dual;
SELECT lengthb('abcd'),lengthb('���ѹα�'),substr('���ѹα�',2,2),substrb('���ѹα�',2,2) FROM dual;
SELECT length('abcd'), vsize('abcd'), length('���ѹα�'), vsize('���ѹα�') FROM dual;
SELECT ASCII('A'), ASCII('a') FROM dual;
SELECT CHR(65), CHR(97) FROM DUAL;
SELECT 'Hellow'||CHR(10)||'World' FROM DUAL;
SELECT job, TRANSLATE(job,'CL','ab'),TRANSLATE(job,'CL','a'),replace(job,'CL','ab') FROM EMP;
SELECT job, TRANSLATE(job,'!ABC','!'),TRANSLATE(job,'ABC',' ') FROM EMP;
---------------------------------------------------------------------------
SELECT round(45.923,2), round(45.923,1), round(45.923,0), round(45.923), round(45.923,-1) FROM dual;
SELECT trunc(45.923,2), trunc(45.923,1), trunc(45.923,0), trunc(45.923), trunc(45.923,-1) FROM dual;
SELECT mod(100,3), mod(100,2) FROM dual;
SELECT ENAME,SAL,SAL*0.053 as tax, round(SAL*0.053,0) as rtax FROM EMP;
SELECT CEIL(-45.594),CEIL(-45.294),CEIL(45.294),
ROUND(-45.594),ROUND(-45.294),ROUND(45.594) FROM DUAL; 
SELECT FLOOR(45.245),FLOOR(-45.245),FLOOR(45.545),FLOOR(-45.545) FROM DUAL;
---------------------------------�����Լ�-----------------------------------
SELECT sign(-999),sign(999) FROM dual;
SELECT 2**3,power(2,3), power(-2,3), power(-2,4) FROM dual; -- ??
variable x number
begin 
    :x := 2**3;
end;
/
print x
---------------------------------과제--------------------------------------
SELECT DEPTNO,JOB,ENAME FROM EMP WHERE  DEPTNO = 20;	
SELECT DEPTNO,JOB,ENAME FROM EMP WHERE  JOB = 'CLERK';
SELECT DEPTNO,JOB,ENAME FROM EMP WHERE  DEPTNO = 20  OR JOB = 'CLERK' ;
SELECT DEPTNO,JOB,ENAME FROM EMP WHERE  (DEPTNO = 20  OR JOB = 'CLERK') ;

SELECT DEPTNO,ENAME,JOB,SAL, 
case when deptno = 10 then round(sal * 0.3) 
when deptno = 20 then round(sal * 0.2) 
when deptno = 30 then round(sal * 0.1)
else round(sal * 0.01)
end as bonus FROM EMP order by deptno asc, bonus desc;

SELECT DEPTNO, ENAME, DECODE(DEPTNO,10,'ACCOUNTING',20,'RESEARCH','ETC') 
FROM EMP 
ORDER BY DEPTNO;
SELECT DEPTNO, ENAME, DECODE(DEPTNO,10,'ACCOUNTING',20,'RESEARCH') 
FROM EMP 
ORDER BY DEPTNO;

SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB IN ('CLERK','MANAGER') and ename like '%S%';

select deptno,job,decode(deptno, 10 ,decode(job,'CLERK','OK','NO'),'NO')
from emp
order by deptno,job;

select deptno,job,decode(
    deptno || job,
    '10' || 'CLERK',
    'OK',
    'NO'
)
from emp
order by deptno,job;

--------------------------------0404------------------------------------

------------------------------date function-----------------------------
SELECT sysdate, sysdate + 7, sysdate - 2, sysdate + 1/24 FROM dual; 
SELECT deptno,ename, trunc(sysdate - hiredate) as work_day
FROM emp
ORDER BY deptno, work_day DESC;
SELECT ename, sysdate, hiredate, to_char(sysdate,'YYYY-MM-DD:HH24:MI:SS'),to_char(hiredate,'YYYY-MM-DD:HH24:MI:SS')
FROM emp;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD:HH24:MI:SS'; 
SELECT ename,sysdate,hiredate FROM emp;
SELECT SYSDATE FROM DUAL;
SELECT HIREDATE,months_between(sysdate,HIREDATE),months_between(HIREDATE,sysdate) FROM EMP;
SELECT sysdate, add_months(sysdate,3), add_months(sysdate,-1) FROM dual;
SELECT sysdate, last_day(sysdate), next_day(sysdate,'일요일'), next_day(sysdate,2) FROM dual;
SELECT sysdate,round(sysdate,'YEAR'),round(sysdate,'MONTH'),round(sysdate,'DAY'),round(sysdate)
FROM dual;
SELECT sysdate,trunc(sysdate,'YEAR'),trunc(sysdate,'MONTH'),trunc(sysdate,'DAY'),trunc(sysdate) FROM dual; 
SELECT to_char(sysdate,'MM"월"DD"일“ ') as mmdd1,
to_char(sysdate,'MM')||'월'||to_char(sysdate,'DD')||'일' as mmdd2 FROM dual;
SELECT EXTRACT(YEAR FROM SYSDATE),EXTRACT(MONTH FROM SYSDATE),EXTRACT(DAY FROM SYSDATE) FROM DUAL;


SELECT SYSDATE, TO_CHAR(SYSDATE,'YEAR'),TO_CHAR(SYSDATE,'Year'), TO_CHAR(SYSDATE,'YYYY'),TO_CHAR(SYSDATE,'YY')
SELECT TO_CHAR(SYSDATE,'MONTH'),TO_CHAR(SYSDATE,'MON'), TO_CHAR(SYSDATE,'Mon'),TO_CHAR(SYSDATE,'mon'),
FROM DUAL;
TO_CHAR(SYSDATE,'MM'),TO_CHAR(SYSDATE,'mm') FROM DUAL;
SELECT SYSDATE,
TO_CHAR(SYSDATE,'DAY'), TO_CHAR(SYSDATE,'Day'),TO_CHAR(SYSDATE,'DY'), TO_CHAR(SYSDATE,'dy'),
TO_CHAR(SYSDATE,'DD'),TO_CHAR(SYSDATE,'dd') FROM DUAL;
SELECT 123456, TO_CHAR(123456,'999999'), LENGTH(TO_CHAR(123456,'999999')), LENGTH(TO_CHAR(123456,'fm999999'))
FROM DUAL;
SELECT 123456, replace(TO_CHAR(-123456,'999999'),' ','*'), LENGTH(replace(TO_CHAR(123456,'999999'),' ','*')), LENGTH(TO_CHAR(123456,'fm999999'))
FROM DUAL;
SELECT 123456, TO_CHAR(123456,'999999'), LENGTH(ltrim(TO_CHAR(123456,'999999'))), LENGTH(TO_CHAR(123456,'fm999999'))
FROM DUAL;
SELECT TO_CHAR(12345*123.45,'999,999.99'),TO_CHAR(12345*123.45,'99,999,999.99') FROM DUAL;
SELECT TO_CHAR(SAL,'$999,999'), REPLACE(TO_CHAR(SAL,'$999,999'),' ','?'), TO_CHAR(SAL,'L999,999'), TO_CHAR(SAL,'999,999L'), TO_CHAR(SAL,'fm999,999L')
FROM EMP;

alter session set nls_territory = 'america';
alter session set nls_date_language= 'american';

SELECT sysdate, to_char(sysdate, 'YEAR'), to_char(sysdate, 'Year'),to_char(sysdate, 'YYYY'),to_char(sysdate, 'YY') FROM dual;

alter session set nls_territory = 'KOREA';
alter session set nls_date_language= 'KOREAN';

SELECT sysdate, to_char(sysdate, 'YEAR'), to_char(sysdate, 'Year'),to_char(sysdate, 'YYYY'),to_char(sysdate, 'YY') FROM dual;

-----------------------------그룹행 함수-----------------------------------
SELECT MIN(ENAME),MAX(ENAME),MIN(SAL),MAX(SAL),MIN(HIREDATE),MAX(HIREDATE) FROM EMP;
SELECT COUNT(*), COUNT(EMPNO), COUNT(MGR), COUNT(COMM) FROM EMP;
desc emp;
SELECT COUNT(JOB),COUNT(ALL JOB),COUNT(DISTINCT JOB),SUM(SAL),SUM(DISTINCT SAL) FROM EMP;
SELECT COUNT(*), count(COMM), SUM(COMM), SUM(COMM)/COUNT(*),AVG(COMM),SUM(COMM)/COUNT(COMM) FROM EMP;
SELECT SAL,COMM FROM EMP;
SELECT SUM(NVL(COMM,0)), SUM(COMM), NVL(SUM(COMM),0) 
FROM EMP;
----------------------------------group by--------------------------------------
SELECT DEPTNO,COUNT(*) FROM da2322.EMP GROUP BY DEPTNO;
SELECT DEPTNO, AVG(SAL) , SUM(SAL) FROM EMP GROUP BY DEPTNO;

SELECT DEPTNO,AVG(SAL) ,SUM(SAL) 
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT DEPTNO, ROUND(AVG(SAL),1) ,SUM(SAL) 
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT COMM,COUNT(*) FROM EMP GROUP BY COMM;
-----------------------------------having---------------------------------------
SELECT DEPTNO,COUNT(*),SUM(SAL),ROUND(AVG(SAL),1) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO,COUNT(*),SUM(SAL),ROUND(AVG(SAL),1) FROM EMP GROUP BY DEPTNO
HAVING SUM(SAL) >= 9000 ;
SELECT DEPTNO,COUNT(*),SUM(SAL),ROUND(AVG(SAL),1) FROM EMP GROUP BY DEPTNO
HAVING DEPTNO in (10,20);
SELECT DEPTNO,ROUND(AVG(SAL),1) ,SUM(SAL) FROM EMP
WHERE DEPTNO IN (10,20)
GROUP BY DEPTNO
HAVING SUM(SAL) >= 9000
ORDER BY DEPTNO DESC;
------------------------------------과제-----------------------------------------
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD:HH24:MI:SS'; 
SELECT EXTRACT(YEAR FROM systimestamp) FROM DUAL;
SELECT EXTRACT(MONTH FROM systimestamp) FROM DUAL;
SELECT EXTRACT(DAY FROM systimestamp) FROM DUAL;
SELECT EXTRACT(HOUR FROM systimestamp) FROM DUAL;
SELECT EXTRACT(MINUTE FROM systimestamp) FROM DUAL;
SELECT EXTRACT(SECOND FROM systimestamp) FROM DUAL;
SELECT EXTRACT(TIMEZONE_HOUR FROM current_timestamp) FROM DUAL;
SELECT EXTRACT(TIMEZONE_MINUTE FROM current_timestamp) FROM DUAL;
SELECT EXTRACT(TIMEZONE_REGION FROM current_timestamp) FROM DUAL;
SELECT EXTRACT(TIMEZONE_ABBR FROM current_timestamp) FROM DUAL;

SELECT TO_CHAR(SYSDATE,'DDD'),TO_CHAR(SYSDATE,'DD'),TO_CHAR(SYSDATE,'D') FROM DUAL;
SELECT LAST_DAY(SYSDATE) FROM DUAL;

SELECT
case when to_char(LAST_DAY(SYSDATE),'d') = 1 then TO_CHAR(LAST_DAY(SYSDATE) - 2,'DD')
when to_char(LAST_DAY(SYSDATE),'d') = 7 then TO_CHAR(LAST_DAY(SYSDATE) - 1,'DD')
else TO_CHAR(SYSDATE - 2,'DD')
end as lastworkdate
FROM dual;

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-RR';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'RR') = '82';

SELECT DEPTNO, MAX(SAL) as 최대급여 , MIN(SAL) as 최소급여
FROM da2322.EMP 
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT TO_CHAR(HIREDATE,'YYYY') as HIREYEAR, MAX(SAL) , MIN(SAL) 
FROM EMP 
GROUP BY TO_CHAR(HIREDATE,'YYYY')
ORDER BY HIREYEAR;

SELECT
max(sum(CASE WHEN DEPTNO = 10 THEN 1 END)) AS "10번부서",
max(sum(CASE WHEN DEPTNO = 20 THEN 1 END)) AS "20번부서",
max(sum(CASE WHEN DEPTNO = 30 THEN 1 END)) AS "30번부서"
FROM EMP 
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT a.* FROM Customer sample(10) a;
SELECT a.* FROM Customer sample(5) seed(5) a;

-----------------------------------0405-----------------------------------------

----------------------------------insert----------------------------------------
INSERT INTO DEPT VALUES(50,'연구소1','서울');
INSERT INTO DEPT(DNAME,LOC) VALUES('중부지점','대구');
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(51,'연구소2','대전');
SELECT * FROM DEPT;
INSERT INTO DEPT VALUES('중부영업점','대구');
INSERT INTO DEPT(DNAME,LOC) VALUES('중부영업점','대구');
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(52, '북부지점',NULL);
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(53, '남부지점','');
INSERT INTO DEPT(DEPTNO,DNAME) VALUES(54,'서부지점');
SELECT DEPTNO,DNAME,NVL(LOC,'미지정지역') AS LOC FROM DEPT; 
COMMIT;
rollback;
------------------------------multitable insert---------------------------------
INSERT ALL
INTO DEPT(DEPTNO,DNAME,LOC) VALUES(55,'Multi','INSERT1') 
INTO DEPT(DEPTNO,DNAME,LOC) VALUES(56,'Multi','INSERT2') 
INTO DEPT(DEPTNO,DNAME,LOC) VALUES(57,'Multi','INSERT3')
SELECT 1 FROM dual;
SELECT * FROM DEPT;

ROLLBACK;
SELECT * FROM DEPT;
-----------------------------Conditional INSERT---------------------------------
CREATE TABLE BONUS_3 AS SELECT * FROM BONUS WHERE 1=2; 
DESC BONUS_2
SELECT * FROM BONUS_2;
SELECT * FROM BONUS_3;

INSERT ALL
WHEN COMM > 0 THEN INTO BONUS
WHEN COMM IS NULL THEN INTO BONUS_2
SELECT ename,job,sal,comm FROM emp WHERE job IN ('CLERK','SALESMAN'); 
SELECT * FROM bonus;
SELECT * FROM bonus_2; 
ROLLBACK;
----------------------------------update----------------------------------------
UPDATE DEPT SET DNAME = ' M연구소' WHERE DEPTNO = 50;
UPDATE DEPT SET DNAME = ' T연구소', LOC='인천' WHERE DEPTNO = 51;
SELECT * FROM DEPT WHERE DEPTNO IN (50,51); 
COMMIT;
UPDATE DEPT SET LOC='미개척지';
SELECT * FROM DEPT;
ROLLBACK;
SELECT * FROM DEPT;
select dname, replace(dname,' ','*') from dept; 
update dept set dname=trim(dname);
select dname, replace(dname,' ','*') from dept;
commit;
----------------------------------delete----------------------------------------
DELETE FROM DEPT WHERE LOC IS NULL or DEPTNO IS NULL;
SELECT * FROM DEPT; 
commit;

DELETE DEPT;
SELECT * FROM DEPT;

ROLLBACK;
SELECT * FROM DEPT;

DELETE FROM DEPT WHERE DEPTNO >= 50;

----------------------------------0406------------------------------------------
-------------------------------Transaction--------------------------------------
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(90,'신사업부','경기도');
UPDATE EMP SET DEPTNO = 90 WHERE DEPTNO = 30;
DELETE FROM DEPT WHERE DEPTNO = 30;
SELECT * FROM DEPT;
SELECT * FROM EMP WHERE DEPTNO = 30;
ROLLBACK;
SELECT * FROM DEPT; 
SELECT * FROM EMP;

INSERT INTO EMP(EMPNO,ENAME,JOB,SAL)VALUES (1111,'ORACLE','DBA',3500);
UPDATE EMP SET SAL = SAL* 1.3 WHERE EMPNO= 1111;
COMMIT;
ROLLBACK;
SELECT * FROM EMP;

desc EMP;

ROLLBACK;
DELETE FROM EMP WHERE EMPNO = 1111;
UPDATE EMP SET SAL = 123456789 WHERE EMPNO = 7788;
UPDATE EMP SET SAL = 1234 WHERE EMPNO = 7902;
COMMIT;
SELECT EMPNO,SAL FROM EMP WHERE EMPNO IN (1111,7788,7902);
------------------------Transaction Level Rollback------------------------------
BEGIN
    DELETE FROM EMP WHERE DEPTNO = 20;
    UPDATE EMP SET SAL = 123456789 WHERE EMPNO = 7499;
    UPDATE EMP SET SAL = 1234 WHERE EMPNO = 7698;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END;
/
SELECT EMPNO,SAL FROM EMP WHERE DEPTNO = 20 or EMPNO IN (7499,7698);
---------------------------TRANSACTION & DDL------------------------------------
INSERT INTO EMP(EMPNO,ENAME,DEPTNO) VALUES(9999,'OCPOK',20);
select * from emp;
ALTER TABLE EMP ADD( SEX CHAR(1) DEFAULT 'M');
ROLLBACK;
DESC EMP;
select * from emp;
ALTER TABLE EMP DROP COLUMN SEX;
ROLLBACK;
DESC EMP;
delete from emp where empno = 9999;
--------------------------------읽기 일관성----------------------------------------
update emp set sal=0 where deptno= 10;
select deptno,sal from emp where deptno = 10;
commit;
select deptno,sal from emp where deptno = 10;
-----------------------------Row Level Lock-------------------------------------
update emp set sal=9999 where deptno= 10;
commit;

----------------------------------0410------------------------------------------
--------------------------------subquery----------------------------------------
SELECT ENAME,JOB 
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SMITH' );

SELECT ENAME,SAL FROM EMP WHERE SAL < ( SELECT AVG(SAL) FROM EMP);

SELECT ENAME,JOB FROM EMP WHERE DEPTNO = 10,30;
SELECT ENAME,JOB FROM EMP WHERE DEPTNO IN ( 10,30 );
SELECT DNAME,LOC FROM DEPT
WHERE DEPTNO = 
(SELECT DEPTNO FROM EMP GROUP BY DEPTNO HAVING COUNT(*) > 3 );

SELECT DEPTNO,JOB,ENAME,SAL FROM EMP
WHERE (DEPTNO,JOB) IN (SELECT DEPTNO,JOB FROM EMP
GROUP BY DEPTNO,JOB HAVING AVG(SAL) > 2000);

SELECT DEPTNO,JOB,ENAME,SAL FROM EMP
WHERE (DEPTNO,JOB) IN (SELECT DEPTNO,JOB FROM EMP
GROUP BY DEPTNO,JOB HAVING AVG(SAL) > 2000);
-----------------------------------상관서브쿼리-------------------------------------
SELECT DEPTNO,ENAME,JOB,SAL,( SELECT ROUND(AVG(SAL),0)
FROM EMP S WHERE S.JOB=M.JOB) AS JOB_AVG_SAL
FROM EMP M
ORDER BY JOB;

SELECT DEPTNO,ENAME,JOB,SAL FROM EMP M
WHERE SAL > ( SELECT AVG(SAL) AS AVG_SAL FROM EMP WHERE JOB = M.JOB )ORDER BY JOB;

SELECT DEPTNO, ENAME,EMP.JOB,SAL,IV.AVG_SAL
FROM EMP, (SELECT JOB,ROUND(AVG(SAL)) AS AVG_SAL FROM EMP GROUP BY JOB ) IV WHERE EMP.JOB = IV.JOB AND SAL > IV.AVG_SAL
ORDER BY DEPTNO ,SAL DESC;
----------------------------------상위, 하위 5개-----------------------------------
SELECT *
FROM ( SELECT EMPNO,ENAME,SAL FROM EMP ORDER BY SAL ASC) BM WHERE ROWNUM <= 5;

SELECT TN.EMPNO,TN.ENAME,TN.SAL
FROM (SELECT EMPNO,ENAME,SAL FROM EMP ORDER BY SAL DESC) TN WHERE ROWNUM <= 5;
---------------------------------DML과 SubQuery---------------------------------
INSERT INTO BONUS(ENAME,JOB,SAL,COMM) 
SELECT ENAME,JOB,SAL,COMM FROM EMP;
SELECT * FROM BONUS; 
ROLLBACK;
SELECT * FROM BONUS;

INSERT INTO BONUS(ENAME,JOB,SAL,COMM)
SELECT ENAME,JOB,SAL,DECODE(DEPTNO,10,SAL*0.3,20,SAL*0.2) + NVL(COMM,0) 
FROM EMP WHERE DEPTNO IN (10,20);
SELECT * FROM BONUS; 
COMMIT;

UPDATE EMP SET COMM = (SELECT AVG(COMM)/2 FROM EMP) WHERE COMM IS NULL OR COMM = 0;
select * from emp;
COMMIT;

DELETE FROM BONUS WHERE SAL > (SELECT AVG(SAL) FROM EMP);
COMMIT;
-------------------------------------JOIN---------------------------------------
------------------------------Oracle SQL Join-----------------------------------
SELECT DNAME,ENAME,JOB,SAL FROM EMP, DEPT WHERE DEPTNO = DEPTNO;
SELECT DNAME,ENAME,JOB,SAL FROM SCOTT.EMP, SCOTT.DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO;

SELECT DNAME,ENAME,JOB,SAL FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO AND EMP.JOB IN ('MANAGER','CLERK') 
ORDER BY DNAME;

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO;
-------------------------------ANSI SQL Join------------------------------------

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO 
WHERE E.DEPTNO IN (10,20) AND D.DNAME = 'RESEARCH';
-------------------------------Not Inner Join-----------------------------------
SELECT E.ENAME, E.JOB,E.SAL,S.GRADE FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;

SELECT DNAME,ENAME,JOB,SAL,GRADE
FROM EMP E, DEPT D, SALGRADE S 
WHERE E.DEPTNO = D.DEPTNO AND E.SAL BETWEEN S.LOSAL AND S.HISAL;

SELECT E.ENAME, E.JOB,E.SAL, S.GRADE 
FROM EMP E, SALGRADE S 
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND E.DEPTNO IN (10,30)
ORDER BY E.ENAME;

SELECT E.ENAME, E.JOB,E.SAL,S.GRADE FROM EMP E, SALGRADE S
WHERE E.SAL < S.LOSAL AND E.DEPTNO IN (10,30)
ORDER BY E.ENAME;
---------------------------------Outer Join-------------------------------------
SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO
ORDER BY D.DNAME;

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E,DEPT D 
WHERE E.DEPTNO(+) = D.DEPTNO ORDER BY D.DNAME;

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO(+) ORDER BY D.DNAME;

SELECT D.DNAME,NVL(E.ENAME,'비상근 부서'),E.JOB,E.SAL FROM EMP E,DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO
ORDER BY D.DNAME;

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E,DEPT D 
WHERE E.DEPTNO(+) = D.DEPTNO(+) ORDER BY D.DNAME;
------------------------------ANSI Outer Join-----------------------------------
SELECT E.DEPTNO,D.DNAME,E.ENAME FROM EMP E LEFT OUTER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO ORDER BY E.DEPTNO;

SELECT E.DEPTNO,D.DNAME,E.ENAME FROM EMP E RIGHT OUTER JOIN DEPT D ON E.DEPTNO = D.DEPTNO
ORDER BY E.DEPTNO;

SELECT D.DEPTNO,D.DNAME,E.ENAME FROM SCOTT.EMP E FULL OUTER JOIN SCOTT.DEPT D
ON E.DEPTNO = D.DEPTNO
ORDER BY E.DEPTNO;
--------------------------------------과제---------------------------------------
SELECT D.DNAME,E.ENAME,E.JOB,E.SAL 
FROM EMP E,DEPT D 
WHERE E.DEPTNO(+) = D.DEPTNO 
ORDER BY D.DNAME; 

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL 
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO AND E.SAL > 2000 
ORDER BY D.DNAME;

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL 
FROM EMP E,DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO AND E.SAL(+) > 2000 
ORDER BY D.DNAME;
---------------------------------Self Join--------------------------------------
SELECT D.DNAME,E.ENAME,E.JOB,E.SAL 
FROM EMP E,DEPT D 
WHERE E.DEPTNO(+) = D.DEPTNO 
ORDER BY D.DNAME; 

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL 
FROM EMP E, DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO AND E.SAL > 2000 ORDER BY D.DNAME;

SELECT D.DNAME,E.ENAME,E.JOB,E.SAL FROM EMP E,DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO AND E.SAL(+) > 2000 ORDER BY D.DNAME;
---------------------------------Self Join--------------------------------------
SELECT E.ENAME||' ''S MANAGER IS ' ||M.ENAME
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO
ORDER BY M.ENAME;
-----------------------------------과제1-----------------------------------------
SELECT E.ENAME||' ''S MANAGER IS '|| NVL(M.ENAME, 'NOBADY')
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+)
ORDER BY M.ENAME;
-----------------------------------과제2-----------------------------------------
SELECT E.ENAME||' ''S MANAGER IS '|| coalesce(M.ENAME, 'NOBADY')
FROM EMP E, EMP M
WHERE E.MGR = M.EMPNO(+)
ORDER BY M.ENAME;
SELECT E.ENAME||' ''S MANAGER IS '||M.ENAME 
FROM  EMP E, EMP M
WHERE E.MGR(+) = M.EMPNO
ORDER BY M.ENAME;
SELECT E.ENAME||' ''S MANAGER IS '||M.ENAME 
FROM  EMP E, EMP M
WHERE E.MGR = M.EMPNO(+)
ORDER BY M.ENAME;
-- left 조인과 right조인의 차이이다. 누가 기준인가에 따라 다르다.
--------------------------------Cartesian Product-------------------------------
SELECT ENAME,JOB,DNAME FROM EMP, DEPT;
SELECT ENAME,JOB,DNAME FROM EMP CROSS JOIN DEPT;

SELECT ENAME,JOB,DNAME FROM EMP , DEPT
WHERE EMP.SAL > 2000 and DEPT.DEPTNO IN (10,20);
-------------------------------------올바른거-------------------------------------
SELECT ENAME,JOB,DNAME FROM EMP , DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO and EMP.SAL > 2000 and DEPT.DEPTNO IN (10,20);

SELECT ENAME,JOB,DNAME FROM EMP , DEPT
WHERE EMP.SAL > 2000 or DEPT.DEPTNO IN (10,20);
-------------------------------------올바른거-------------------------------------
SELECT ENAME,JOB,DNAME FROM EMP , DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO and (EMP.SAL > 2000 OR DEPT.DEPTNO IN (10,20));

SELECT E.ENAME, E.JOB,E.SAL,S.GRADE 
FROM EMP E, SALGRADE S 
WHERE E.SAL < S.LOSAL AND E.DEPTNO IN (10,30)
ORDER BY E.ENAME;
-------------------------------------올바른거-------------------------------------
SELECT E.ENAME, E.JOB, E.SAL, S.GRADE 
FROM EMP E 
JOIN SALGRADE S ON E.SAL BETWEEN S.LOSAL AND S.HISAL 
WHERE E.DEPTNO IN (10, 30) 
ORDER BY E.ENAME;

select * from salgrade;
-----------------------------------04/11 과제------------------------------------
MERGE INTO bonus b
USING (
    SELECT e.ename, e.job, e.sal, e.comm, e.deptno, 
        CASE 
            WHEN e.deptno = 10 THEN e.sal * 0.1
            WHEN e.deptno = 20 THEN e.sal * 0.2
            ELSE e.sal * 0.05
        END AS bonus
    FROM emp e
) e
ON (b.ename = e.ename AND b.job = e.job)
WHEN MATCHED THEN
    UPDATE SET b.bonus = e.bonus
WHEN NOT MATCHED THEN
    INSERT (ename, job, sal, comm, deptno, bonus)
    VALUES (e.ename, e.job, e.sal, e.comm, e.deptno, e.bonus);
--------------------------------------과제 7-------------------------------------
select deptno from dept union all
select deptno from emp;
select deptno from dept union
select deptno from emp;
select ename,job,sal from emp where job = 'CLERK' union
select ename,job,sal from emp where sal > 2000 order by job asc,sal desc;
select deptno from dept
intersect
select deptno from emp;
select deptno from dept
minus
select deptno from emp;
-------------------------------------과제2,3-------------------------------------
SELECT e.deptno, e.ename, e. job, e.sal, (select count(*) + 1
from emp r
where e.deptno = r.deptno and e.sal < r.sal) "SAL_RANK"
FROM emp e, dept d
where e.deptno = d.deptno
ORDER BY d.deptno ASC, e.sal DESC;

SELECT e.deptno, e.ename, e. job, e.sal, rank() over(
    partition by e.deptno order by e.sal desc) "SAL_RANK"
FROM emp e, dept d
where e.deptno = d.deptno
ORDER BY d.deptno ASC, e.sal DESC;

SELECT e.deptno, e.ename, e. job, e.sal, DENSE_RANK() over(
    partition by e.deptno order by e.sal desc) "SAL_RANK"
FROM emp e, dept d
where e.deptno = d.deptno
ORDER BY d.deptno ASC, e.sal DESC;
-------------------------------------과제 4--------------------------------------
select * from system;
select * from resource_usage;

SELECT S.SYSTEM_ID,S.SYSTEM_NAME,R.RESOURCE_NAME FROM SYSTEM S, RESOURCE_USAGE R
WHERE S.SYSTEM_ID = R.SYSTEM_ID;
SELECT S.SYSTEM_ID,S.SYSTEM_NAME,R.RESOURCE_NAME FROM SYSTEM S,RESOURCE_USAGE R
WHERE S.SYSTEM_ID = R.SYSTEM_ID(+);

SELECT S.SYSTEM_ID, S.SYSTEM_NAME,
MAX(CASE WHEN R.RESOURCE_NAME = 'FTP' THEN '사용' ELSE '미사용' END) AS "FTP",
MAX(CASE WHEN R.RESOURCE_NAME = 'TELNET' THEN '사용' ELSE '미사용' END) AS "TELNET",
MAX(CASE WHEN R.RESOURCE_NAME = 'EMAIL' THEN '사용' ELSE '미사용' END) AS "EMAIL"
FROM SYSTEM S, (SELECT SYSTEM_ID, RESOURCE_NAME
    FROM RESOURCE_USAGE) R
WHERE S.SYSTEM_ID = R.SYSTEM_ID(+)
GROUP BY S.SYSTEM_ID, S.SYSTEM_NAME
ORDER BY S.SYSTEM_ID;
-------------------------------------과제 5--------------------------------------
SELECT E.DEPTNO, E.ENAME, E.SAL, ROUND(E.SAL / R.SAL_TOTAL * 100 , 2)
    || '%' "SAL_RATE"
from EMP E, (SELECT SUM(SAL) AS "SAL_TOTAL"
from EMP) R
ORDER BY DEPTNO ASC;
-------------------------------------04/12--------------------------------------
CREATE TABLE CUSTOMER2(
    ID VARCHAR2(8) NOT NULL, -- 제약
    PWD VARCHAR2(8) CONSTRAINT CUSTOMER_PWD_NN NOT NULL, -- 제약사항 이름 명시, 제약
    NAME VARCHAR2(20), 
    SEX CHAR(1),
    AGE NUMBER(3) -- 나이
    
);
drop table customer2;
DESC CUSTOMER2;

INSERT INTO CUSTOMER2(ID,PWD,NAME,SEX,AGE) 
VALUES('xman','ok','kang', 'M', 21); 

INSERT INTO CUSTOMER2(ID,PWD,NAME,SEX,AGE) 
VALUES('XMAN','no','kim', 'T', -20);
-------------------------------------전부 에러------------------------------------
INSERT INTO CUSTOMER2(ID,NAME,AGE) VALUES('zman','son',99); -- pwd notnull
INSERT INTO CUSTOMER2(ID,PWD,NAME,AGE) VALUES('rman',NULL,'jjang',24); -- pwd notnull
INSERT INTO CUSTOMER2(ID,PWD,NAME,AGE) VALUES('', 'pwd' ,'jjang',24); -- id notnull 

-- ID가 XMAN인 ROW만 수정 SELECT * FROM CUSTOMER;
UPDATE CUSTOMER2 SET PWD = NULL WHERE ID = 'XMAN'; -- pwd notnull
-----------------------------------table의 정보-----------------------------------
SELECT TABLE_NAME,CONSTRAINT_NAME,CONSTRAINT_TYPE,SEARCH_CONDITION FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CUSTOMER2'; --id, pwd not null 제약사항

SELECT TABLE_NAME,CONSTRAINT_NAME,POSITION,COLUMN_NAME
FROM USER_CONS_COLUMNS
WHERE TABLE_NAME = 'CUSTOMER2' ORDER BY CONSTRAINT_NAME,POSITION;

select * from user_tables;
select * from user_tab_columns;
select * from user_indexes;
-------------------------------------check--------------------------------------
ALTER TABLE CUSTOMER2 ADD CONSTRAINT CUSTOMER2_SEX_CK CHECK (SEX IN ('M','F'));

UPDATE CUSTOMER2 SET SEX='M' WHERE SEX='T'; 
COMMIT;
ALTER TABLE CUSTOMER2 ADD CONSTRAINT CUSTOMER_SEX_CK CHECK (SEX IN ('M','F'));

INSERT INTO CUSTOMER2(ID,PWD,NAME,SEX, AGE) VALUES('xman','ok','kang', 'M',21);
INSERT INTO CUSTOMER2(ID,PWD,NAME,SEX,AGE) VALUES('xman','ok', 'jjang','M',20);

INSERT INTO CUSTOMER2(ID,PWD,NAME,AGE) VALUES('asura','ok', 'joo',99);

INSERT INTO CUSTOMER2(ID,PWD,NAME,SEX,AGE) VALUES('harisu','ok', 'susu','T',33);

INSERT INTO CUSTOMER2(ID,PWD,NAME,SEX,AGE) VALUES('shinsun','ok', '도사', 'M',999);

UPDATE CUSTOMER2 SET AGE = AGE + 1;

select * from customer2;
rollback;
----------------------------------unique key------------------------------------
drop table customer2;
select * from customer2;

CREATE TABLE CUSTOMER2(
    ID VARCHAR2(8) NOT NULL CONSTRAINT CUSTOMER2_ID_UK UNIQUE,
    PWD VARCHAR2(8) NOT NULL,
    NAME VARCHAR2(20),
    SEX CHAR(1) DEFAULT 'M' CONSTRAINT CUSTOMER2_SEX_CK CHECK (SEX IN ('M','F')), 
    MOBILE VARCHAR2(14) UNIQUE,
    AGE NUMBER(3) DEFAULT 18
);

INSERT INTO CUSTOMER2(ID,PWD,NAME,MOBILE,AGE) VALUES('xman','ok','kang','011-3333',21);

INSERT INTO CUSTOMER2(ID,PWD,NAME, MOBILE,AGE) VALUES('XMAN','yes','kim','011-3334',33);

INSERT INTO CUSTOMER2(ID,PWD,NAME, MOBILE,AGE) VALUES('xman','yes','lee', '011-3335',-21);

INSERT INTO CUSTOMER2(ID,PWD,NAME, MOBILE,AGE) VALUES('yman','yes','lee', '011-3333',28);

INSERT INTO CUSTOMER2(ID,PWD,NAME, MOBILE) VALUES('무명','yes',NULL, NULL);

ALTER TABLE CUSTOMER2 ADD CONSTRAINT CUSTOMER2_NAME_SEX_UK UNIQUE(NAME,SEX);
ALTER TABLE CUSTOMER2 MODIFY(NAME NOT NULL);

INSERT INTO CUSTOMER2(ID,PWD,NAME, SEX) VALUES('rman','yes','syo', 'M'); 
INSERT INTO CUSTOMER2(ID,PWD,NAME, SEX ) VALUES('Rman','yes','syo', 'F'); 
INSERT INTO CUSTOMER2(ID,PWD,NAME, SEX) VALUES('RmaN','yes','syo', 'M'); 
SELECT * FROM CUSTOMER2;

SELECT INDEX_NAME,INDEX_TYPE,UNIQUENESS FROM USER_INDEXES WHERE TABLE_NAME = 'CUSTOMER2';
SELECT INDEX_NAME,COLUMN_POSITION,COLUMN_NAME FROM USER_IND_COLUMNS WHERE TABLE_NAME = 'CUSTOMER2' ORDER BY INDEX_NAME,COLUMN_POSITION;

--------------------------------------0413--------------------------------------
---------------------------------------PK---------------------------------------
DROP TABLE CUSTOMER3;
CREATE TABLE CUSTOMER3(
ID VARCHAR2(8) CONSTRAINT CUSTOMER3_ID_PK PRIMARY KEY,
PWD VARCHAR2(8) NOT NULL,
NAME VARCHAR2(20),
SEX CHAR(1) DEFAULT 'M'
CONSTRAINT CUSTOMER3_SEX_CK CHECK (SEX IN ('M','F')), MOBILE VARCHAR2(14) CONSTRAINT CUSTOMER3_MOBILE_UK UNIQUE,
AGE NUMBER(3) DEFAULT 18 );

INSERT INTO CUSTOMER3(ID,PWD,NAME,MOBILE) VALUES('zman','ok','한국', '011');

INSERT INTO CUSTOMER3(ID,PWD,NAME) VALUES('xman','ok','king');

INSERT INTO CUSTOMER3(ID,PWD,NAME) VALUES('xman','power','zzang');

INSERT INTO CUSTOMER3(ID,PWD,NAME) VALUES('Xman','korea','dbzzang');

INSERT INTO CUSTOMER3(ID,PWD,NAME) VALUES(lower('xMan'),'ok','zzang');

INSERT INTO CUSTOMER3(PWD,NAME) VALUES('ok','kim');

UPDATE CUSTOMER3 SET ID = NULL;
UPDATE CUSTOMER3 SET ID = 'XMAN';

SELECT TABLE_NAME,CONSTRAINT_NAME,CONSTRAINT_TYPE,SEARCH_CONDITION FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'CUSTOMER3';

SELECT TABLE_NAME,CONSTRAINT_NAME,POSITION,COLUMN_NAME FROM USER_CONS_COLUMNS 
WHERE TABLE_NAME = 'CUSTOMER3' ORDER BY CONSTRAINT_NAME,POSITION;

SELECT INDEX_NAME,INDEX_TYPE,UNIQUENESS FROM USER_INDEXES
WHERE TABLE_NAME = 'CUSTOMER3';

SELECT INDEX_NAME,COLUMN_POSITION,COLUMN_NAME FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'CUSTOMER3' ORDER BY INDEX_NAME,COLUMN_POSITION;
---------------------------------------FK---------------------------------------
CREATE TABLE 부서(
    부서번호 VARCHAR2(2) CONSTRAINT 부서_부서번호_PK PRIMARY KEY,
	부서명 VARCHAR2(10) CONSTRAINT 부서_부서명_NNNOT NOT NULL
);
CREATE TABLE 사원( 
    사번 VARCHAR2(8) PRIMARY KEY, 
    이름 VARCHAR2(10),
    부서번호 VARCHAR2(2),
    CONSTRAINT 사원_부서_부서번호_FK FOREIGN KEY(부서번호)
        REFERENCES 부서(부서번호) ON DELETE CASCADE
);

describe 부서
desc 사원

INSERT INTO 사원(사번,이름,부서번호) VALUES('XMAN', 'TUNER','10');
INSERT INTO 부서(부서번호,부서명) VALUES('10','관리'); 
INSERT INTO 부서(부서번호,부서명) VALUES('20','전산'); 
INSERT INTO 부서(부서번호,부서명) VALUES('50','영업');

INSERT INTO 사원(사번,이름,부서번호) VALUES('XMAN','TUNER',10); 
INSERT INTO 사원(사번,이름,부서번호) VALUES('YMAN','DBA',20);

INSERT INTO 사원(사번,이름,부서번호) VALUES('ZMAN', 'DEVELOPER',30);

DELETE FROM 부서 WHERE 부서번호 = 50;

DELETE FROM 부서 WHERE 부서번호 = 10;
SELECT * FROM 사원;

UPDATE 사원 SET 부서번호=20 WHERE 부서번호=10; 
DELETE FROM 부서 WHERE 부서번호 = 10;
------------------------------------Sequence------------------------------------
CREATE SEQUENCE SCOTT.ORDER_SEQ
	INCREMENT BY 1 
	START WITH 1
	MAXVALUE 999999999999
	MINVALUE 1
	NOCYCLE 
	CACHE 30;

SELECT ORDER_SEQ.CURRVAL FROM DUAL;

SELECT ORDER_SEQ.NEXTVAL FROM DUAL; 
SELECT ORDER_SEQ.CURRVAL FROM DUAL;
SELECT trim(to_char(ORDER_SEQ.CURRVAL, 'fm000000000000')) as CURRVAL FROM DUAL;

SELECT ORDER_SEQ.NEXTVAL FROM DUAL; 
SELECT trim(to_char(ORDER_SEQ.NEXTVAL, '999999999999')) FROM DUAL; 
ROLLBACK;
SELECT ORDER_SEQ.NEXTVAL FROM DUAL;

SELECT EMPNO,ENAME,ORDER_SEQ.NEXTVAL FROM EMP;

INSERT INTO ORDERS(ORDER_ID,ORDER_MODE,CUSTOMER_ID,ORDER_STATUS,SALES_ID) VALUES(ORDER_SEQ.NEXTVAL,'direct',166,1,7499);

INSERT INTO SCOTT.ORDERS(ORDER_ID,ORDER_DATE,ORDER_MODE,CUSTOMER_ID,ORDER_STATUS,SALES_ID) VALUES(SCOTT.ORDER_SEQ.NEXTVAL,SYSDATE,'online',200,3,7521);

COMMIT;

INSERT INTO ORDERS(ORDER_ID,ORDER_DATE,ORDER_MODE,CUSTOMER_ID,ORDER_STATUS,SALES_ID) VALUES(ORDER_SEQ.NEXTVAL,SYSDATE,'online',135,2,7844);

ROLLBACK;

SELECT ORDER_ID FROM ORDERS;
SELECT ORDER_SEQ.CURRVAL FROM DUAL;

INSERT INTO ORDERS(ORDER_ID,ORDER_DATE,ORDER_MODE,CUSTOMER_ID,ORDER_STATUS,SALES_ID) VALUES(ORDER_SEQ.NEXTVAL,SYSDATE,'direct',135,4,7844);

INSERT INTO scott.ORDERS(ORDER_ID,ORDER_MODE,CUSTOMER_ID,ORDER_STATUS,SALES_ID) VALUES((SELECT MAX(ORDER_ID)+1 FROM scott.ORDERS),'direct',335,1,7654);
------------------------------------Synonyum------------------------------------
SELECT * FROM SALGRADE;

CREATE SYNONYM SALG FOR SALGRADE;

CREATE SYNONYM SALG FOR SALGRADE; 
SELECT * FROM SALG;
DESC SALG
select * from tabs;
select * from user_objects;

DESC system.HELP
DESC SYSTEM.HELP
SELECT * FROM SYSTEM.HELP;

CREATE SYNONYM HELP FOR SYSTEM.HELP; 
DESC HELP
SELECT * FROM HELP;