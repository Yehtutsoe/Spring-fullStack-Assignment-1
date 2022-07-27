<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Edit</title>
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
		<h1 style="text-align: center; color: green;">ADD NEW COURSE</h1>

		<div class="row" style="margin-left: 450px; margin-top: 60px">
			<div class="col-6">
				<c:url var="save" value="/courses"></c:url>

				<form action="${save}" method="post">

					<div class="mb-4">
						<label for="name" class="form-label"><b>Course Name</b></label> <input
							type="text" class="form-control" name="name"
							placeholder="Enter Course Name !" autocomplete="off"
							required="required" />
					</div>
					<!-- End of Course Name -->

					<div class="mb-4">
						<label for="fees" class="form-label"><b>Fees</b></label> <input
							type="number" class="form-control" name="fees"
							placeholder="Enter Course's Fees !" autocomplete="off"
							required="required" />
					</div>
					<!-- End of Course's Fees -->


					<div class="mb-4">
						<label for="duration" class="form-label"><b>Duration</b></label> <input
							type="number" class="form-control" placeholder="Enter Duration !"
							name="duration" autocomplete="off" required="required" />
					</div>
					<!-- End of Course's Duration -->

					<div class="mb-4">
						<label for="description" class="form-label"><b>Description</b></label>
						<textarea rows="4" cols="40" name="description"
							class="form-control" placeholder="Please Enter Description !"></textarea>
					</div>
					<!-- End of Course's Description -->

					<input type="submit" value="Save Course" class="btn btn-primary mx-2">
                    <!-- End of Submit Button -->
                    <input type="reset" value="Clear Course" class="btn btn-danger">
				</form>
				<!-- End Of Form -->
			</div>
		</div>
	</div>


</body>
</html>