<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>CFAD</title>
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
        <s:url value="/person/save" var="saveURL"/>
		<h2>Person</h2>
		<form:form modelAttribute="personForm" method="post" action="${saveURL }" cssClass="form">		
			<div class="form-group">
				<label>dn</label>
				<form:input path="dn" type="text" class="form-control" id="dn" placeholder="DN" disabled="true"/>
			</div>		
			<div class="form-group">
				<label>uid</label>
				<form:input path="uid" type="text" class="form-control" id="uid" placeholder="Uid" disabled="true"/>
			</div>
				
			<div class="form-group">
				<label>fullName</label>
				<form:input path="fullName" type="text" class="form-control" id="fullName" placeholder="FullName" disabled="true"/>
			</div>
			<div class="form-group">
				<label>lastName</label>
				<form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="LastName" disabled="true"/>
			</div>
			<div class="form-group">
				<label>description</label>
				<form:input path="description" type="text" class="form-control" id="description" placeholder="description" />
			</div>	
			<div class="form-group">
				<label>physicalDeliveryOfficeName</label>
				<form:input path="physicalDeliveryOfficeName" type="text" class="form-control" id="physicalDeliveryOfficeName" placeholder="physicalDeliveryOfficeName" disabled="true" />
			</div>					
			
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
      </div>
    </main>

</body>
</html>