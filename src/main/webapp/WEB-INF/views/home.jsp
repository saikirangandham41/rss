<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Welcome to product inventory</h2>
		<form class="form-horizontal" action="loginFormSubmit" method="POST"
			id="loginFrom">
			<div class="form-group">
				<label class="col-sm-12 text-danger text-center">
					${loginFormError}</label>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<input class="form-control" id="username" name="username"
						placeholder="Enter username" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Enter password" required="required"
						maxlength="50">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
