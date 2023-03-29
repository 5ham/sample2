<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var updateYN = '${param.updateYN}';
	window.onload = function(){
		if(updateYN == 'N'){
			alert("수정실패");
		}
	}
</script>
</head>
<body>
	<h2>게시글 상세조회</h2>
	<table>
		<tr>
			<th align="right">제목 :</th>
			<td>${vo.btitle }</td>
		</tr>
		<tr>
			<th align="right">종류 :</th>
			<td>
				<c:if test="${vo.bkind eq 'J' }">자바</c:if>
				<c:if test="${vo.bkind eq 'H' }">HTML</c:if>
			</td>
		</tr>
		<tr>
			<th align="right">작성일 :</th>
			<td>${vo.bwdate}</td>
		</tr>
		<tr>
			<th align="right">조회수 :</th>
			<td>${vo.bhit }</td>
		</tr>
		<tr>
			<th align="right">내용 :</th>
			<td>${vo.bnote }</td>
		</tr>
	</table>
	<c:if test="${not empty login and login.uno eq vo.uno }">
		<button onclick="location.href='modify.do?bno=${vo.bno}'">수정</button>
		<button onclick="document.delfrm.submit();">삭제</button>
		<form name="delfrm" action="delete.do" method="post">
			<input type="hidden" name="bno" value="${vo.bno }">
		</form>
	</c:if>
</body>









</html>