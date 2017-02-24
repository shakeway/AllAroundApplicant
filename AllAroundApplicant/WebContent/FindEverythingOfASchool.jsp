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
    <form action="findeverythingofaschool" method="post" class="form-horizontal">
      <h2>Search School Information</h2>
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
    <h3>Matching Results: </h3> <span id="successMessage">${messages.success}</span>
    </br>
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Basic Information
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <div class="table-responsive">
          <table class="table table-bordered">
            <tr class="info">
              <th>School</th>
              <th>City</th>
              <th>State</th>
              <th>Zip</th>
              <th>Latitude</th>
              <th>Longitude</th>
              <th>School Url</th>
              <th>Price Calculator Url</th>
              <th>Main Campus</th>
              <th>Branches</th>
              <th>Predominant</th>
              <th>Highest</th>
              <th>Ownership</th>
              <th>State Fips</th>
              <th>RegionId</th>
              <th>CarnegieBasic</th>
              <th>CarnegieUndergard</th>
              <th>CarnegieSizeSetting</th>
              <th>ReligiousAffiliation</th>
              <th>MenOnly</th>
              <th>WomenOnly</th>           
            </tr>
            <c:forEach items="${schools}" var="schools" >
            <tr>
              <td><c:out value="${schools.getName()}" /></td>
              <td><c:out value="${schools.getCity()}" /></td>
              <td><c:out value="${schools.getState()}" /></td>
              <td><c:out value="${schools.getZip()}" /></td>
              <td><c:out value="${schools.getLat()}" /></td>
              <td><c:out value="${schools.getLon()}" /></td>
              <td><c:out value="${schools.getSchoolUrl()}" /></td>
              <td><c:out value="${schools.getPriceCalculatorUrl()}" /></td>
              <td><c:out value="${schools.isMainCampus()}" /></td>
              <td><c:out value="${schools.getBranches()}" /></td>
              <td><c:out value="${schools.getPredominant()}" /></td>
              <td><c:out value="${schools.getHighest()}" /></td>
              <td><c:out value="${schools.getOwnership()}" /></td>
              <td><c:out value="${schools.getStateFips()}" /></td>
              <td><c:out value="${schools.getRegionId()}" /></td>
              <td><c:out value="${schools.getCarnegieBasic()}" /></td>
              <td><c:out value="${schools.getCarnegieUndergrad()}" /></td>
              <td><c:out value="${schools.getCarnegieSizeSetting()}" /></td>
              <td><c:out value="${schools.getReligiousAffiliation()}" /></td>
              <td><c:out value="${schools.isMenOnly()}" /></td>
              <td><c:out value="${schools.isWomenOnly()}" /></td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
    </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Admissions
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
        <div class="table-responsive">
          <table class="table table-bordered">
            <tr class="info">
              <th>Year</th>
              <th>AdmissionRateOverall</th>
              <th>SatScores25thPercentileCriticalReading</th>
              <th>SatScores75thPercentileCriticalReading</th>
              <th>SatScores25thPercentileMath</th>
              <th>SatScores75thPercentileMath</th>
              <th>SatScores25thPercentileWriting</th>
              <th>SatScores75thPercentileWriting</th>
              <th>SatScoresMidpointCriticalReading</th>
              <th>SatScoresMidpointMath</th>
              <th>SatScoresMidpointWriting</th>
              <th>ActScores25thPercentileCumulative</th>
              <th>ActScores75thPercentileCumulative</th>
              <th>ActScores25thPercentileEnglish</th>
              <th>ActScores75thPercentileEnglish</th>
              <th>ActScores25thPercentileMath</th>
              <th>ActScores75thPercentileMath</th>
              <th>ActScores25thPercentileWriting</th>
              <th>ActScores75thPercentileWriting</th>
              <th>ActScoresMidpointCumulative</th>
              <th>ActScoresMidpointEnglish</th>
              <th>ActScoresMidpointMath</th>
              <th>ActScoresMidpointWriting</th>
              <th>SatScoresAverageOverall</th>
              <th>SatScoresAverageByOpeId</th>           
            </tr>
            <c:forEach items="${admissions}" var="admission" >
            <tr>
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
              <td><c:out value="${admission.getSatScoresAverageByOpeId()}" /></td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
