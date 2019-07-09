<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>
<body>
<b><font color="blue" size="6px">[과목 상세정보]</font></b><hr/>

<center>
		<table border="1">

			<tr>
				<th>과목아이디</th>
				<td>${subject.subjectId}</td>
			</tr>
			<tr>
				<th>과목명</th>
				<td>${subject.subjectName}</td>
			</tr>
			<tr>
				<th>학과명</th>
				<td>${subject.deptName}</td>
			</tr>
			<tr>
				<th>과목 설명</th>
				<td>${subject.subjectInfo}</td>
			</tr>

		</table>
<p />

<a href="subjectList.do">[개설가능 과목]</a>
<a href="lectureInsert.do?subId=${ subject.subjectId}">[강의하기]</a>
</center>
</body>
</html>