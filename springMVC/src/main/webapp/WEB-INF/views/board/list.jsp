<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.study.vo.BoardVO" %>
<%
	List<BoardVO> blist = (List<BoardVO>)request.getAttribute("blist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 목록 페이지</h2>
	
	<form name="frm" action="list.do" method="get">
		<select name="searchType">
			<option value="title" <c:if test="${param.searchType eq 'title'}">selected</c:if>>제목</option>
			<option value="writer" <c:if test="${param.searchType eq 'writer'}">selected</c:if>>작성자</option>
		</select>
		<select name="searchKind">
			<option value="J"<c:if test="${param.searchKind eq 'J'}">selected</c:if>>자바</option>
			<option value="H"<c:if test="${param.searchKind eq 'H'}">selected</c:if>>HTML</option>
		</select>
		<input type="text" name="searchValue" value="${param.searchValue }">
		<button>검색</button>
	</form>
	
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글종류</th>
		</tr>
		<c:forEach var="vo" items="${blist}"> <!-- for(BoardVO vo : blist) -->
		<tr>
			<td>${vo.bno}</td>
			<td><a href="view.do?bno=${vo.bno }">${vo.btitle}</a></td>
			<td>${vo.bkind}</td>
		</tr>
		</c:forEach>
	</table>
	<c:if test="${not empty login }">
	<button onclick="location.href='write.do'">등록</button>
	</c:if>
</body>
</html>