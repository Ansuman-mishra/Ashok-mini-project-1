<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script type="text/javascript">
 
 </script>
  
<style type="text/css">
	.bg{
		background-color: #7CFC00;
	}
	
	.width{
		width:100%	
	}
	
	.container{
		position: relative;
		
	}
	fieldset{
		position: absolute;
		left: 50%;
		top:50%;
		transform: translate(-50%,-50%);
	}
	
	button {
	margin-top: 20px;
}
	
</style>

</head>
<body class="container-fluid">
	<fieldset>
		<legend><h1 class="text-center text-primary">Save Contact</h1></legend>
			<div class="row text-center bg" id="show">
			
				${succMsg} 
				${errMsg}
			</div>
			<div class="form-group">
				<form:form action="saveContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">
		<div class="container">		
			<div class="row">
					<form:hidden path="contactId"/>
					<label>Contact Name</label>
					<div class="input-group width">
                          <form:input class="form-control" path="contactName"/>  
                    </div>
			</div>
			<div class="row">
					<form:hidden path="contactId"/>
					<label>Contact Number</label>
					<div class="input-group width">
                          <form:input class="form-control" path="contactNumber"/> 
                    </div>
			</div>
			<div class="row">
					<form:hidden path="contactId"/>
					<label>Contact Email</label>
					<div class="input-group width">
                          <form:input class="form-control" path="contactEmail"/>
                    </div>
			</div>
			</div>
		<div>
		<button class="btn btn-danger btn-block"><a href="viewContacts">View All Contacts</a></button>
		</div>
	</form:form>
			
			</div>
	
	</fieldset>
</body>
</html>