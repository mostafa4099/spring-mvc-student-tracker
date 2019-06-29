<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student List</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Info</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			
			<input type="button" value="Add Student" class="add-button" 
				onclick="window.location.href='showFormForAdd'; return false;"
			/>
			
			<form:form action="search" method="POST">
                Search customer: <input type="text" name="searchName" />
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempStudent" items="${student}">
				
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempStudent.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempStudent.id}"/>
					</c:url>
					
					<tr>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.email}</td>
						
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure want to delete this student?'))) return false">Delete</a>
						</td>
						
					</tr>
					
				</c:forEach>
				
			</table>
			
		</div>
		
	</div>
	
</body>

</html>