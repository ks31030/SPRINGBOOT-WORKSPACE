<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ��������ȸ����</title>
</head>
<body>
	<h2>ȸ��������ȸ</h2>
	<table>
		<tr>
		<tr>
			<td>ȸ������</td>
			<td>ȸ�����̵�</td>
			<td>ȸ���̸�</td>
			<td>ȸ������</td>
		</tr>
		<c:set var="dto" value="{User}"/>
		<tr>
			<td>${dto.getUserNo()}</td>
			<td>${dto.getUserId()}</td>
			<td>${dto.getUserName()}</td>
			<td>${dto.getUserAge()}</td>
		</tr>
	</table>
	<a href="index.jsp">������������ ���ư���</a>
</body>
</html>