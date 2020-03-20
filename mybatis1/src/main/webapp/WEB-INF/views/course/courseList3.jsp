<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
	<div class="container">
		<h1>과목별 학생 목록</h1>
		
		<c:forEach var="course" items="${courses}">
		<h3>${ course.courseName } <small>${ course.students.size() }명</small></h3>
		<table class="table table-bordered mt5">
			<thead>
				<tr>
					<th>id</th>
					<th>학번</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ course.students }">
					<tr>
						<td>${ student.id }</td>
						<td>${ student.studentNumber }</td>
						<td>${ student.name }</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:forEach>
	</div>
</body>
</html>