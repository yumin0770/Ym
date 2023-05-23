<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH 온라인 문방구</title>
</head>
<body>
    <h1>KH 온라인 문방구</h1>
    <form action="/orderProduct.do" method="post">
        <table border="1px">
            <thead>
                <th colspan="3">주문자명</th>
            </thead>
                <tbody>
                <td colspan="3">
                    <input type="text" name="name" id="name">
                </td>
                <tr>
                    <th>품목</th>
                    <th>가격</th>
                    <th>수량</th>
                </tr>    
                <tr>
                    <td><label name="blackPen" for="blackPen">검정 펜</label></td>
                    <td name="blackPenPrice" value="500">500원</td>
                    <td><input type="number" name="blackPenAmount" id="blackPen" min="0" max="100" value="0"></td>
                </tr>
                <tr>
                    <td><label name="redPen" for="redPen">빨간 펜</label></td>
                    <td name="redPenPrice" value="700">700원</td>
                    <td><input type="number" name="redPenAmount" id="redPen" min="0" max="100" value="0"></td>
                </tr>
                <tr>
                    <td><label name="bluePen" for="bluePen">파란 펜</label></td>
                    <td name="bluePenPrice" value="700"> 700원</td>
                    <td><input type="number" name="bluePenAmount" id="bluePen" min="0" max="100" value="0"></td>
                </tr>
                <tr>
                    <td><label name="white" for="white">화이트</label></td>
                    <td name="whitePrice" value="1000" >1000원</td>
                    <td><input type="number" name="whiteAmount" id="white" min="0" max="100" value="0"></td>
                </tr>
                <td colspan="3" style="text-align: center">
                    <input type="submit" value="구매">
                    <input type="reset" value="초기화">
                </td>
            </tbody>
        </table>
    </form>
</body>
</html>