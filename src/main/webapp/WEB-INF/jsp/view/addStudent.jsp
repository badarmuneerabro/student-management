<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management | Add Student</title>

<style type="text/css">

	.error{
		color: red;
	}

</style>
</head>
<body>
	
	<div align="center">
	<h2>Add Student</h2>
	<form:form modelAttribute="student">
		<form:label path="firstName">First Name: </form:label>
		<form:input path="firstName"/>
		<br>
		<form:errors cssClass="error" path="firstName" />
		<br> 
		
		<form:label path="lastName">Last Name: </form:label>
		<form:input path="lastName"/>
		<br>
		<form:errors cssClass="error" path="lastName" />
		<br> 
		
		<form:label path="country">Country: </form:label>
		<form:input path="country"/>
		<br>
		<form:errors cssClass="error" path="country" />
		<br> 
		
		<form:label path="phone">Phone no: </form:label>
		<form:input path="phone"/>
		<br>
		<form:errors cssClass="error" path="phone" />
		<br>
		
		<form:label path="rollNo">Roll No: </form:label>
		<form:input  path="rollNo"/>
		<br>
		<form:errors cssClass="error" path="rollNo" />
		<br>
		
		<input type="submit" value="Add" name="Add">
	</form:form>
	</div> 
</body>
</html>