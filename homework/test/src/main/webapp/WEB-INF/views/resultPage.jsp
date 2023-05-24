<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <title>결과창</title>
</head>
<body>
    <h1>
    <%= request.getAttribute("name") %>님의 구매 목록</h1>
    <p></p>
    <ul>
        <li>검은 펜 <%= request.getAttribute("blackPenAmount") %>개 :<%= request.getAttribute("blackPenPrice") %> </li>
        <li>빨간 펜 <%= request.getAttribute("redPenAmount") %>개 : <%= request.getAttribute("redPenPrice") %></li>
        <li>파란 펜 <%= request.getAttribute("bluePenAmount") %>개: <%= request.getAttribute("bluePenPrice") %></li>
        <li>화이트 <%= request.getAttribute("whiteAmount") %>개: <%= request.getAttribute("whitePrice") %> </li>
    </ul>
    <p>총 합 <%= request.getAttribute("total") %>원을 결제 하셨습니다.</p>
</body>
</html>
