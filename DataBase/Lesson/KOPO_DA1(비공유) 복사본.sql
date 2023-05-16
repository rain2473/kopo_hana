SELECT * FROM DEPT;
--------------------------------읽기 일관성----------------------------------------
select deptno,sal from emp where deptno = 10;
select deptno,sal from emp where deptno = 10;
-----------------------------Row Level Lock-------------------------------------
delete from emp where deptno = 20;commit;
delete from emp where deptno = 10;
rollback;