</div>
<div class="panel panel-default">
  <div class="panel-heading" role="tab" id="headingThree">
    <h4 class="panel-title">
      <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        Costs
      </a>
    </h4>
  </div>
  <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
    <div class="panel-body">
      <div class="table-responsive">
        <table class="table table-bordered">
          <tr class="info">
            <th>Year</th>
            <th>Annual Cost</th>
            <th>Tuition (In State)</th>
            <th>Tuition (Out of State)</th>
            <th>Net Price Average</th>           
          </tr>
          <c:forEach items="${costs}" var="cost" >
          <tr>
            <td><c:out value="${cost.getYear()}" /></td>
            <td><c:out value="${cost.getAnnualCost()}" /></td>
            <td><c:out value="${cost.getTuitionInState()}" /></td>
            <td><c:out value="${cost.getTuitionOutState()}" /></td>
            <td><c:out value="${cost.getNetPriceAverage()}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
</div>
<div class="panel panel-default">
  <div class="panel-heading" role="tab" id="headingFour">
    <h4 class="panel-title">
      <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
        Financial Aids
      </a>
    </h4>
  </div>
  <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
    <div class="panel-body">
      <div class="table-responsive">
        <table class="table table-bordered">
          <tr class="info">
            <th>Year</th>
            <th>Debt Median</th>
            <th>Grad Debt Median</th>
            <th>Low Income Debt Median</th>
            <th>Med Income Debt Median</th>
            <th>Hi Income Debt Median</th>
            <th>Female Debt Median</th>
            <th>Male Debt Median</th>          
          </tr>
          <c:forEach items="${financialAids}" var="financialaid" >
          <tr>
            <td><c:out value="${financialaid.getYear()}" /></td>
            <td><c:out value="${financialaid.getDebtMedian()}" /></td>
            <td><c:out value="${financialaid.getGradDebtMedian()}" /></td>
            <td><c:out value="${financialaid.getLowIncomeDebtMedian()}" /></td>
            <td><c:out value="${financialaid.getMedIncomeDebtMedian()}" /></td>
            <td><c:out value="${financialaid.getHiIncomeDebtMedian()}" /></td>
            <td><c:out value="${financialaid.getFemaleDebtMedian()}" /></td>
            <td><c:out value="${financialaid.getMaleDebtMedian()}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
</div>
<div class="panel panel-default">
  <div class="panel-heading" role="tab" id="headingFive">
    <h4 class="panel-title">
      <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
        Student 
      </a>
    </h4>
  </div>
  <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
    <div class="panel-body">
      <div class="table-responsive">
        <table class="table table-bordered">
          <tr class="info">
            <th>Year</th>
            <th>Size</th>
            <th>EnrollmentAll</th>
            <th>DemographicsRaceEthnicityWhite</th>
            <th>DemographicsRaceEthnicityBlack</th>
            <th>DemographicsRaceEthnicityHispanic</th>
            <th>DemographicsRaceEthnicityAsian</th>
            <th>DemographicsRaceEthnicityAian</th>
            <th>DemographicsRaceEthnicityNhpi</th>
            <th>DemographicsRaceEthnicityTwoOrMore</th>
            <th>DemographicsRaceEthnicityNonResidentAlien</th>
            <th>DemographicsRaceEthnicityUnknown</th>
            <th>DemographicsRaceEthnicityWhiteNonHispanic</th>
            <th>DemographicsRaceEthnicityBlackNonHispanic</th>
            <th>DemographicsRaceEthnicityAsianPacificIslander</th>
            <th>DemographicsRaceEthnicityAianPrior2009</th>
            <th>DemographicsRaceEthnicityHispanicPrior2009</th>
            <th>DemographicsNonResidentAliens2000</th>
            <th>DemographicsRaceEthnicityUnknown2000</th>
            <th>DemographicsRaceEthnicityWhite2000</th>
            <th>DemographicsRaceEthnicityBlack2000</th>
            <th>DemographicsRaceEthnicityApi2000</th>
            <th>DemographicsRaceEthnicityAian2000</th>
            <th>DemographicsRaceEthnicityHispanic2000</th>
            <th>PartTimeShare</th>
            <th>PartTimeShare2000</th>         
          </tr>
          <c:forEach items="${students}" var="student" >
          <tr>
            <td><c:out value="${student.getYear()}" /></td>
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
  </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script>
  $(document).ready(function(){
    if ($("#successMessage").text() == "" ||  $("#successMessage").text() == "Please enter a valid name.") {
      $("#accordion").hide();
    }else{$("#accordion").show();}
  });
</script>
</body>
</html>