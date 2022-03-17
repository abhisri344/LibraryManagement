<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Edit Book</title>
</head>
<body>
	<div class="container-fluid">
		<div id="header" style="margin-top:20px; display:block; border-bottom:solid 1px; text-align:right">
			<form action="logout">
				<input type="submit" value="Logout" style="display:inline-block; float:right;margin-left:20px;margin-right:20px" type="button" class="btn btn-outline-primary logout">
			</form>
			<div style="display:inline-block; "><h2>Welcome ${username}</h2></div>
		</div>
		<div class="col-sm-12" id="main-content"
			style="display: block; margin-top: 10px">
				<form action="" style="text-align:center">
					<h1 >Edit Book Details</h1>
				</form>
			<div class="card-body">
				<form action="../updateBook" method="post">
					<div class="form-group row">
						<label for="bookcode"
							class="col-md-2 col-form-label">Book Code:</label>
						<div class="col-md-6" style="margin-left:-16px">
							<input type="text" id="bookid" class="form-control" value="${book.id}"
								name="bookid" readonly autofocus>
						</div>
					</div>
					<div class="form-group row">
						<label for="bookname"
							class="col-md-2 col-form-label">Book Name:</label>
						<div class="col-md-6" style="margin-left:-16px">
							<input type="text" id="bookname" class="form-control" value="${book.name}"
								name="bookname" required autofocus>
						</div>
					</div>

					<div class="form-group row">
						<label for="author" class="col-md-2 col-form-label ">Author:</label>
						<div class="col-md-6" style="margin-left:-16px;margin-top:8px; ">
							<select name="author" id="author" value="${book.author}">
								<option value="Chetan Bhagat">Chetan Bhagat</option>
								<option value="William Shakespeare">William Shakespeare</option>
								<option value="Bernard Shaw">Bernard Shaw</option>
								<option value="Robert Cecil">Robert Cecil</option>
								<option value="Andy Hunt">Andy Hunt</option>
								<option value="Erich Gamma">Erich Gamma</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 col-form-label" style="text-align:left; margin-left:-16px">Added On</label>
						<div style="text-align:left; margin-right:16px; display:inline-block">
						<script >
							document.write(new Date().toLocaleDateString());
						</script>
						</div>
					</div>
					<div style="text-align:center">
						<input type="submit" value="Update" class="btn btn-outline-success add" style="margin-left:30px; margin-right:20px; width:90px; display:inline-block; float:left; text-align:center">
				</form>
					<form action="goback">
						<input type="submit" value="Go Back" class="btn btn-outline-danger goback"style="margin-left:10px;margin-right:-40px;width:90px; display:inline-block; float:left">
					</form>
					</div>
			</div>
			<div class="card-header" style="background-color: #3398FF; margin-top:50px"></div>
		

		</div>
		<div id="footer"></div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>