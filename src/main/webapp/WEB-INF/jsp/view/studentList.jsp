<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management | All Students</title>

<link type="text/css" rel="stylesheet" href="/student-management/resources/css/main.css">

<style type="text/css">

	table{
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/nav.jspf" %>
	<h1 align="center" class="display-1">Student Management</h1>
	
	<div class="container" >
	<button class="btn btn-outline-primary btn-md px-4 py-2"><a href="<c:url value="add-student" />" class="text-black">Add</a>  </button>
	<table class="table table-stripped table-hover text-center mt-2">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Country</th>
				<th>Phone</th>
				<th>Roll No</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		
		<tbody style="font-size: 1.7rem;">
			
			<c:forEach var="student" items="${students }">
				
				<tr>
					<td>${student.id }</td>
					<td>${student.firstName }</td>
					<td>${student.lastName }</td>
					<td>${student.country }</td>
					<td>${student.phone }</td>
					<td>${student.rollNo }</td>
					
					<td><a href="<c:url value="update-student/${student.id }" />">Update</a> | 
					<a href="<c:url value="delete-student/${student.id }" />">Delete</a></td>
				</tr>
			
			</c:forEach>
			
		</tbody>
		
		<tfoot>
			<tr class="table-info">
				<th colspan="6">Total</th>
				<td>${students.size() }</td>
			</tr>
		</tfoot>
	</table>
	
	</div>
</body>
</html>