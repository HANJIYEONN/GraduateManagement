<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>
<body>

	<b><font color="blue" size="6px">[내 강의목록]</font></b>
	<hr/>
<center>
<table border = "1" >
	<tr>
		<th>강의등록번호</th>
		<th>과목명</th>
		<th>강의</th>
	</tr>

<c:forEach items="${lectureList}" var="lecture">

				<tr>
					<td>${lecture.lecNum }</td>
					<td>${lecture.subjectName}</td>
					<td><a href="lectureDelete.do?lecNum=${lecture.lecNum }">폐강</a></td>
				</tr>

</c:forEach>		

</table>
	<a href="main.do">[교수 메인으로]</a>
	<a href="subjectList.do">[개설가능 과목]</a>
</center>
</body>
</html>