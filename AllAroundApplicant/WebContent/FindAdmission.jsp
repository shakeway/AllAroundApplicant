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
		<form action="findadmission" method="post" class="form-horizontal">
			<h2>Search for Admission Information by SchoolName</h2>
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
			  <div class="panel-heading">Matching Admissions: <span id="successMessage">${messages.success}</span></div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered">
							<tr class="info">
								<th>School</th>
								<th>Year</th>
								<th>AdmissionRateOverall</th>
								<th>Sat 25th Percentile Reading</th>
								<th>Sat 75th Percentile Reading</th>
								<th>Sat 25th Percentile Math</th>
								<th>Sat 75th Percentile Math</th>
								<th>Sat 25th Percentile Writing</th>
								<th>Sat 75th Percentile Writing</th>
								<th>Sat Midpoint Reading</th>
								<th>Sat Midpoint Math</th>
								<th>Sat Midpoint Writing</th>
								<th>Act 25th Percentile Cumulative</th>
								<th>Act 75th Percentile Cumulative</th>
								<th>Act 25th Percentile English</th>
								<th>Act 75th Percentile English</th>
								<th>Act 25th Percentile Math</th>
								<th>Act 75th Percentile Math</th>
								<th>Act 25th Percentile Writing</th>
								<th>Act 75th Percentile Writing</th>
								<th>Act Midpoint Cumulative</th>
								<th>Act Midpoint English</th>
								<th>Act Midpoint Math</th>
								<th>Act Midpoint Writing</th>
								<th>Sat Average Overall</th>
							</tr>
							<c:forEach items="${admissions}" var="admission" >
								<tr>
									<td><c:out value="${admission.getSchool().getName()}" /></td>
									<td><c:out value="${admission.getYear()}" /></td>
									<td><c:out value="${admission.getAdmissionRateOverall()}" /></td>
									<td><c:out value="${admission.getSatScores25thPercentileCriticalReading()}" /></td>
									<td><c:out value="${admission.getSatScores75thPercentileCriticalReading()}" /></td>
									<td><c:out value="${admission.getSatScores25thPercentileMath()}" /></td>
									<td><c:out value="${admission.getSatScores75thPercentileMath()}" /></td>
									<td><c:out value="${admission.getSatScores25thPercentileWriting()}" /></td>
									<td><c:out value="${admission.getSatScores75thPercentileWriting()}" /></td>
									<td><c:out value="${admission.getSatScoresMidpointCriticalReading()}" /></td>
									<td><c:out value="${admission.getSatScoresMidpointMath()}" /></td>
									<td><c:out value="${admission.getSatScoresMidpointWriting()}" /></td>
									<td><c:out value="${admission.getActScores25thPercentileCumulative()}" /></td>
									<td><c:out value="${admission.getActScores75thPercentileCumulative()}" /></td>
									<td><c:out value="${admission.getActScores25thPercentileEnglish()}" /></td>
									<td><c:out value="${admission.getActScores75thPercentileEnglish()}" /></td>
									<td><c:out value="${admission.getActScores25thPercentileMath()}" /></td>
									<td><c:out value="${admission.getActScores75thPercentileMath()}" /></td>
									<td><c:out value="${admission.getActScores25thPercentileWriting()}" /></td>
									<td><c:out value="${admission.getActScores75thPercentileWriting()}" /></td>
									<td><c:out value="${admission.getActScoresMidpointCumulative()}" /></td>
									<td><c:out value="${admission.getActScoresMidpointEnglish()}" /></td>
									<td><c:out value="${admission.getActScoresMidpointMath()}" /></td>
									<td><c:out value="${admission.getActScoresMidpointWriting()}" /></td>
									<td><c:out value="${admission.getSatScoresAverageOverall()}" /></td>
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