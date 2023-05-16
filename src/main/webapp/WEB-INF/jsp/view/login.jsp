<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management | Login</title>
</head>
<body>
	<h1 class="text-center my-2 display-1">Login Please!!</h1>

	<div class="container-fluid w-50">
		<c:if test="${errorMsg != null }">
			<div class="alert alert-danger" role="alert">${errorMsg }</div>
		</c:if>
		
		<form:form modelAttribute="loginForm">

			<div class="mb-2">
				<form:label path="email" cssClass="form-label">Email: </form:label>
				<form:input path="email" cssClass="form-control" />
			</div>

			<div>
				<form:label path="password" cssClass="form-label">Password: </form:label>
				<form:password path="password" cssClass="form-control" />
			</div>

			<div class="container text-center mt-2">
				<input type="submit" value="Login" name="submit"
					class="btn btn-outline-primary">
			</div>
		</form:form>

	</div>
</body>
</html>