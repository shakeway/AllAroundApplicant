<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/main.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>

</head>
<body>
<div id="container">
<div>
<%@ include file="banner.jsp" %>
</div>
<div id="page" class="clearfix">
<form action="login" method="post" >
		<table align="center" width="450">
			<tr>
				<td align="center" colspan="2">
					<h2>User Login</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">UserName</td>
				<td><input type="text" name="login_username" onChange="check_name()"/></td>
				<td><div id="tip1" class="tip"></div></td>
			</tr>
			<tr>
				<td align="right">Password</td>
				<td><input type="password" name="login_password" onChange="check_password()"/></td>
				<td><div id="tip2" class="tip"></div></td>
			</tr>
<!-- 			<tr>
				<td align="right">验证码：</td>
				<td><input type="text" name="checkcode" id="checkcode" onChange="check_code()"/></td>
				<td><div id="tipc" class="tip"></div></td>
			</tr> -->
<!--			<tr>
			<td></td>
<<<<<<< HEAD:AllAroundApplicant/AllAroundApplicant/WebContent/Login.jsp
			  <td><div><img src="check_code.jsp"/></div></td>
				</tr> -->
=======
<!-- 			<td><div><img src="check_code.jsp"/></div></td> -->
			</tr>
>>>>>>> origin/master:AllAroundApplicant/AllAroundApplicant/WebContent/login.jsp
			<tr>
				<td align="right">
				</td>
				<td>
				<input type="submit" value="Login">
					<input type="button" value="Rgister" onclick="window.location='UserCreate.jsp'">
				</td>
			</tr>
			<tr><span id="successMessage"><b>${messages.success}</b></span></tr>
		</table>
	</form>
</div>
</div>
<div id="footer"><%@ include file="copyright.jsp" %></div>
</body>
</html>
