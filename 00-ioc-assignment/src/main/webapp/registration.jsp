<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
		<h1 style="text-align: center; color: green;">REGISTRATION DATA</h1>

		<div>
			<c:url var="addReg" value="/registration-edit">
				<c:param name="classId" value="${openClass.id}"></c:param>
			</c:url>
			<a href="${addReg }" class="btn btn-outline-success">Add New
				Registration</a>
		</div>

		<div class="mt-4">

			<c:choose>

				<c:when test="${empty reg }">
					<div class="alert alert-danger" role="alert">There is no Registration Data..
					 Please Create New Registration !
						
					</div>
				</c:when>

				<c:otherwise>

					<table class="table table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Teacher</th>
								<th scope="col">Student</th>
								<th scope="col">Phone</th>
								<th scope="col">Email</th>
								<th scope="col">Start Date</th>
								<th></th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${reg }">
								<tr>
									<td>${c.id }</td>
									<td>${c.openClass.teacher }</td>
									<td>${c.student }</td>
									<td>${c.phone}</td>
									<td>${c.email }</td>
									<td>${c.openClass.startDate}</td>

									<td><c:url var="home" value="/">
										</c:url> <a href="${home }" style="text-decoration: none">Home</a></td>


								</tr>
							</c:forEach>

						</tbody>
					</table>


				</c:otherwise>

			</c:choose>


		</div>
	</div>


</body>

</html>