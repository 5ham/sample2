<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="true" %> --%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
<h1>
	<c:if test="${not empty login }">${login.uname} 님!</c:if> Hello world! 
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="<%=request.getContextPath()%>/sample.do">sample.do 로 이동!</a> 
<br>
<a href="<%=request.getContextPath()%>/board/list.do">게시글 목록으로!</a>
<br>
<c:if test="${empty login }">
	<a href="<%=request.getContextPath()%>/user/login.do">로그인</a> |
	<a href="<%=request.getContextPath()%>/user/join.do">회원가입</a>
</c:if>
<c:if test="${not empty login }">
<a href="<%=request.getContextPath()%>/user/logout.do">로그아웃</a>
</c:if>
<br>
<a href="<%=request.getContextPath()%>/calc.do">계산하러가기</a>
<br>
<a href="<%=request.getContextPath()%>/ajax/main.do">ajax 예제 페이지로!!</a>
<br>
<a href="<%=request.getContextPath()%>/upload/ex01.do">파일 업로드 예제로 가기</a>

samplesamplesample
</body>
</html>
