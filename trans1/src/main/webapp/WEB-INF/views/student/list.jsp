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
</head>
<body>
	<div class="container">
		<h1>학생목록</h1>
		<table class="table table-bordered mt5">
			<thead>
				<tr>
					<th>id</th>
					<th>학번</th>
					<th>이름</th>
					<th>학과</th>
					<th>학년</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ students }">
					<tr>
						<td>${ student.id }</td>
						<td>${ student.studentNumber }</td>
						<td>${ student.name }</td>
						<td>${ student.departmentName }</td>
						<td>${ student.year }</td>
						<td><a class="btn btn-info btn-sm"
							href="delete?id=${ student.id }" onclick="confirm('삭제하시겠습니까?')">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>