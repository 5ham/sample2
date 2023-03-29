<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form name="frm" action="login.do" method="post">
		<table>
			<tr>
				<th align="right">id :</th>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<th align="right">password :</th>
				<td><input type="password" name="upw"></td>
			</tr>
		</table>
		<button>로그인</button>
	</form>
</body>
</html>