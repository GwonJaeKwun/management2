<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>결근&조퇴 신청서 작성</title>
</head>
<body>
    <h1>결근&조퇴 신청서 작성</h1>
    <p>신청서를 작성해주세요, ${employeeDTO.name}님!</p>

    <form action="/lateness/eatCreate" method="post">
        날짜: <input type="date" name="ness_date" required><br>
        유형:
        <select name="type">
            <option value="" disabled selected>선택하시오</option>	
            <option value="3">조퇴</option>
            <option value="4">결근</option>
        </select><br>
        내용: <textarea name="content" required></textarea><br>
        <input type="hidden" name="status" value="0">
        <button type="submit">신청하기</button>
    </form>

    <a href="/lateness/eatView">목록으로 돌아가기</a>

</body>
</html>