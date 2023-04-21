<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL 조건문</title>
</head>
<body>
    <h1>4. 조건문 - if (c:if 태그) </h1>
    <pre>
        - 단독 if문(c:else 없음)

        -속성은 test만 존재함

        **주의사항**
        1) test의 속성 값은 무조건 EL구문으로 작성해야한다!!
        2) test의 속성 값은 true 또는 false가 나오는 조건식이여야만 한다. 
        3) test의 속성 값을 작성하는 ""내부에는 공백이 존재해서는 안된다.

        if(  a== b  )-> 공백xx
    </pre>

    request에 세팅된 name : ${name} <%-- 홍길동 --%>
    <br>
    request에 세팅된 money : ${money} <%-- 50000 --%>

    <br>
    <c:if test="${ money == 50000 }" > <%--"   ${ money == 50000 }   " > 띄어쓰기 ㄴㄴ --%>
        <h3 style="color:gold">돈이 5만원이 있습니다.</h3> 
    </c:if>

	<h3>EL에서 문자열 비교는 == 또는 eq / != 또는 ne 사용</h3>
	<h3>EL에서 문자열은 ''(홑따옴표)로 표현</h3>

	<c:if test="${name eq '홍길동'}">
        <h3>이름이 일치합니다</h3>
	 </c:if>
    <%-- else역할 --%> <%-- 안 나옴 --%> <%-- 비교를 두번해서 효율이 떨어진다! --%>
     <c:if test="${name ne '홍길동'}">
        <h3>이름이 일치하지 않습니다</h3>
	 </c:if>

    <hr>

    <h1>5.조건문 - choose , when, then, otherwise(if~ else if~ else) </h1>

    <pre>
        choose : when. otherwise 태그를 감사는 태그
                (이 안에 if~else if ~ else를 쓰겠다)
        when : if, else if 역할의 태그
                속성은 test 밖에 없음
        otherwise(그렇지 않으면) : else 역할, 속성 X (이도저도 아닌 나머지)
    </pre>
    <%-- queryString : 주소에 작성된 파라미터 문자열 --%>

    <%-- http://localhost/jstl/condition?val=777
        queryString 바꿔가면서 테스트 --%>
   <%-- 
    lt (little) : < 미만
    gt (greater): > 초과

    le (little or equals) : <= 이하
    ge (greater or equals) : >= 이상

    --%>
    <c:choose> <%-- when은 if문과 비슷하다~! --%>
       <c:when test="${param.val gt 100}">
        100 초과
       </c:when>
         
         <c:when test="${param.val lt 100}">
         100 미만
          </c:when>
    
       <c:otherwise>
        100과 같다
       </c:otherwise>
    </c:choose>

    



</body>
</html>
