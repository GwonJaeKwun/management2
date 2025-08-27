<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style> 
</head>
<body>
   <main>
    <h2>지각&조퇴&결근 신청</h2>
    <table>
    <tr>
        <td>날짜</td>
	    <td>형태</td>
	    <td>사유</td>
	    <td>승인상태</td>
	    <td>수정</td>
	    <td>삭제</td>
    </tr><br>
    
    <tr>
    <td colspan="6">
    <a href ="/lateness/createForm">신청하기</a><br>
    </td>
    </tr>
    
    <!--  TODO c:forEach -->
   <c:forEach var="lateness" items="${latenessList}">
    <tr>
      <td>${ latenessDTO.ness_date }</td>
      <td>${ latenessDTO.type }</td>
      <td>${ latenessDTO.content }</td>
      <td>${ latenessDTO.status == 0 ? '미승인' : '승인' }</td>
      <td></td>
      <td></td>
    </tr>
   </c:forEach>
    </table>
   </main>
</body>
</html>