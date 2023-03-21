SELECT DEPT_CODE FROM EMPLOYEE ; --23행 조회

SELECT SUM(SALARY) FROM EMPLOYEE;--1행 조회

-- 부서별 급여 합 조회
SELECT DEPT_CODE,SUM(SALARY) FROM EMPLOYEE;
-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다.

/*3*/SELECT DEPT_CODE, SUM(SALARY)
/*1*/FROM EMPLOYEE --1) EMPLOYEE 테이블에서
/*2*/GROUP BY DEPT_CODE; --2) DEPT_CODE가 같은 행끼리 그룹을 지어

-------------------------------------------------------------------

/*SELECT문 해석 순서 --셀렉트문이 6개의 절로 구성됨
 *
 *5 : SELECT 컬럼명,함수,계산식, 리터럴 [[AS] 별칭]
 *1 : FROM  테이블명
 *2 : WHERE 조건식
 *3 : GROUP BY 그룹으로 묶을 컬럼명|함수
 *4 : HAVING 그룹함수식을 이용한 조건식 (GROUP BY가 있어야 작성 가능!)
 *6 : ORDER BY 컬럼명|별칭|컬럼순서 정렬방식 [NULL FIRST|LAST]
 * 
 */

--* GROUP BY 절: 같은 값들이 여러 개 기록된 행을 하나의 그룹으로 묶음


--부서별 급여 평균

SELECT DEPT_CODE,AVG(SALARY) 
FROM EMPLOYEE
GROUP BY DEPT_CODE--7개 그룹
ORDER BY DEPT_CODE;

--부서별 급여합, 급여평균, 인원 수 ,최고참 입사일, 막내 입사일
--부서코드 오름차순 조회

SELECT DEPT_CODE, SUM(SALARY), ROUND(AVG(SALARY)), COUNT(*),
	   MIN(HIRE_DATE),MAX(HIRE_DATE)
FROM EMPLOYEE 
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

--각 직급코드별로 보너스를 받는 사원의 수를 조회
--직급코드 오름차순

SELECT JOB_CODE, COUNT(BONUS) 
FROM EMPLOYEE
GROUP BY JOB_CODE 
ORDER BY JOB_CODE;

-- EMPLOYEE 테이블에서 
-- 성별과 성별 별 급여 평균(내림처리), 급여 합, 인원 수 조회
-- 인원 수 오름차순 정렬

SELECT
	  DECODE(SUBSTR(EMP_NO,8,1), '1', '남자', '2', '여자') 성별
	 ,FLOOR(AVG(SALARY))"급여평균"
     ,SUM(SALARY)"급여 합"
	 ,COUNT(*)"인원 수"
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1), '1', '남자', '2', '여자')
		--> SELECT절 해석이 되지 않아 성별 별칭 사용 불가능		
ORDER BY "인원 수";



--WHERE + GROUP BY 
--> WHERE절이 GROUP BY절보다 우선 순위가 빠르다

--EMPLOYEE 테이블에서 부서코드가 'D5, 'D6'인 부서의 평균 급여 조회

SELECT DEPT_CODE , AVG(SALARY) --4)DEPT_CODE 급여 평균 조회
FROM EMPLOYEE --1)EMPLOYEE 테이블에서 
WHERE DEPT_CODE IN('D5','D6') --2) 부서코드가 D5,D6인 행만 추려서
GROUP BY DEPT_CODE; --3)추려진 결과 내에서 부서코드 별로 그룹을 지어

--EMPLOYEE 테이블에서 직급별 2000년도 이후 입사자들의 급여 합 조회
--						(2000년 이상)

SELECT JOB_CODE,SUM(SALARY)
FROM EMPLOYEE 
WHERE HIRE_DATE >= TO_DATE('2000-01-01')
GROUP BY JOB_CODE;


SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE 
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2000
GROUP BY JOB_CODE;

-----------------------------------------------------------

--*그룹 내 그룹 (소규모 그룹)만들기*

--EMPLOYEE 테이블에서 부서별로 같은 직급인 사원의 급여합을
--부서코드 오름차순으로 조회

SELECT DEPT_CODE, JOB_CODE,SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE 
--      (큰 그룹), (작은 그룹)
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 
--부서별로 급여 등급(SAL_LEVER)같은 직원 수 조회
--부서코드 오름차순, 급여 등급 내림차순으로 조회

SELECT DEPT_CODE,SAL_LEVEL, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, SAL_LEVEL 
ORDER BY DEPT_CODE ASC, SAL_LEVEL  DESC;

--------------------------------------------------------------
--------------------------------------------------------------

--*HAVING 절: 그룹함수로 조회할 그룹에 대한 조건을 설정할 때 사용

