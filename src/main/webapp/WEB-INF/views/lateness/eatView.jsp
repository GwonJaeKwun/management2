<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>지.결.조. 기록 및 조회</title>
</head>
<body>
    <h1>지.결.조. 기록 및 조회</h1>
    <p>환영합니다, ${employeeDTO.name}님!</p>

    <!-- 신청하기 버튼 추가 -->
    <a href="/lateness/createForm">
        <button>신청하기</button>
    </a>

    <hr>

    <h2>기존 기록 목록</h2>
    <table>
        <thead>
            <tr>
                <th>사번</th>
                <th>날짜</th>
                <th>유형</th>
                <th>내용</th>
                <th>상태</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="lateness" items="${LatenessDTOList}">
                <tr>
                    <td>${lateness.employee_id}</td>
                    <td>${lateness.ness_date}</td>
                    <td>
                        <c:choose>
                            <c:when test="${lateness.type == 0}">지각</c:when>
                            <c:when test="${lateness.type == 1}">결근</c:when>
                            <c:otherwise>조퇴</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${lateness.content}</td>
                    <td>${lateness.status == 0 ? '미승인' : '승인'}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
