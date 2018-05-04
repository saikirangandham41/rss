<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, target-densityDpi=device-dpi, user-scalable=no" />
<title>Welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>

	<!--Code Starts Here-->
	<div class="container">
		<div class="orangeText boldText padding10"
			style="color: orange; font-size: 25px;">Home Page: Product
			Management</div>
		<div class="headerBarblock">
			<div class="floatLeft paddingLeft10"
				style="border: 1px solid #4CAF50; background-color: #80ced6; padding: 5px; color: white;">-
				Product Inventory</div>
			<div class="clear"></div>
		</div>
		<br>
		<!-- Below class to show LEFT and Right border -->
		+
		<form class="form-horizontal" action="addProductForm" method="POST"
			id="addProduct">

			<div class="form-group row">
				<div class="col-xs-3">
					<input class="form-control" type="number" id="quantity"
						name="quantity" class="inputboxBg selectWidth45" placeholder=""
						required="required"> <label for="ex1">*Qty</label>
				</div>
				<div class="col-xs-3">
					<input class="form-control" id="itemId" name="itemId" type="text"
						class="inputboxBg selectWidth80" size="15" maxlength="15"
						placeholder="" required="required"> <label for="ex1">*Item
						ID, UPC, SIM, or IMEI</label>
				</div>
				<div class="col-xs-3">
					<input class="form-control" id="name" name="name" type="text"
						class="inputboxBg selectWidth80" size="15" maxlength="15"
						placeholder="" required="required"> <label for="ex1">*Name</label>
				</div>
				<div class="col-xs-3">
					<input class="form-control" id="description" name="description"
						type="text" class="inputboxBg selectWidth80" placeholder="">
					<label for="ex1">Description</label>
				</div>
				<div class="col-xs-3">
					<input type="submit" value=" Quick add " class="btn btn-primary">

				</div>
			</div>

		</form>

	</div>
	<div class="container1">
		<div class="spacer2">
			<table style="width: 100%" class="table table-striped">
				<div class="sharpblueBar"
					style="border: 1px solid #4CAF50; background-color: #80ced6; padding: 5px; color: white;">Added
					Items</div>
				<thead>
					<c:forEach items="${products}" var="p">
						<tr>
							
								<td><a href="editProduct/${p.itemId}">edit</a></td>
							<td><a href="deleteProduct/${p.itemId}"><span class="glyphicon glyphicon-trash"></span></a></td>								
							<td>${p.name}</td>
							<td>${p.quantity}</td>
							<td>${p.itemId}</td>
							<td>${p.description}</td>
						</tr>
					</c:forEach>
				</thead>
			</table>
			<br>
		</div>
		<div class="instructionText">No items added</div>
		<div class="spacer2"></div>
	</div>
	<br>
	<div class="omblueLine"></div>
	<div class="container1">
		<div class="blueText boldText">These items will be tied to Sales
			Rep AB1234.</div>
		<div>To change the rep, select from dropdown.</div>
		<div class="spacer2"></div>
		<div class="boldText">
			AT&T Any City, USA<br> (555) 555-5555
		</div>
		<br>
		<div class="spacer2"></div>
		<div class="floatLeft selectWidth15">
			<input type="submit" value=" Update Stock " class="btn btn-primary">
		</div>
		<div class="clear"></div>
	</div>
	</div>
	<!-- End to show LEFT and Right border -->
	<!-- Below class to show Bottom border with LEFT and RIGHT rounded corners. -->
	<div class="headercontentblock0"></div>
	<!-- End to show Bottom border with LEFT and RIGHT rounded corners. -->
	<div class="spacer2"></div>
	</div>
</body>
</html>