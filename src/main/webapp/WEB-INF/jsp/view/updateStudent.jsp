<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management | Update Student</title>

<link rel="stylesheet" type="text/css" href="/student-management/resources/main.css">
<style type="text/css">

	.error{
		color: red;
	}

</style>
</head>
<body>
	
	<%@ include file="/WEB-INF/jsp/nav.jspf" %>
	<div align="center" class="container mt-4">
	<h2 class="display-2">Update Student</h2>
	<form:form action="/student-management/students/update-student" modelAttribute="student" cssClass="w-50 p-4">
		
		<form:hidden path="id"/>
		
		<div class="mb-3">
			<form:label path="firstName" cssClass="form-label">First Name: </form:label>
			<form:input path="firstName" cssClass="form-control"/>
			<form:errors cssClass="error" path="firstName" />
		</div>
		
		<div class="mb-3">
			<form:label path="lastName" cssClass="form-label">Last Name: </form:label>
			<form:input path="lastName" cssClass="form-control"/>
			<form:errors cssClass="error" path="lastName" />
		</div>
		
		<div class="mb-3">
			<form:label path="country" cssClass="form-label">Country: </form:label>
			<form:input path="country" cssClass="form-control"/>
			<form:errors cssClass="error" path="country" />
		</div>
		<div class="mb-3">
			<form:label path="phone" cssClass="form-label">Phone no: </form:label>
			<form:input path="phone" cssClass="form-control" />
			<form:errors cssClass="error" path="phone" />
		</div>
		<div class="mb-3">
			<form:label path="rollNo" cssClass="form-label" >Roll No: </form:label>
			<form:input  path="rollNo" cssClass="form-control" />
			<form:errors cssClass="error" path="rollNo" />
		</div>
		<i class="bi bi-plus-circle-fill"></i><input class="btn btn-outline-primary px-4 py-2" type="submit" value="Update" name="Update">
	</form:form>
	</div> 
</body>
</html>