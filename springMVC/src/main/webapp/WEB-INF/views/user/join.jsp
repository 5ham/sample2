<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.3.min.js"></script>
<script>
	function checkId(){
		var contextPath = '<%=request.getContextPath()%>';
		//ajax 아이디 중복체크
		$.ajax({
			url:contextPath+"/ajax/checkID.do",
			type:"get",
			data:{id : $("#uid").val()},
			success:function(data){
				if(data == '0'){
					alert("사용할 수 없는 아이디입니다.");
					$("#uid").val('');
				}else if(data == '1'){
					alert("사용할 수 있는 아이디입니다.");
				}
			},
			error:function(){
				alert("예외 발생!");
			}
		});
	}
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form name="frm" action="join.do" method="post">
		
		<table>
			<tr>
				<th align="right">id :</th>
				<td><input type="text" name="uid" id="uid"><button type="button" onclick="checkId()">중복확인</button></td>
			</tr>
			<tr>
				<th align="right">password :</th>
				<td><input type="password" name="upw"></td>
			</tr>
			<tr>
				<th align="right">name :</th>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<th align="right">gender :</th>
				<td><input type="radio" name="ugender" value="M">M
					<input type="radio" name="ugender" value="F">F
				</td>
			</tr>
		</table>
		<button>회원가입</button>
	</form>
</body>
</html>