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
    <form action="findstudent" method="post" class="form-horizontal">
      <h2>Search for Students by School Name</h2>

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
        <div class="panel-heading">Matching Students: <span id="successMessage">${messages.success}</span></div>
        <div class="panel-body">
          <div class="table-responsive">
            <table class="table table-bordered">
              <tr class="info">
                <th>Year</th>
                <th>School</th>
                <th>Size</th>
                <th>Enrollment All</th>
                <th>Demographics Race Ethnicity White</th>
                <th>Demographics Race Ethnicity Black</th>
                <th>Demographics Race Ethnicity Hispanic</th>
                <th>Demographics Race Ethnicity Asian</th>
                <th>Demographics Race Ethnicity Aian</th>
                <th>Demographics Race Ethnicity Nhpi</th>
                <th>Demographics Race Ethnicity TwoOrMore</th>
                <th>Demographics Race Ethnicity NonResidentAlien</th>
                <th>Demographics Race Ethnicity Unknown</th>
                <th>Demographics Race Ethnicity WhiteNonHispanic</th>
                <th>Demographics Race Ethnicity BlackNonHispanic</th>
                <th>Demographics Race Ethnicity AsianPacificIslander</th>
                <th>Demographics Race Ethnicity AianPrior2009</th>
                <th>Demographics Race Ethnicity HispanicPrior2009</th>
                <th>Demographics NonR esidentAl iens2000</th>
                <th>Demographics Race Ethnicity Unknown2000</th>
                <th>Demographics Race Ethnicity White2000</th>
                <th>Demographics Race Ethnicity Black2000</th>
                <th>Demographics Race Ethnicity Api2000</th>
                <th>Demographics Race Ethnicity Aian2000</th>
                <th>Demographics Race Ethnicity Hispanic2000</th>
                <th>PartTimeShare</th>
                <th>PartTimeShare2000</th>
              </tr>
              <c:forEach items="${students}" var="student" >
              <tr>
                <td><c:out value="${student.getYear()}" /></td>
                <td><c:out value="${student.getSchool().getName()}" /></td>
                <td><c:out value="${student.getSize()}" /></td>
                <td><c:out value="${student.getEnrollmentAll()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityWhite()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityBlack()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityHispanic()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityAsian()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityAian()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityNhpi()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityTwoOrMore()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityNonResidentAlien()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityUnknown()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityWhiteNonHispanic()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityBlackNonHispanic()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityAsianPacificIslander()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityAianPrior2009()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityHispanicPrior2009()}" /></td>
                <td><c:out value="${student.getDemographicsNonResidentAliens2000()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityUnknown2000()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityWhite2000()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityBlack2000()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityApi2000()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityAian2000()}" /></td>
                <td><c:out value="${student.getDemographicsRaceEthnicityHispanic2000()}" /></td>
                <td><c:out value="${student.getPartTimeShare()}" /></td>
                <td><c:out value="${student.getPartTimeShare2000()}" /></td>
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