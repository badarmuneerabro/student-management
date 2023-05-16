<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="/student-management/resources/css/main.css">
<title>Student Management | Course Registration</title>
</head>
<body>

	<h1 class="text-center my-2">Course Registration</h1>

	<div class="container-fluid w-50">
		<form:form modelAttribute="studentAndCourseDetails">
			<form:input path="id"/>
			<div class="mb-2">
				<form:label path="rollNo" cssClass="form-label">Roll No:</form:label>
				<form:input path="rollNo" cssClass="form-control" />
				<form:errors path="rollNo" cssClass="error" />
			</div>

			<div class="mb-2">
				<form:label path="firstName" cssClass="form-label">First Name:</form:label>
				<form:input path="firstName" cssClass="form-control" />
				<form:errors path="firstName" cssClass="error" />
			</div>

			<div class="mb-2">
				<form:label path="lastName" cssClass="form-label">Last Name:</form:label>
				<form:input path="lastName" cssClass="form-control" />
				<form:errors path="lastName" cssClass="error" />
			</div>
			
			<div class="mb-2">
				<form:label path="country" cssClass="form-label">Country:</form:label>
				<form:input path="country" cssClass="form-control" />
				<form:errors path="country" cssClass="error" />
			</div>
			
			<div class="mb-2">
				<form:label path="courses" cssClass="form-label">Select Courses: </form:label>
				<br>
				<c:forEach items="${courses }" var="c" varStatus="i">
					<form:checkbox path="courses" value="${c.name }"
						cssClass="form-check-input" />
					<label class="form-check-label">${c.name } - ${c.creditHours }Hrs</label>
					<br>

				</c:forEach>
			</div>
			
			<input class="btn btn-outline-primary" type="submit" value="Register" name="Register">
		</form:form>
	</div>

</body>
</html>