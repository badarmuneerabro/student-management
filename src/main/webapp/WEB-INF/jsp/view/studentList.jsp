<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management | All Students</title>

<style type="text/css">

	table{
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1 align="center">Student Management</h1>
	
	<div align="center">
	
	<a href="<c:url value="add-student" />"> <button>Add</button> </a>
	<table border="2">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Country</th>
				<th>Phone</th>
				<th>Roll No</th>
			</tr>
		</thead>
		
		
		<tbody>
			
			<c:forEach var="student" items="${students }">
				
				<tr>
					<td>${student.id }</td>
					<td>${student.firsName }</td>
					<td>${student.lastName }</td>
					<td>${student.country }</td>
					<td>${student.phone }</td>
					<td>${student.rollNo }</td>
					
					<td><a href="<c:url value="update-student/${student.id }" />">Update</a> | 
					<a href="<c:url value="delete-student" />">Delete</a></td>
				</tr>
			
			</c:forEach>
			
		</tbody>
		
		<tfoot>
			<tr>
				<th colspan="5">Total</th>
				<td>${students.size() }</td>
			</tr>
		</tfoot>
	</table>
	
	</div>
</body>
</html>