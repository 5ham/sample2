<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드 예제</h2>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="file1">
		<input type="file" name="file2">
		<input type="file" name="file3">
		<button>업로드</button>
	</form>
	<c:if test="${not empty param.uploadFileName }">
		<img src="<%=request.getContextPath()%>/resources/uploadFile/${param.uploadFileName}">
	</c:if>
</body>
</html>