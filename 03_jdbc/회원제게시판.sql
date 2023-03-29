--MEMBER 테이블 삭제
DROP TABLE MEMBER;

--회원제 게시판 

--회원(MEMBER)테이블

CREATE TABLE "MEMBER"(
	MEMBER_NO NUMBER CONSTRAINT PK_NO PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL,
	MEMBER_NM VARCHAR2(30) NOT NULL,
	MEMBER_GENDER CHAR(1) CONSTRAINT CK_GN CHECK(MEMBER_GENDER IN('M','F')),
	ENPROLL_DT DATE DEFAULT SYSDATE NOT NULL,
	UNREGISTER_FL CHAR(1) DEFAULT 'N' CONSTRAINT CK_FL CHECK (UNREGISTER_FL IN ('Y','N'))
);



COMMENT ON COLUMN "MEMBER".MEMBER_NO IS '회원번호(시퀀스 SEQ_MEMBER_NO)';
COMMENT ON COLUMN "MEMBER".MEMBER_ID IS '회원아이디';
COMMENT ON COLUMN "MEMBER".MEMBER_PW IS '회원비밀번호';
COMMENT ON COLUMN "MEMBER".MEMBER_NM IS '회원이름';
COMMENT ON COLUMN "MEMBER".MEMBER_GENDER IS '성별(M/F)';
COMMENT ON COLUMN "MEMBER".ENPROLL_DT IS '가입일';
COMMENT ON COLUMN "MEMBER".UNREGISTER_FL IS '탈퇴여부(Y/N)';

--게시글(BOARD) 테이블

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		            NOT NULL,
	"BOARD_TITLE"	VARCHAR2(600)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"DELETE_FL"	CHAR(1)	DEFAULT 'N'	CHECK ("DELETE_FL" IN ('Y','N')),
	"MEMBER_NO"	NUMBER		NOT NULL,
	CONSTRAINT BOARD_MEMBER_FK FOREIGN KEY("MEMBER_NO") REFERENCES "MEMBER"(MEMBER_NO)
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호(시퀀스 SEQ_BOARD_NO)';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';
COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."DELETE_FL" IS '삭제여부(Y/N)';
COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원번호(FK)';

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);





--댓글(COMMENT) 테이블


CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR2(2000)		NOT NULL,
	"CREARE_DT"	DATE	DEFAULT SYSDATE	NULL,
	"DELETE_FL"	CHAR(1)	DEFAULT 'N'	CHECK("DELETE_FL" IN ('Y','N')),
	"MEMBER_NO"	NUMBER	NOT NULL CONSTRAINT COMMENT_MEMBER_FK REFERENCES "MEMBER"(MEMBER_NO),
	"BOARD_NO"	NUMBER	NOT NULL CONSTRAINT COMMENT_BOARD_FK REFERENCES "BOARD"(BOARD_NO)
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글번호(시퀀스 SEQ_COMMENT_NO)';
COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';
COMMENT ON COLUMN "COMMENT"."CREARE_DT" IS '댓글 작성일';
COMMENT ON COLUMN "COMMENT"."DELETE_FL" IS '삭제여부(Y/N)';
COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '회원번호(FK)';
COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '게시글번호(FK)';

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);


--SEQUENCE 생성(MEMBER,BOARD,COMMENT)
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE;

--회원 샘플 3개 INSERT 

INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01', 'pass01', '유저일', 'F', DEFAULT, DEFAULT);

INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02', 'pass02', '유저이','M',DEFAULT,DEFAULT);

INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user03', 'pass03', '유저삼','F',DEFAULT,DEFAULT);



SELECT * FROM "MEMBER";

COMMIT;

--BOARD 테이블 샘플테이터 3개 삽입
INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 1','내용1 입니다\n 안녕하세요.',
		DEFAULT, DEFAULT, DEFAULT, 1);


INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 2','내용2 입니다\n 안녕하세요.',
		DEFAULT, DEFAULT, DEFAULT, 1);
	
INSERT INTO "BOARD"
VALUES(SEQ_BOARD_NO.NEXTVAL, '샘플 제목 3','내용3 입니다\n 안녕하세요.',
		DEFAULT, DEFAULT, DEFAULT, 2);
--삽입 확인
SELECT * FROM "BOARD";
COMMIT;


--게시글 목록 조회
--게시글 번호, 제목, 작성자, 작성일, 조회수
--최신 게시글이 위쪽으로 오도록 정렬해서 조회


SELECT BOARD_NO,BOARD_TITLE,MEMBER_NM,CREATE_DT,READ_COUNT
FROM "BOARD"
JOIN "MEMBER" USING (MEMBER_NO)
--WHERE BOARD_NO != 0; ----INDEX 사용
ORDER BY CREATE_DT DESC;


--댓글 샘플 데이터 삽입

INSERT INTO "COMMENT"
VALUES (SEQ_COMMENT_NO.NEXTVAL,'댓글 샘플 1번', DEFAULT, DEFAULT,
		1,1);
	
INSERT INTO "COMMENT"
VALUES (SEQ_COMMENT_NO.NEXTVAL,'댓글 샘플 1번', DEFAULT, DEFAULT,
		2,1);
	
