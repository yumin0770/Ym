SELECT EMP_ID,EMP_NAME,JOB_NAME,SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE SALARY BETWEEN 2000000 AND 5000000
ORDER BY SALARY DESC;

---------------------------------------------------

--사번 생성 시퀀스(223번 시작)
CREATE SEQUENCE SEQ_EMP_ID 
START WITH 223 --223번 시작
INCREMENT BY 1 --1씩 증가
NOCYCLE  --반복 없음
NOCACHE; --미리 만들어 두는 번호 없음

--SEQ_EMP_ID.NEXTVAL : 다음 번호 생성
--SEQ_EMP_ID_CURRBAL : 현재 번호 조회
--------------------------------
UPDATE EMPLOYEE 
SET EMAIL = ?,
	PHONE = ?,
	SALARY = ? 
WHERE EMP_ID = 200;

SELECT EMP_ID,EMP_NAME,PHONE ,EMAIL SALARY 
FROM EMPLOYEE 
WHERE EMP_ID = 223;
----------------------------

UPDATE EMPLOYEE 
SET ENT_YN = ?,
	ENT_DATE =SYSDATE ,
WHERE EMP_ID =?;



DELETE FROM EMPLOYEE 
WHERE EMP_ID = '200';

ROLLBACK;


INSERT INTO EMPLOYEE
SELECT *
FROM EMPLOYEE  AS OF TIMESTAMP(SYSTIMESTAMP - INTERVAL '10' MINUTE)    
WHERE EMP_ID = '200';

 
 --// 현재 재직중인 사원의
--/ 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
--/ 직급코드 오름차순으로 조회
 
 
 SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME,PHONE,EMAIL
 FROM EMPLOYEE 
 JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
 JOIN JOB USING (JOB_CODE)
 WHERE ENT_YN = 'N'
 ORDER BY JOB_CODE;
 
 

--	// 현재 퇴직한 사원의
---// 사번, 이름, 전화번호, 이메일, 퇴사일을
--	-// 퇴사일 오름차순으로 조회

SELECT EMP_ID,EMP_NAME,PHONE,EMAIL,ENT_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'Y'
ORDER BY ENT_DATE  ;
 

--("3. 사번이 일치하는 사원 조회"); 
	--	// 사번을 입력 받아 일치하는 사원의  
	--	// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
	--	// 단, 사번이 일치하는 사원이 없으면
	--// "사번이 일치하는 사원이 없습니다" 출력

SELECT EMP_ID,EMP_NAME,DEPT_TITLE,SALARY,PHONE,EMAIL,HIRE_DATE,ENT_YN
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID = '223';

				
--"5. 사번으로 사원 정보 수정(UPDATE)"
--이메일, 전화번호, 급여, 보너스 수정
--단, 사번이 일치하는 사원이 없으면
--"사번이 일치하는 사원이 없습니다" 출력

UPDATE EMPLOYEE 
SET EMAIL = ,
	PHONE = ,
	SALARY = ,
	BONUS = 
WHERE EMP_ID  = ;

 UPDATE EMPLOYEE 
SET PHONE = '01012347890'
WHERE EMP_ID  = 223;

SELECT * FROM EMPLOYEE  WHERE EMP_ID = 208;


ROLLBACK;


DELETE FROM EMPLOYEE 
WHERE EMP_ID =200 ;

UPDATE EMPLOYEE 
SET ENT_YN  = 'N'
WHERE EMP_ID = 208;

SELECT *
FROM (SELECT EMP_ID,EMP_NAME,NVL(DEPT_TITLE,'부서없음'),HIRE_DATE
	FROM EMPLOYEE 
	JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
	ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <=5;



SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
	  FROM EMPLOYEE 
	  ORDER BY SALARY DESC) -->메인커리에 포함된 VIEW 생성 구문
	  						--> 인라인 뷰
WHERE ROWNUM <= 5;




--입력받은 사번의 사원이 존재하지 않으면 0
--사원은 있는데 퇴직처리된 사원이면 1
--사원도 있고, 재직중인 사원이면 2 조회


SELECT         (SELECT 0 FROM DUAL) UNION 
			   (SELECT 1 FROM DUAL) UNION
			   (SELECT 2 FROM DUAL) 
			   
FROM EMPLOYEE 
WHERE ETN_YN = 'NULL' IS '0'
OR   ETN_YN = 'N' IS '2'
OR   ETN_YN = 'Y' IS '1'


--선택함수.. DECODE, CASE

SELECT CASE 
		--존재하지 않는 사원?
		WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = 200) = 0  --이 직워 존재??
		THEN 0
		
		--존재하지만 퇴직한 사원?
		WHEN (SELECT COUNT(*) FROM EMPLOYEE 
			WHERE EMP_ID = 200 AND ENT_YN = 'Y') =1    --퇴사한 직원
		THEN 1
		
		--존재하고 퇴직하지 않은 사원?
		ELSE 2
   END "CHECK"

FROM DUAL;



--SELECT CASE 
--	WHEN ETN_YN = 'N'
--	THEN 
	
--	WHEN 조건식
--	THEN 조건식 참일 경우
	
--	ELSE 모두 FALSE
	
--END

--FROM DUAL;




--9.
--//각 부서별
--// 부서명, 인원 수, 급여 평균
--// 부서코드 오름차순 조회

SELECT DEPT_CODE,NVL(DEPT_TITLE,'부서없음'), COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY DEPT_CODE;






















