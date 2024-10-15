<%@page import="com.mysql.cj.jdbc.Blob"%>
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
        body{
            background-color: whitesmoke;
            margin: 0px;
        }
        #fullname,#pass,#phone,#email{
            border-radius: 10px;
            height: 35px;
            width: 90%;
        }
        #form{
            background-color: white;
            border: 1px solid black;
            padding: 60px;
            width: 500px;
            margin-left: 450px;
            margin-top: 40px;
            border-radius: 30px;
        }
        nav{
            background-color: white;
            display: flex;
            height: 30px;
            /* border: 1px solid black; */

            padding: 20px;
            position: sticky;
            top: 0px;

            }
        nav>p{
            display: inline-block;
             line-height: 0px;
            padding-left: 800px;
            }
        nav>img{
            padding-left: 90px;
            }
            sup{
                color: red;
            }
            #male,#female,#others{
                display: none;
            }
            #male:checked~#filter .featured,
            #female:checked~#filter .personal,
            #others:checked~#filter .tech {
                background-color: #265df5;
                color: white;
            }
        #filter .featured,#filter .personal,#filter .tech{

            display: inline-block;
            border-radius: 10px;
            text-align: center;
            height: 40px;
            width: 70px;
            line-height: 40px;
            padding-left: 10px;
        }
        #filter{
            /* border: 1px solid black; */
            width: 250px;
            height: 50px;
            line-height: 50px;
        }
        .required{
            padding-left: 10px;
        }
        input[type="submit"]{
            background-color: #265df5;
            color: white;
            height: 40px;
            width: 70px;
            border-radius: 10px;
            text-align: center;
            margin-left: 210px;
        }
        span{
        color:red;
        }

    </style>
</head>
<body>
	<nav>
        <p>Already <a href="user-login.jsp">Registered</a>? Login here</p>
    </nav>
    <div id="form" >
        <legend><h1>Create your JobQuest profile</h1>Search & apply to jobs from India's No.1 Job Site</legend><br>
    <form action="user-signup.jsp">
        <label for="fullname">Full Name<sup>*</sup></label><br>
        <input class="required" type="text" name="fname" id="fullname" placeholder="What is your name?" autofocus required><br>
        <br>
        <label for="email">Email address<sup>*</sup></label><br>
        <input class="required" type="email" name="mail" id="email" placeholder="Tell us your Email Id">
        <% 
        String mail=request.getParameter("mail");

        if(mail!=null&&Userdao.getuser(mail)!=null){%>
        <br>
        
        <span><%= "The mail is already exits" %></span>
        <%	
        }
        else{
        	int id=Userdao.lastid()+1;
        	String s1=request.getParameter("mail");
        	String s2=request.getParameter("fname");
        	String s3=request.getParameter("password");
        	String s4=request.getParameter("gender");
        	String s5=request.getParameter("mobo");
        	if(s1!=null&&s2!=null&&s3!=null&&s4!=null&&s5!=null){
        		Long l=Long.parseLong(s5);
        	User u=new User(id,s1,s2,s3,s4,l,null,null,null);
        	Userdao.adduser(u);
        	response.sendRedirect("user-login.jsp");
        	}
        }
        %>
        <br>
        <br>
        <label for="pass">Password<sup>*</sup></label>
        <input class="required" type="password" name="password" id="pass" required min="6" placeholder="Must contain 6 characters">
        <br>
        <br>
        <label for="">gender<sup>*</sup></label>
        <br>
        <input type="radio" name="gender" id="male" value="male" required>
        <input type="radio" name="gender" id="female" value="female" required>
        <input type="radio" name="gender" id="others" value="others" required>
        <header id="filter">
            <label for="male" class="filter-label featured" id="male-label">Male</label>
            <label for="female" class="filter-label personal" id="female-label">Female</label>
            <label for="others" class="filter-label tech" id="others-label">Others</label>
          </header>
        <br>
        <label for=""></label>
        <label for="phone">Phone<sup>*</sup></label><br>
        <input class="required" type="phone" name="mobo" id="phone" required placeholder="enter your mobile number">
        <br>
        <br>

        <input type="submit" value="submit">

    </form>
    </div>


</body>
</html>