<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산기</h2>
	<form name="frm" action="calcResult.do" method="post">
		num1 : <input type="number" name="num1">
		<br>
		num2 : <input type="number" name="num2">
		<br>
		<input type="radio" name="oper" value="plus">+
		<input type="radio" name="oper" value="minus">-
		<input type="radio" name="oper" value="multi">*
		<input type="radio" name="oper" value="divide">/
		<br>
		<button>계산</button>
	</form>
</body>
</html>