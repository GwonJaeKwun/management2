<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>결근&조퇴 기록 및 조회</title>
</head>
<body>
    <h1>결근&조퇴 기록 및 조회</h1>
    <p>${employeeDTO.department_name } ${employeeDTO.name}님!</p>

    <!-- 신청하기 버튼 추가 -->
    <a href="/lateness/createForm">
        <button>신청하기</button>
    </a>

    <hr>

    <h2>기존 기록 목록</h2>
    <table>
        <thead>
            <tr>
                <th>등록날짜</th>
                <th>적용날짜</th>
                <th>유형</th>
                <th>내용</th>
                <th>상태</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="lateness" items="${LatenessDTOList}">
                <tr>
                    <td>${lateness.created_date }</td>
                    <td>${lateness.ness_date}</td>
                    <td>
                        <c:choose>
                            <c:when test="${lateness.type == 3}">조퇴</c:when>
                            <c:when test="${lateness.type == 4}">결근</c:when>
                        </c:choose>
                    </td>
                    <td>${lateness.content}</td>
                    <td>${lateness.status == 0 ? '미승인' : '승인'}</td>
					<td>
					    <a href="/lateness/eatUpdateView?employee_id=${lateness.employee_id}&ness_date=${lateness.ness_date}">수정</a>
					</td>
                    <td>
                     <a href="/lateness/delete?employee_id=${lateness.employee_id}&ness_date=${lateness.ness_date}">삭제</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
