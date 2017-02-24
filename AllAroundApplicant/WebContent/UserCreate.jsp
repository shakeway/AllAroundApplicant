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
<h1>Create User</h1>
    <form action="usercreate" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">UserName</label>
            <div class="col-sm-10" style="padding-left : 0">
            <input id="username" name="username" value="" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">PassWord</label>
            <div class="col-sm-10" style="padding-left : 0">
            <input id="password" name="password" value="" type="password" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="firstname" class="col-sm-2 control-label">FirstName</label>
            <div class="col-sm-10" style="padding-left : 0">
            <input id="firstname" name="firstname" value="" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">LastName</label>
            <div class="col-sm-10" style="padding-left : 0">
            <input id="lastname" name="lastname" value="" class="form-control">
            </div>
        </div>
         <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10" style="padding-left : 0">
            <input id="email" name="email" value="" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">Phone</label>
            <div class="col-sm-10" style="padding-left : 0">
            <input id="phone" name="phone" value="" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form>

    <br/><br/>
    <p>
        <span id="successMessage"><b>${messages.success}</b></span>
    </p>
    </div>
<div id="footer"><%@ include file="copyright.jsp" %></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>


