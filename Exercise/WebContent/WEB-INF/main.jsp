<%@page import="exe.entity.TeacherEntity"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 시스템</title>
</head>
<style>
	p 	{
		font-size:20px;
		color:blue;
		text-align : center;
		}	
</style>
</head>
<body>

<b><font color="blue" size="6px">[교수 메인 페이지]</font></b><hr/>
<center>

<h3>

 <font color="blue" size="4px">[${ teacher.teacherName }]교수님 환영합니다 </font><br/> <br/>
</h3>
<p>
<a href="teacherUpdateForm.do">[교수 정보수정]</a>
<a href="lectureList.do">[내 강의과목]</a>
<a href="logout.do">[로그아웃]</a>
</p>

</center>
</body>
</html>