<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>검색 페이지</title>
</head>
<body>
	<h1>회원정보조회(회원정보검색)</h1>
	<form action="<%=request.getContextPath() %> /selectUser">
		<input type="text" name="userNo" placeholder="회원 번호 입력"/>
		<input type="submit" value="조회"/>
	</form>
</body>
</html>