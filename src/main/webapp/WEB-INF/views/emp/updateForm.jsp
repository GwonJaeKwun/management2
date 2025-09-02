<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/reset.css"/>
	<link rel="stylesheet" href="/css/empHeader.css">
    <link rel="stylesheet" href="/css/mngEatView.css"/>
    <title>결근&조퇴 신청서 수정</title>
    <style>
        .form-container {
            display: flex;
            flex-direction: column;
            gap: 15px;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 8px;
            width: 100%;
            max-width: 500px;
            margin-top: 20px;
        }

        .form-container label {
            font-weight: bold;
            color: #555;
        }
        
        .form-container input,
        .form-container select,
        .form-container textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* 패딩이 너비에 포함되도록 설정 */
        }
        
        .form-container textarea {
            resize: vertical; /* 세로 크기 조절만 가능하도록 */
            min-height: 100px;
        }

        .btn-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<%@ include file="empHeader.jsp" %>
    <div class="content">
        <h1>결근&조퇴 신청서 수정</h1>
        <p>내용을 수정해주세요, ${employeeDTO.name}님!</p>

        <form action="/lateness/eatUpdate" method="post" onsubmit="return checkUpdateForm()">
            <div class="form-container">
                <label for="ness_date">발생날짜:</label>
                <input type="date" name="ness_date" id="ness_date" value="${latenessDTO.ness_date}"><br>
                <input type="hidden" name="original_ness_date" value="${latenessDTO.ness_date}">

                <label for="atte_flag">유형:</label>
                <select name="atte_flag" id="atte_flag">	
                    <option value="3" ${latenessDTO.atte_flag == 3 ? 'selected' : ''}>조퇴</option>
                    <option value="4" ${latenessDTO.atte_flag == 4 ? 'selected' : ''}>결근</option>
                </select><br>

                <label for="content">내용:</label>
                <textarea name="content" id="content" required>${latenessDTO.content}</textarea><br>
                
                <input type="hidden" name="employee_id" value="${latenessDTO.employee_id}">
                <input type="hidden" name="status" value="0">
            </div>

            <div class="btn-group">
                <button type="submit" class="btn approve-btn">수정하기</button>
                <a href="/lateness/eatView" class="btn deny-btn">목록으로 돌아가기</a>
            </div>
        </form>

        <script>
            function checkUpdateForm() {
                const content = document.getElementById('content').value;
                if (content === "") {
                    alert("내용을 입력해주세요.");
                    return false;
                }
                
                if (content.length > 30) {
                    alert("내용은 30자 이내로 작성하시오.");
                    return false;
                }
                return true;
            }
        </script>
    </div>
<script src="/js/nowtime.js"></script>
</body>
</html>