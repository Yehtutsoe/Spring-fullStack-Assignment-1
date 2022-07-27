<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Edit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>


</head>
<body style="background-color: silver;">

	<div class="container mt-4">
		<h1 style="text-align: center; color: green;">REGISTRATION FORM</h1>

		<div class="row" style="margin-left: 450px; margin-top: 60px">
			<div class="col-6">
				<c:url var="save" value="/registration">
					<c:param name="classId" value="${openClass.id}"></c:param>
				</c:url>
				<form action="${save}" method="post">
				
				

					<div class="mb-4">
						<label for="student" class="form-label"><b>Student Name</b></label> <input
							type="text" class="form-control" name="student"
							placeholder="Enter Student Name !" required="required" />
					</div>
					<!-- End of Student Name -->
					
					<div class="mb-4">
						<label for="phone" class="form-label"><b>Phone Number</b></label> <input
							type="number" class="form-control" name="phone"
							placeholder="Enter Phone Number !" required="required" />
					</div>
					<!-- End of Student's Phone Number -->
					
					<div class="mb-4">
						<label for="email" class="form-label"><b>Email</b></label> <input
							type="text" class="form-control" name="email"
							placeholder="Enter Email!" required="required" />
					</div>
					<!-- End of Student Name -->

					

					<input type="submit" value="Save Registration" class="btn btn-primary ">
					<input type="submit" value="Clear Registration" class="btn btn-danger mx-2" >
					<!-- End of Submit Button -->
				</form>
				<!-- End Of Form -->
			</div>
		</div>
	</div>


</body>
</html>