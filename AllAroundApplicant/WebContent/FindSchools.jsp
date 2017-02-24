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
    <form action="findschools" method="post" class="form-horizontal">
      <h2>Search Schools by Location</h2>
      <div class="form-group">
        <label for="city" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">City</label>
        <div class="col-sm-10" style="padding-left : 0">
          <input type="text" class="form-control" name="city" id="city" placeholder="City" value="${fn:escapeXml(param.city)}">
        </div>
      </div>

      <div class="form-group">
        <label for="state" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">State</label>
        <div class="col-sm-10" style="padding-left : 0">
          <select id="state" name="state" class="form-control">
            <option value="">Please Select</option>
            <option value="AL">Alabama</option>
            <option value="AK">Alaska</option>
            <option value="AZ">Arizona</option>
            <option value="AR">Arkansas</option>
            <option value="CA">California</option>
            <option value="CO">Colorado</option>
            <option value="CT">Connecticut</option>
            <option value="DE">Delaware</option>
            <option value="FL">Florida</option>
            <option value="GA">Georgia</option>
            <option value="HI">Hawaii</option>
            <option value="ID">Idaho</option>
            <option value="IL">Illinois</option>
            <option value="IN">Indiana</option>
            <option value="IA">Iowa</option>
            <option value="KS">Kansas</option>
            <option value="KY">Kentucky</option>
            <option value="LA">Louisiana</option>
            <option value="ME">Maine</option>
            <option value="MD">Maryland</option>
            <option value="MA">Massachusetts</option>
            <option value="MI">Michigan</option>
            <option value="MN">Minnesota</option>
            <option value="MS">Mississippi</option>
            <option value="MO">Missouri</option>
            <option value="MT">Montana</option>
            <option value="NE">Nebraska</option>
            <option value="NV">Nevada</option>
            <option value="NH">New Hampshire</option>
            <option value="NJ">New Jersey</option>
            <option value="NM">New Mexico</option>
            <option value="NY">New York</option>
            <option value="NC">North Carolina</option>
            <option value="ND">North Dakota</option>
            <option value="OH">Ohio</option>
            <option value="OK">Oklahoma</option>
            <option value="OR">Oregon</option>
            <option value="PA">Pennsylvania</option>
            <option value="RI">Rhode Island</option>
            <option value="SC">South Carolina</option>
            <option value="SD">South Dakota</option>
            <option value="TN">Tennessee</option>
            <option value="TX">Texas</option>
            <option value="UT">Utah</option>
            <option value="VT">Vermont</option>
            <option value="VA">Virginia</option>
            <option value="WA">Washington</option>
            <option value="WV">West Virginia</option>
            <option value="WI">Wisconsin</option>
            <option value="WY">Wyoming</option>
          </select>
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
                <th>School Name</th>
                <th>City</th>
                <th>State</th>
                <th>Website</th>
              </tr>
              <c:forEach items="${schools}" var="school" >
              <tr>
                <td><c:out value="${school.getName()}" /></td>
                <td><c:out value="${school.getCity()}" /></td>
                <td><c:out value="${school.getState()}" /></td>
                <td><a href=<c:out value="${school.getSchoolUrl()}"/>><c:out value="${school.getSchoolUrl()}"/></a></td>
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