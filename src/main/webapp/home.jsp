<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<title>Available Books</title>
  </head>
  <body>
  	<div class ="container-fluid">
	    <div id="header" style="margin-top:20px; display:block; border-bottom:solid 1px; text-align:right">
			<form action="logout">
				<input type="submit" value="Logout" style="display:inline-block; float:right;margin-left:20px;margin-right:20px" type="button" class="btn btn-outline-primary logout">
			</form>
			<div style="display:inline-block; "><h2>Welcome ${username}</h2></div>
		</div>
		<div class="col-sm-12" id="main-content" style="display:block; margin-top:10px">
			<div style="">
				
				<form action="addBook" style="text-align:center">
					<h1 >Books Listing
					<input type="submit" value="Add Book" style="float:right;margin-left:20px;margin-right:20px;" class="btn btn-primary addBook">
					</h1>
				</form>
			</div>
			<table style="width:100%; margin-top:10px;text-align:center" id="bookstable" border="1">
				<tr>
					<th class="header">Book Code</th>
					<th class="header">Book Name</th>
					<th class="header">Author</th>
					<th class="header">Date Added</th>
					<th class="header">Actions</th>
				</tr>
				<c:forEach items="${books}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.author}</td>
					<td>${item.dateAdded}</td>
					<td>
					<div>
						<form action="update/${item.id}">
							<input type="submit" value="Edit" class="btn btn-outline-success update" style="margin-left:30px; margin-right:20px; width:90px; display:inline-block; float:left">
						</form>
						<form action="delete/${item.id}">
							<input type="submit" value="Delete" class="btn btn-outline-danger delete"style="margin-left:10px;margin-right:-40px;width:90px; display:inline-block; float:left">
						</form>
						 <!--
						 
						<button type="button" class="btn btn-outline-success" style="margin-left:-40px; margin-right:20px; width:100px" >Edit</button>
						<button type="button" class="btn btn-outline-danger "style="margin-right:-40px;width:100px">Delete</button>
						-->
					</div>	
					</td>
				</tr>
				
			</c:forEach>
				
	
				
	
			</table>
			<!-- ${books} -->
		
		</div>
		<div id = "footer">
		</div>
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
