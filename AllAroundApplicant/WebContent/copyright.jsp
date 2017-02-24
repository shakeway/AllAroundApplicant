<%@page pageEncoding="UTF-8"%>
<%
String copyright="&nbsp;All Copyright &copy;Akitas   ";
%>
<%if(application.getAttribute("count")==null){
                application.setAttribute("count", "1");
            }else{
                //将得到的对象转换成 字符串 形式
                String strCount = application.getAttribute("count").toString();
                //将字符串转换成 整形
                int intCount =Integer.parseInt(strCount);
                //让其进行自加1运算
                intCount++;
                //再将自加后的变量设置给application
                application.setAttribute("count", Integer.toString(intCount));
            }
        %>        
<div align="center"><%= copyright %>You are the <%=application.getAttribute("count") %> visitor!</div>
<br>