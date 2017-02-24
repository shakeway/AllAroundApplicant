<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
    <form action="findprogram" method="post" class="form-horizontal">
      <div class="form-group">
        <label for="schoolname" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">School Name</label>
        <div class="col-sm-10" style="padding-left : 0">
          <input type="text" class="form-control" id="schoolname" placeholder="School Name" value="${fn:escapeXml(param.schoolname)}">
        </div>
      </div>
      <div class="form-group">
        <label for="programname" class="col-sm-2 control-label" style="padding-right: 0; text-align: left">Program Name</label>
        <div class="col-sm-10" style="padding-left : 0">
          <select id="programname" name="programname" class="form-control">
            <option value="AGRICULTURE, AGRICULTURE OPERATIONS, AND RELATED SCIENCES">agriculture</option>
            <option value="NATURAL RESOURCES AND CONSERVATION">natural resources</option>
            <option value="ARCHITECTURE AND RELATED SERVICES">architecture</option>
            <option value="AREA, ETHNIC, CULTURAL, GENDER, AND GROUP STUDIES">area</option>
            <option value="COMMUNICATION, JOURNALISM, AND RELATED PROGRAMS">communication</option>
            <option value="COMMUNICATIONS TECHNOLOGIES/TECHNICIANS AND SUPPORT SERVICES">communications technologies</option>
            <option value="COMPUTER AND INFORMATION SCIENCES AND SUPPORT SERVICES">computer sciences</option>
            <option value="PERSONAL AND CULINARY SERVICES">personal</option>
            <option value="EDUCATION">education</option>
            <option value="ENGINEERING">engineering</option>
            <option value="ENGINEERING TECHNOLOGIES AND ENGINEERING-RELATED FIELDS">engineering technologies</option>
            <option value="FOREIGN LANGUAGES, LITERATURES, AND LINGUISTICS">foreign languages</option>
            <option value="FAMILY AND CONSUMER SCIENCES/HUMAN SCIENCES">family/consumer sciences</option>
            <option value="LEGAL PROFESSIONS AND STUDIES">legal professions/studies</option>
            <option value="ENGLISH LANGUAGE AND LITERATURE/LETTERS">english language</option>
            <option value="LIBERAL ARTS AND SCIENCES, GENERAL STUDIES AND HUMANITIES">liberal arts</option>
            <option value="LIBRARY SCIENCE">library science</option>
            <option value="BIOLOGICAL AND BIOMEDICAL SCIENCES">biological</option>
            <option value="MATHEMATICS AND STATISTICS">mathematics</option>
            <option value="MILITARY SCIENCE, LEADERSHIP AND OPERATIONAL ART">military science</option>
            <option value="MILITARY TECHNOLOGIES AND APPLIED SCIENCES">military technologies</option>
            <option value="MULTI/INTERDISCIPLINARY STUDIES">interdisciplinary studies</option>
            <option value="PARKS, RECREATION, LEISURE, AND FITNESS STUDIES">parks/recreation/leisure</option>
            <option value="BASIC SKILLS AND DEVELOPMENTAL/REMEDIAL EDUCATION">developmental education</option>
            <option value="CITIZENSHIP ACTIVITIES">citizenship activities</option>
            <option value="HEALTH-RELATED KNOWLEDGE AND SKILLS">health</option>
            <option value="INTERPERSONAL AND SOCIAL SKILLS">interpersonal</option>
            <option value="LEISURE AND RECREATIONAL ACTIVITIES">leisure / recreational</option>
            <option value="PERSONAL AWARENESS AND SELF-IMPROVEMENT">personal awareness</option>
            <option value="PHILOSOPHY AND RELIGIOUS STUDIES">philosophy</option>
            <option value="THEOLOGY AND RELIGIOUS VOCATIONS">theology</option>
            <option value="PHYSICAL SCIENCES">physical sciences</option>
            <option value="SCIENCE TECHNOLOGIES/TECHNICIANS">science technologies</option>
            <option value="PSYCHOLOGY">PSYCHOLOGY</option>
            <option value="HOMELAND SECURITY, LAW ENFORCEMENT, FIREFIGHTING AND RELATED PROTECTIVE SERVICES">homeland security</option>
            <option value="PUBLIC ADMINISTRATION AND SOCIAL SERVICE PROFESSIONS">public administration</option>
            <option value="SOCIAL SCIENCES">social sciences</option>
            <option value="CONSTRUCTION TRADES">construction trades</option>
            <option value="MECHANIC AND REPAIR TECHNOLOGIES/TECHNICIANS">mechanic</option>
            <option value="PRECISION PRODUCTION">precision production</option>
            <option value="TRANSPORTATION AND MATERIALS MOVING">transportation</option>
            <option value="VISUAL AND PERFORMING ARTS">visual and performing arts</option>
            <option value="HEALTH PROFESSIONS AND RELATED PROGRAMS">health professions</option>
            <option value="BUSINESS, MANAGEMENT, MARKETING, AND RELATED SUPPORT SERVICES">business management</option>
            <option value="HIGH SCHOOL/SECONDARY DIPLOMAS AND CERTIFICATES">high school diplomas</option>
            <option value="HISTORY">history</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10" style="padding-left: 0; text-align: left">
        <button type="submit" class="btn btn-primary">Search</button>
        </div>
      </div>
    </form>
    <h2>Matching Programs</h2>
    <table class="table table-bordered">
      <tr class="info">
        <th>School</th>
        <th>Year</th>
        <th>Percentage</th>
        <th>Cert1</th>
        <th>Cert2</th>
        <th>Cert4</th>
        <th>Associate</th>
        <th>Bachelor</th>
        <th>Program</th>
      </tr>
      <c:forEach items="${programs}" var="program" >
      <tr>
        <td><c:out value="${program.getSchool().getName()}" /></td>
        <td><c:out value="${program.getYear()}" /></td>
        <td><c:out value="${program.getPercentage()}" /></td>
        <td><c:out value="${program.isCert1()}" /></td>
        <td><c:out value="${program.isCert2()}" /></td>
        <td><c:out value="${program.isCert4()}" /></td>
        <td><c:out value="${program.isAssociate()}" /></td>
        <td><c:out value="${program.isBachelor()}" /></td>
        <td><c:out value="${program.getCip().getTitle()}" /></td>
      </tr>
    </c:forEach>
  </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>