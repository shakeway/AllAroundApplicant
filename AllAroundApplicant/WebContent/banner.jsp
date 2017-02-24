<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="author" content="Script Tutorials" />
        <!-- add styles -->
        <link href="css/main.css" rel="stylesheet" type="text/css" />
        <% String name=(String)session.getAttribute("NAME");
 						   String userID=(String)session.getAttribute("ID");
 						  String url = "head/"+(String)session.getAttribute("ID")+"."+"jpg";
   							%>
    </head>
    <body>
        <div id="header">
            <!-- logo -->
            <table width=100%>
            <td align="center"><img src="logo.png"></td>
            <td align="right">
            <br><br>
            <%
        		if(name!=null){%>
        		<div align="right">
        		<img  width=50px height=50px src="<%=url%>"/>
        		<uu>user：<%=name%></uu></div>
        		<%}%></td>
          </table>
            <div id="navmenu">
                <nav id="menu">
                    <ul>
                        <li class="active"><a href="index.jsp">Index</a></li>
                        <li><a href="#">BasicInfo</a>
                            <ul>
                           	    <li><a href="FindSchools.jsp">Schools</a></li>
                                <li><a href="FindAdmission.jsp">Admission</a></li>
                                <li><a href="FindStudent.jsp">Student</a></li>
                                <li><a href="FindProgram.jsp">Programs</a></li>
                                <li><a href="FindCompletion.jsp">FindCompletion</a></li>
                                <li><a href="FindFinancialAid.jsp">FinancialAid</a></li>
                        		<li><a href="FindCost.jsp">Cost</a></li>	
                            </ul>
                        </li>
                        <li><a href="DiscussionBoard.jsp">DiscussionBoard</a></li>
                        <li>
 						<% //String name=(String)session.getAttribute("NAME");
 						   //String userID=(String)session.getAttribute("ID");
   							if(name!=null){%>
        					<a href="UserUpdate.jsp" >PersonalInfo</a>
                       	<%}else{%>
                     		<a href="login.jsp">Log in</a>
                        <%}%>
 						</li>
 						<li>
 						<%
 						if(name!=null){%>
                        <a href="logout.jsp">Log out</a>
 						<%}else{%>
                     		<a href="UserCreate.jsp">Register</a>
                        <%}%>
 						</li>
                    </ul>
                </nav>
            </div>
        </div>
<br>
    </body>
</html>
