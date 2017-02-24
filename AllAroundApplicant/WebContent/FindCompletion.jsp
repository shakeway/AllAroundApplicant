<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
  <div class="container">
    <form action="findcompletion" method="post" class="form-horizontal">
      <h2>Search for Completion Information by SchoolName</h2>
      <div class="form-group">
        <label for="schoolname" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">School Name</label>
        <div class="col-sm-10" style="padding-left : 0">
          <input type="text" class="form-control" name="schoolname" id="schoolname" placeholder="School Name" value="${fn:escapeXml(param.schoolname)}">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10" style="padding-left: 0; text-align: left">
          <button type="submit" class="btn btn-primary">Search</button>
        </div>
      </div>      
    </form>
    <div style="height: 500px">
      <div class="panel panel-primary"  id="panel">
        <div class="panel-heading">Matching Completion: <span id="successMessage">${messages.success}</span></div>
        <div class="panel-body">
          <div class="table-responsive">
            <table class="table table-bordered">
              <tr class="info">
                <th>Year</th>
                <th>CompletionRateSuppressedOverall1</th>
                <th>CompletionRateSuppressedOverall2</th>
                <th>CompletionRate4yr150nt</th>
                <th>CompletionRateLessThan4yr150nt</th>              
                </tr>
                <c:forEach items="${completions}" var="completion" >
                <tr>
                  <td><c:out value="${completion.getYear()}" /></td>
                  <td><c:out value="${completion.getCompletionratesuppressedoverall1()}" /></td>
                  <td><c:out value="${completion.getCompletionratesuppressedoverall2()}" /></td>
                  <td><c:out value="${completion.getCompletionrate4yr150nt()}" /></td>
                  <td><c:out value="${completion.getCompletionratelessthan4yr150nt()}" /></td>
                </tr>
              </c:forEach>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script>
    $(document).ready(function(){
      if ($("#successMessage").text() == "" ||  $("#successMessage").text() == "Please enter a valid name.") {
        $("#panel").hide();
      }else{$("#panel").show();}
    });
  </script>
</body>
</html>