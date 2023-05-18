<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management | Student Details</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/nav.jspf" %>
	<div class="container-fluid text-center fw-bold my-3">
		<h1>Student Details</h1>
		<br> <br>
		<p>ID: ${student.id }</p>
		<p>First Name: ${student.firstName }</p>
		<p>Last Name: ${student.lastName }</p>
		<p>Country: ${student.country }</p>
		<p>Phone No: ${student.phone }</p>
		<p>Roll No: ${student.rollNo }</p>
		<p>Email: ${student.email }</p>
		<p>Password: ${student.password }</p>
	</div>
</body>
</html>