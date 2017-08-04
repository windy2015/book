<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML ">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
       function login(){
           var loginForm = document.getElementById("loginForm");
           loginForm.submit();     
       } 
  </script>
  
  <body>
    <form action="login" method="post" id="loginForm">
      Username:<input type="text" name="userName" id="userName"/><br/>
      passowrd:<input type="password" name="userPwd" id="userPwd"/><br/>
      <input type="button" value="login" onclick="login()"/>
    </form>
  </body>
</html>
