--1.학과 TB_DEPARTMENT

CREATE TABLE TB_DEPARTMENTBYYM(
	DEPARTMENT_NO   VARCHAR2(10) CONSTRAINT PK_TB_DEPARTMENT PRIMARY KEY,
	DEPARTMENT_NAME VARCHAR2(20) CONSTRAINT NN_TB_DEPARTMENT NOT NULL,
	CATEGORY        VARCHAR2(20) 
	OPEN_YN         CHAR(1)
	CAPACITY        NUMBER
)

COMMENT ON COLUMN TB_DEPARTMENTBYYM.DEPARTMENT_NO IS '학과 번호';
COMMENT ON COLUMN TB_DEPARTMENTBYYM.DEPARTMENT_NAME IS '학과 이름';
COMMENT ON COLUMN TB_DEPARTMENTBYYM.CATEGORY IS '계열';
COMMENT ON COLUMN TB_DEPARTMENTBYYM.OPEN_YN IS '개설 여부';
COMMENT ON COLUMN TB_DEPARTMENTBYYM.CAPACITY IS '정원';


INSERT INTO TB_DEPARTMENTBYYM VALUES ('01','총무부','관리부',Y,5);
INSERT INTO TB_DEPARTMENTBYYM VALUES ('02','해외영업1','영업부',N,10);
