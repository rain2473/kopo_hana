SELECT * FROM DEPT;
SELECT DEPTNO,DNAME,NVL(LOC,'미지정지역') AS LOC FROM DEPT; 
SELECT * 
FROM DEPT
AS OF TIMESTAMP(SYSTIMESTAMP-INTERVAL '180' MINUTE); 
commit;

SELECT distinct sid
FROM v$mystat;

select username from all_users