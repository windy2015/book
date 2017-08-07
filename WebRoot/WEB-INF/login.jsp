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
  <style type="text/css">
      .err_field {
          color:red;
      }
  </style>
  
  <script type="text/javascript">
       function login(){
    	   // client validate 
    	   var  name = document.getElementById("userName");
    	   
    	   var isSubmit = true;
    	   
    	 /*   if(!name.value){
    		  isSubmit = false;
    		  document.getElementById("err_name").innerHTML="user name can not be null";
    	   }else{
    	      document.getElementById("err_name").innerHTML=""; 
    	   }
    	   
    	   var password = document.getElementById("userPwd") ;
    	   if(!password.value){
    		  isSubmit = false;
    		  document.getElementById("err_pwd").innerHTML="password can not be null";
    	   }else{
    	       document.getElementById("err_pwd").innerHTML="";
    	   } */
    	   
           var loginForm = document.getElementById("loginForm");
           if(isSubmit){
               loginForm.submit();
           }     
       } 
  </script>
  
  <body>
    <form action="login" method="post" id="loginForm">
      Username:<input type="text" name="userName" id="userName"/><label id="err_name" class="err_field">${errMap.name} </label><br/>
      passowrd:<input type="password" name="userPwd" id="userPwd"/><label id="err_pwd" class="err_field">${errMap.pwd}</label><br/>
      <input type="button" value="login" onclick="login()"/>
      ${err_msg} 
    </form>
  </body>
</html>
