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
    <form action="findschoolsbysat" method="post" class="form-horizontal">
      <h2>Search for Schools Perfect for You</h2><span>Please enter your SAT scores</span>

      <div class="form-group">
        <label for="satMath" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">SAT Math</label>
        <div class="col-sm-10" style="padding-left : 0">
          <input type="text" class="form-control" name="satMath" id="satMath" placeholder="SAT Math" value="${fn:escapeXml(param.satMath)}">
        </div>
      </div>

      <div class="form-group">
        <label for="satReading" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">SAT Critical Reading</label>
        <div class="col-sm-10" style="padding-left : 0">
          <input type="text" class="form-control" name="satReading" id="satReading" placeholder="SAT Reading" value="${fn:escapeXml(param.satReading)}">
        </div>
      </div>

      <div class="form-group">
        <label for="satWriting" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">SAT Writing</label>
        <div class="col-sm-10" style="padding-left : 0">
          <input type="text" class="form-control" name="satWriting" id="satWriting" placeholder="SAT Writing" value="${fn:escapeXml(param.satWriting)}">
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
        <div class="panel-heading">Matching Schools in: <span id="successMessage">${messages.success}</span></div>
        <div class="panel-body">
          <div class="table-responsive">
            <table class="table table-bordered">
              <tr class="info">
                <th>School</th>
                <th>City</th>
                <th>State</th>
                <th>Admission Rate</th>
                <th>SAT Math 25th Percentile</th>
                <th>SAT Critical Reading 25th Percentile</th>
                <th>SAT Writing 25th Percentile</th>
              </tr>
              <c:forEach items="${admissions}" var="admission" >
              <tr>
                <td><c:out value="${admission.getSchool().getName()}" /></td>
                <td><c:out value="${admission.getSchool().getCity()}" /></td>
                <td><c:out value="${admission.getSchool().getState()}" /></td>
                <td><c:out value="${admission.getAdmissionRateOverall()}" /></td>
                <td><c:out value="${admission.getSatScores25thPercentileMath()}" /></td>
                <td><c:out value="${admission.getSatScores25thPercentileCriticalReading()}" /></td>
                <td><c:out value="${admission.getSatScores25thPercentileWriting()}" /></td>
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