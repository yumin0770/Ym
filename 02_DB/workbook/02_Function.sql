--영어영문학과(학과코드 002) 학생들의 학번,이름,입학 년도를 입학년도가 빠른 순으로 표시하는 문장 작성

SELECT STUDENT_NO,STUDENT_NAME,ENTRANCE_DATE
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE;

--춘 기술대 교수중 이름이 세글자가 아닌 교수 1명 있다. 그 교수의 이름,주민번호 출력

SELECT PROFESSOR_NAME, PROFESSOR_SSN 
FROM TB_PROFESSOR
WHERE PROFESSOR_NAME NOT LIKE '___';

--3.춘 기술대 남자 교수들 이름,나이 출력, 단 나이 순 교수이름, 만나이

SELECT PROFESSOR_NAME 교수이름,  FLOOR((SYSDATE-(TO_DATE(SUBSTR(PROFESSOR_SSN ,1,6)),'RRYYMM'))/365)
FROM TB_PRSSOR
WHERE SUBSTR(PROFESSOR_SSN,8,1) = '1'; 
--***********************************************************************

--4.교수이름 중 성을 제외한 이름만 출력해라

SELECT SUBSTR(PROFESSOR_NAME,2,3)
FROM TB_PROFESSOR ;

--SELECT SUBSTR(‘SHOWMETHEMONEY‘, 5, 2) FROM DUAL; ME

--5.춘 기술 대학교 재수쟁 입학자
--19살에 입학면 재수생x


--***********************************************************************
--6.2020년 크리스마슨 무슨 요일인가?

SELECT TO_CHAR(TO_DATE('20201225','YYYYMMDD'),'DAY') FROM DUAL;

--7.TO_DATE(99/10/11, YYMM/DD)
--***********************************************************************
--8.춘기술대학교 2000년도 입학자들은 학번이 A로 시작,2000년도 이전 학번은 학생들의 학번과 이름 보여주는 문장

SELECT STUDENT_NO, STUDENT_NAME 
FROM TB_STUDENT 
WHERE ENTRANCE_DATE < '2000-01-01';

--9.학번 A517178인 한아름 학생의 학점 총 평점을 구하는 문/점수 반올림하여 소수점 이하 한자리까지 표현

SELECT ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';


--10. 학과별 학생수 구하여 "학과번호", "학생수(명)"의 형태로

SELECT DEPARTMENT_NO 학과번호, COUNT(*)
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO; 

--11.지도교수를 배정받지 못 한 학생수 몇 명 정도 

SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

--12. 학번이 A112113 김고운 학생의 년도 별 평점을 구하나는 SQL

SELECT TERM_NO,CEIL(AVG(POINT))
FROM TB_GRADE
WHERE STUDENT_NO IN 'A112113'
GROUP BY TERM_NO;




--13. 학과 별 휴학생 수 파악, 학과 번호와 휴학생 수

SELECT DEPARTMENT_NO, NVL(COUNT(ABSENCE_YN),0)
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
GROUP BY DEPARTMENT_NO 
ORDER BY DEPARTMENT_NO ;


--14.춘 대학교에 다니는 동명이인 학생들으 이름 찾고자 한다.

SELECT STUDENT_NAME ,COUNT(*)
FROM TB_STUDENT 
GROUP BY STUDENT_NAME 
HAVING COUNT(*) > 1
ORDER BY STUDENT_NAME ;	

--15.학번이 A112113인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점, 총 평점

--200601


SELECT NVL(SUBSTR(TERM_NO,1,4),'') 년도,NVL(SUBSTR(TERM_NO,5,2),' ') 학기,
		ROUND(AVG(POINT),1) AS 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113' 
GROUP BY ROLLUP (SUBSTR(TERM_NO,1,4),SUBSTR(TERM_NO,5,2));




