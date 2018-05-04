<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Product</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" action="deleteProductForm"
			id="removeProduct" method="GET">
			<div class="form-group">
				<div class="col-md-3">
					<label>ItemId</label>
				</div>
				<div class="col-md-3">
					<input class="form-control" type="text" id="itemId" name="itemId"
						class="inputboxBg selectWidth45" value="${itemId}"
						required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-3">
					<label>Qty</label>
				</div>
				<div class="col-md-3">
					<input class="form-control" type="number" id="quantity"
						name="quantity" class="inputboxBg selectWidth45" value="${qty}"
						required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-3">
					<label>Name</label>
				</div>
				<div class="col-md-3">
					<input class="form-control" type="text" id="name" name="name"
						class="inputboxBg selectWidth45" value="${name}"
						required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-3">
					<label>Description</label>
				</div>
				<div class="col-md-3">
					<input class="form-control" type="text" id="description"
						name="description" class="inputboxBg selectWidth45"
						value="${description}" required="required">
				</div>
			</div>
			<div class="form-group">
				<input type="submit" value="Delete?" class="btn btn-danger">
			</div>
		</form>
	</div>
</body>
</html>