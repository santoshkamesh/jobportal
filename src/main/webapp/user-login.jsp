<%@page import="dto.User"%>
<%@page import="dao.Userdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span{
	color: red;
	margin-left: 60px;
}
</style>
<link rel="stylesheet" href="css/login.css" />
</head>
<body>
	<div class="main">
      <div class="login-box">
        <h2>Login</h2>
        <form method="post" action="user-login.jsp">
          <div class="form-data">
            <label for="username">Email ID / Username </label>
            <input type="text" id="username" name="username" required autofocus />
          </div>
          <%
          String s=request.getParameter("username");
         User u =Userdao.getuser(s);
          if(s!=null&&u==null){%>
          
          <span><%="Mail Id not registered" %></span>
          <%=s %>
          <%   
          }
          String pass=request.getParameter("pass");
          %>

          <div class="form-data">
            <label for="password">Password</label>
            <input type="text" id="password" name="pass" required />
      <%
         	if(u!=null && u.getEmail().equals(s)&&!u.getPassword().equals(pass)){
         		%>
         		<%="incorrect password" %>
                  	 <% 
           }
         	else if(u!=null&&u.getEmail().equals(s)&&u.getPassword().equals(pass))
      {
    	  session = request.getSession();
    	  session.setAttribute("user", u);
    	 
    	  request.getRequestDispatcher("home.jsp").forward(request, response);
      }
          %>
          </div>
          <a class="form-data" href="#"><p>Forgot Password?</p></a>
          <div class="form-data">
            <button type="submit" class="login">Login</button>
          </div>
          <div class="form-data" ><p>or</p></div>
          
        </form>
        <div class="form-data"><a href="user-signup.jsp"><button type="" class="signup">Signup</button></a></div>
      </div>
    </div>

</body>
</html>