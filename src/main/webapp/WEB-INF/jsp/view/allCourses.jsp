<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management | All courses</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/student-nav.jspf" %>
	<div class="container text-center my-3">
		<h1>All Courses</h1>
	</div>
	

	<div class="d-flex m-4 container-fluid">

		<c:forEach items="${courses }" var="c">
			<div class="card ms-3" style="width: 18rem;">
				<img src="/student-management/resources/images/course.jpg"
					class="card-img-top" alt="...">
				<div class="card-body">
					<div class="text-center container">
						<h5 class="card-title">${c.name }-${c.code }</h5>
					</div>
					<p class="card-text">This course is of ${c.creditHours } Credit
						hours</p>
					<div class="container text-center">
						<a href="<c:url value="register-course/${c.id }" />"
							class="btn btn-primary">Register</a>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>