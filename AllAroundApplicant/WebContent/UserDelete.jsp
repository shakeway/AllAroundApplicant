<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AllAroundApplicant</title>
<!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/custom.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
<%@ include file="navbar.html" %>
</div>
<div class="container-fluid" align="center" style="width: 50%">
<h2>Delete User</h2>
    <br/>
    <form class="form-inline" action="userdelete" method="post">
  <div class="form-group">
    <label for="username">User Name</label>
    <input type="text" class="form-control" name="username" id="username" placeholder="User Name">
  </div>
  <button type="submit" class="btn btn-danger">Delete</button>
</form>

    <br/><br/>
    <p>
        <span id="successMessage"><b>${messages.success}</b></span>
    </p>
	</div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>