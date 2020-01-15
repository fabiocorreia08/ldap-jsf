<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>EFAD</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
</head>
<body class="d-flex flex-column h-100">
	<header>      
     
    </header>
    
    <main role="main" class="flex-shrink-0">
      <div class="container">
      	<br></br>
      	<br></br>
      	<h2>Person</h2>
      	<br></br>
      	     	
		<br></br>
		<table class="table table-striped">
			<thead>
				
				<th scope="raw">uid</th>	
				<th scope="raw">fullName</th>	
				<th scope="raw">lastName</th>
				<th scope="raw">description</th>
				<th scope="raw">physicalDeliveryOfficeName</th>
				<th scope="raw">UpDate</th>				
				
			</thead>
			<tbody>
				<c:forEach items="${personList}" var="person">
					<tr>
						
						<td>${person.uid }</td>
						<td>${person.fullName }</td>
						<td>${person.lastName }</td>
						<td>${person.description }</td>
						<td>${person.physicalDeliveryOfficeName }</td>
						<td>
							<s:url value="/person/update/${person.uid }" var="updateURL"/>
							<a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
						</td>
					</tr>				
				</c:forEach>
			</tbody>
		</table>
				
      </div>
    </main>	
</body>
</html>