<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main>
 <h2>신청하기</h2> 
 <form action="/lateness/eatCreate" method="POST">
   <table>
    <tr>
    <td>이름</td>
    <td>${employeeDTO.name }</td>
    </tr>
    <tr>
     <td>부서</td>
     <td>${employeeDTO.department_id }</td>
    </tr>
    <tr>
     <td>사번</td>
     <td>${employeeDTO.employee_id }</td>
    </tr>
    <tr>
     <td>직급</td>
     <td>${employeeDTO.position_id }</td>
    </tr>
    <tr>
     <td>분류</td>
     <td><select id="Type" name="Type">
         <option value="결근">결근</option> 
         <option value="조퇴">조퇴</option> 
     </td>
    </tr>
    <tr>
     <td>발생날짜</td>
     <td><input type="datetime-local" name="Ness_date"/></td>
    </tr>
    <tr>
     <td>사유</td>
     <td><input type="Text" name="Content"/></td>
    </tr>
    <tr>
    <td colspan = "2"></td>
    <td><input type="submit" value="신청"></td>
    <td><input type="submit" value="취소" ></td>
   </table>
 </form>
 </main>
 <script>
 </script>
</body>
</html>