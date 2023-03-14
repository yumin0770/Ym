-- TCL(TRANSACTION CONTROL LANGUAGE) : 트랜잭션 제어 언어 //제어하는 언어
-- COMMIT(트랜잭션 종료 후 저장), ROLLBACK(트랜잭션 취소), SAVEPOINT(임시저장)

-- DML : 데이터 조작 언어로 데이터의 삽입(INSERT), 수정(UPDATE), 삭제(DELETE)
--> 트랜잭션은 DML과 관련되어 있음.


/* TRANSACTION이란?
 - 데이터베이스의 논리적 연산 "단위" 1TRANSACTION 2TRANSACTION
 
 - 데이터 변경 사항을 묶어 하나의 트랜잭션에 담아 처리함.

 - 트랜잭션의 대상이 되는 데이터 변경 사항 : INSERT, UPDATE, DELETE (DML)
 
 EX) INSERT 수행 --------------------------------> DB 반영(X)
   
     INSERT 수행 --> 트랜잭션에 추가 --> COMMIT --> DB 반영(O)
     
     INSERT 10번 수행 --> 1개 트랜잭션에 10개 추가 --> ROLLBACK --> DB 반영 안됨


   *중요* 1) COMMIT : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 DB에 반영 --"저장소에 저장한다!"
    			--실제 INSERT가 일어난다.
   *중요* 2) ROLLBACK : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 삭제하고
                 마지막 COMMIT 상태로 돌아감.
                
    3) SAVEPOINT : 메모리 버퍼(트랜잭션)에 저장 지점을 정의하여
                   ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아닌
                   저장 지점까지만 일부 ROLLBACK 
    
    [SAVEPOINT 사용법]
    
    SAVEPOINT 포인트명1;
    ...
    SAVEPOINT 포인트명2;
    ...
    ROLLBACK TO 포인트명1; -- 포인트1 지점 까지 데이터 변경사항 삭제

*/


SELECT * FROM DEPARTMENT2;

SELECT * FROM DEPARTMENT2;

--DEPARTMENT2에
--D0, 경리부, L2삽인

INSERT INTO DEPARTMENT2
VALUES('D0','경리부','L2');

--경리부 삽입 확인
-->아직 DB에 실제로 삽입되지 않았다!! --TRANSACTION에 저장한걸 보여줌
SELECT * FROM DEPARTMENT2;

--DEAVER        DBMS          DB
--    		TRANSACTION  -ROLLBACK하면 트랜잭션 지워짐, 커밋하면 트랜잭션에 있던거 DB에 들어감

ROLLBACK;
--> 마지막 커밋 상태로 되돌아감 ==TRANSACTION를 지운다

SELECT * FROM DEPARTMENT2;

--다시 경리부 INSERT 

INSERT INTO DEPARTMENT2
VALUES('D0','경리부','L2');


COMMIT;
-->트랜잭션에 저장된 DML을 DB에 반영

SELECT * FROM DEPARTMENT2;

ROLLBACK; -->이미 앞서서 COMMIT을 수행
		--> 돌아갈 내용이 없음

--경리부 남아있음을 확인
SELECT * FROM DEPARTMENT2;

--게시글 수정 2~3개 테이블 수정하는데 하나라도 문제가 발생하면 모두 되돌려서 원래 상태를 유지

-------------------------------------------------------------------

--SAVEPOINT 사용하기

DELETE FROM DEPARTMENT2
WHERE DEPT_ID = 'D1';
--> DELETE 내역이 트랜잭션에 저장


SELECT* FROM DEPARTMENT2;

--D1 삭제 구문 수행 후 시점을 저장
SAVEPOINT S1;


--D2 삭제
DELETE FROM DEPARTMENT2
WHERE DEPT_ID = 'D2';

SELECT* FROM DEPARTMENT2;

--D2 삭제 구문 수행 후 시점을 저장
SAVEPOINT S2;

--D3 삭제
DELETE FROM DEPARTMENT2
WHERE DEPT_ID = 'D3';

SELECT* FROM DEPARTMENT2;

--S2까지만 ROLLBACK
ROLLBACK TO S2;
SELECT* FROM DEPARTMENT2; --D3 다시 살아남

--S1까지만 ROLLBACK
ROLLBACK TO S1;
SELECT* FROM DEPARTMENT2 d ; --쌓여 나가는 STAC구조

--트랜잭션의 모든 내용 삭제
ROLLBACK;
SELECT* FROM DEPARTMENT2;