INSERT INTO "COMMENT"
VALUES (SEQ_COMMENT_NO.NEXTVAL,'댓글 샘플 1번', DEFAULT, DEFAULT,
		3,2);	
	

SELECT * FROM "COMMENT";

COMMIT;
	
	
--게시글 목록 조회
--게시글 번호, 제목 ,작성자, 작성일, 조회수댓글 수 
--최신 게시글이 위쪽으로 오도록 정렬해서 조회
SELECT BOARD_NO,BOARD_TITLE,MEMBER_NM,CREATE_DT,READ_COUNT,
		(SELECT COUNT(*) FROM "COMMENT" SUB
		WHERE SUB.BOARD_NO = MAIN.BOARD_NO
		AND DELETE_FL = 'N') COMMENT_COUNT
FROM "BOARD" MAIN
JOIN "MEMBER" USING (MEMBER_NO)
WHERE DELETE_FL = 'N'
ORDER BY BOARD_NO DESC;


--특정 개시글 댓글 수 

SELECT COUNT(*) FROM "COMMENT"
WHERE BOARD_NO =  1);


-------------------------------------------------------------------------------------------------------------------------------------------------------
--로그인

SELECT MEMBER_NO,MEMBER_ID,MEMBER_NM,MEMBER_GENDER,TO_CHAR(ENPROLL_DT, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') ENPROLL_DT 
FROM "MEMBER"
WHERE MEMBER_ID = 'user01'
AND MEMBER_PW = 'pass01'
AND UNREGISTER_FL = 'N';




--탈죄하지 않은 회원중 아이디 중복 검사
SELECT count(*) FROM "MEMBER" 
AND  MEMBER_ID = 'user01';


--회원가입

INSERT INTO "MEMBER"

INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01', 'pass01', '유저일', 'F', DEFAULT, DEFAULT);


--회원 목록 조회(아이디, 이름,성별(남/여) + 회원번호 내림차순)

SELECT MEMBER_ID, MEMBER_NM ,DECODE(MEMBER_GENDER, 'M','남','여') 성별
FROM "MEMBER"
WHERE UNREGISTER_FL = 'N'
ORDER BY MEMBER_NO DESC;




------------
--회원 정보 (이름,성별 ) 수정




UPDATE "MEMBER"
SET MEMBER_PW = 'pass01'
WHERE MEMBER_NO  = 1;



SELECT * FROM member;

ROLLBACK;


UPDATE "MEMBER"
SET UNREGISTER_FL  = 'N'
WHERE MEMBER_NO  = 4;


---------------------------------------
--게시글 상세 조회 

SELECT  BOARD_NO, BOARD_TITLE, BOARD_CONTENT , MEMBER_NO,
		MEMBER_NM, READ_COUNT, CREATE_DT 
FROM "BOARD"
JOIN "MEMBER" USING (MEMBER_NO)
WHERE DELETE_FL = 'N'
AND BOARD_NO = ? ;



--조회수 증가
UPDATE "BOARD" 
SET READ_COUNT = READ_COUNT  + 1  --이전 조회수 +1 값으로 수정
WHERE BOARD_NO = 1;

SELECT*FROM "BOARD" WHERE BOARD_NO  ='1';
--DB에서 = 같다는 의미지만 수정할 땐 "대입"

ROLLBACK;


--게시글 수정
UPDATE "BOARD" 
SET BOARD_TITLE  = ?
	BOARD_CONTENT = ?
WHERE BOARD_NO = ?
;
--게시글 삭제 (update)

UPDATE "BOARD"
SET DELETE_FL  ='Y'
WHERE BOARD_NO = ?
;

--게시글 복구
UPDATE "BOARD"
SET DELETE_FL  ='N'
WHERE BOARD_NO = 1;
COMMIT;


SELECT * FROM "BOARD";


---게시글 작성
INSERT INTO "BOARD" 
VALUES (?, ?, ?,DEFAULT,DEFAULT,DEFAULT, ?)
; -- 삽입 성공 1, 실패하면 0


--다음 시퀀스 번호 생성
SELECT SEQ_BOARD_NO.NEXTVAL FROM DUAL;


--특정 게시글에 대한 댓글 목록 조회
SELECT COMMENT_NO, COMMENT_CONTENT, MEMBER_NO, MEMBER_NM,CREARE_DT 
FROM "COMMENT" 
JOIN "MEMBER" USING (MEMBER_NO)
WHERE DELETE_FL = 'N'
AND BOARD_NO = 1
ORDER BY COMMENT_NO;


---댓글 작성

INSERT INTO "COMMENT"
VALUES (?,?,DEFAULT,DEFAULT,?,?)
;

--다음 시퀀스 번호 생성
SELECT SEQ_COMMENT_NO.NEXTVAL FROM DUAL;


--댓글 수정
UPDATE "COMMENT" 
SET COMMENT_CONTENT  = ?
WHERE COMMENT_NO = ?;


SELECT COMMENT_NO,COMMENT_CONTENT ,MEMBER_NO  
FROM "COMMENT";


UPDATE  "COMMENT"
SET DELETE_FL = 'Y'
WHERE COMMENT_NO = 1;
 

ROLLBACK;