--부서별 평균 급여가 300백만원 이상인 부서를 조회
/*4*/SELECT DEPT_CODE, AVG(SALARY)
/*1*/FROM EMPLOYEE
/*2*/GROUP BY DEPT_CODE
/*3*/HAVING AVG(SALARY)>= 3000000 --GROUP BY에서 묶인 그룹에 조건을 대입
/*5*/ORDER BY 1;

--부서별 급여가 300백만 이상인 사원들의 평균을 조회
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
WHERE SALARY >= 3000000 -- EMPLOYEE 테이블의 모든 행에 조건을 대입
GROUP BY DEPT_CODE 
ORDER BY 1;

--부서별 급여 합이 900만을 초과하는 부서의
--부서코드, 급여합, 인원 수 조회

SELECT DEPT_CODE, SUM(SALARY),COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE 
HAVING SUM(SALARY)> 9000000;

--EMPLOYEE 테이블에서 부서별 70년대생의 급여 평균이 300만 이상인 부서를 조회하여
--부서코드, 평균 급여(소수점 내림)을 부서코드 내림 차순 조회

SELECT DEPT_CODE, FLOOR(AVG(SALARY)) "급여 평균"
FROM EMPLOYEE
WHERE  (SUBSTR(EMP_NO,1,2)) >= '70' AND (SUBSTR(EMP_NO,1,2)) < '80'
GROUP BY DEPT_CODE 
HAVING AVG(SALARY) >= 3000000
ORDER BY DEPT_CODE DESC;


SELECT DEPT_CODE, FLOOR(AVG(SALARY)) "급여 평균"
FROM EMPLOYEE
WHERE  SUBSTR(EMP_NO,1,2) BETWEEN 70 AND 79
GROUP BY DEPT_CODE 
HAVING AVG(SALARY) >= 3000000
ORDER BY DEPT_CODE DESC;

SELECT DEPT_CODE, FLOOR(AVG(SALARY)) "급여 평균"
FROM EMPLOYEE
WHERE  SUBSTR(EMP_NO,1,1) LIKE '7'
GROUP BY DEPT_CODE 
HAVING AVG(SALARY) >= 3000000
ORDER BY DEPT_CODE DESC;


--------------------------------------------------------------
--------------------------------------------------------------

--집계 함수
--GROUP BY절에 작성하여
--그룹 별로 산출한 결과를 집계하는 함수
--ROLLUP, CUBE가 있음


--ROLLUP : 그룹별로 중간 집계와 전체 합계를 조회

--EMPLOYEE 테이블에서 
--각 부서에 소속된 직급별 급여 합
--부서별 급여 합
--전체 직원의 급여 합을 조회

SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY 1;

--CUBE :그룹으로 지정된 모든 그룹에 대한 중간 집계와 총 합계를 처리하는 함수


SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY 1;
----+
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE 
GROUP BY JOB_CODE
ORDER BY JOB_CODE;


SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY 1;


------------------------------------------------------

---***** SET ORPERRAGON(집합 연산)***********/

--SELECT -> RESULT SET(결과)

--2개 이상의 SELECT 결과 (RESULT SET)을 이용해
--하나의 결과를 조회회하는 연산자

-- 조건에 따른 SELECT 결과가 다른 경우
-- 많이 SELECT를 한번에 조회할 때 유용

--(주의사항) 집합 연산에 사용되는 SELECT문은
--SELECT절의 타입,순서,개수가 동일야한다.

--UNION : 합집합
--INTERSECT :교집합
--UNION ALL:  합집합+고집합
--MINUS : 차집합

--UNION 확인
--부서코드가 'D5'인 사원의 사번, 이름,부서코드 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5';
UNION 


--급여가 300만 초과인 사원의 사번, 이름,부서코드 , 급여 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE SALARY > 3000000;


--INTERSECT 확인 (교집합)
--부서코드가 'D5'이면서 급여 300만 초과인 사원 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE SALARY > 3000000;


--UNION ALL 확인
--부서코드가 'D5' 또는 급여 300만 초과인 사원 조회 (중복 O)

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE SALARY > 3000000;


--MINUS 확인
--부서코드가 'D5' 이지만 급여 300만 초과인 사원 제외 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE 
WHERE SALARY > 3000000;


--집합 연산은 2개 이상의 SELECT 문에 사용 가능
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE
WHERE DEPT_CODE ='D5'
UNION
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE
WHERE DEPT_CODE ='D6'
UNION
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE
WHERE DEPT_CODE ='D9'
UNION 
--SELECT 절의 타입,개수,순서 동일해야한다.
SELECT '이름','부서코드' FROM DUAL;
--쇼핑몰사이트, 신고기능 모아보기

