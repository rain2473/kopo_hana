REM  ***********************************************************************************************************
REM  SCRIPT 용도 : 우편번호 데이터 관리 테이블 생성 Script
REM  작성자      : you
REM  작성일      : 2017-04-20, 
REM  주  의      : 1)번지 데이타 미분리, 시작번지 , 종료 번지 분리 필요
REM                2)Index 필요성 검토
REM                
REM  수정사항 예시
REM               06/05/29  1. PL/SQL로 처리해서 출력할것.. 성능이 저하되는 DBMS에서는 시간이 너무 오래걸린다.
REM               06/12/28  2. format 일부 조정..
REM  ***********************************************************************************************************    

drop   table zipcode;
 
create table zipcode(
	zipcode	varchar2(7) constraint zipcode_pk primary Key ,	/* 우편번호  */
	sido		varchar2(4),						/* 특별시,광역시,도 */
	gugun		varchar2(17),						/* 시,군,구  */
	dong		varchar2(26),						/* 읍,면,동  */
	ri		varchar2(45),						/* 리,건물명 */
 	bunji		varchar2(17),						/* 번지,아파트동,호수 */
	seq		number(5)							/* 데이터 순서 */
) tablespace users;



