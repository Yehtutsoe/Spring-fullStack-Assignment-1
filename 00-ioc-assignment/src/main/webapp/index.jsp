<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IoC Container</title>
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
		
		<h1 style="text-align: center; color: green;">COURSES</h1>

		<a href="course-edit" class="btn btn-outline-success">Add New</a>


		<div class="mt-4">

			<c:choose>
				<c:when test="${empty course}">
          <div class="alert alert-danger" role="alert">
            There is no course... Please Add The New Course !
            </div>
				</c:when>

				<c:otherwise>
					<table class="table table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Name</th>
								<th scope="col">Fees</th>
								<th scope="col">Duration</th>
								<th scope="col">Description</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${course }">
								<tr>
									<td>${c.id }</td>
									<td>${c.name }</td>
									<td>${c.fees } Kyats</td>
									<td>${c.duration } Months</td>
									<td>${c.description }</td>
									<td>
									 <c:url var="classes" value="/classes">
									    <c:param name="courseId" value="${c.id }"></c:param>
									 </c:url>
									 <a href="${classes }" style="text-decoration: none">Open Classes</a>
									
									</td>
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