<%@page import="dto.Job"%>
<%@page import="java.util.LinkedList"%>
<%@page import="dao.Jobdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/a3f5006001.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css" />
</head>
<body>
	<nav>
    <form action="">
      <label for="job-type">Choose Type</label>
      <select class="choose" id="job-type" name="job-type" required>
        <option value="Job">Job</option>
        <option value="Internship">Internship</option>
      </select>

      <input class="choose" type="text" name="skills" placeholder="Enter your preference" required />
      <p>|</p>
      <input class="choose" type="text" name="Location" placeholder="Enter Location" required />
      <input id="search-btn" type="submit" name="search" value="Search" />
    </form>

    <a href="update-user.jsp">Profile</a>
  </nav>
  <% LinkedList<Job> ls=Jobdao.getalljob(); %>

  <div class="home">
  <% for(int i=0;i<ls.size();i++) {
   Job j=ls.get(i);%>
    <a href="jobview?id=<%=j.getId() %>">
      <div class="content">
        <div id="con1">
          <div id="title">
          
            <h1><%=j.getRole() %></h1>
            <p>company name</p>
          </div>
          <br>
          <br>
          <div id="info">
            <i class="fa-solid fa-briefcase"></i> <%=(int)j.getMinexp() %>-<%= (int)j.getMaxexp() %> yrs |
            <i class="fa-solid fa-indian-rupee-sign"></i><%=j.getSal() %> lpa |
            <i class="fa-solid fa-location-dot"></i> <% String location=j.getLoc();
            String[] loc=location.split(",");
            for(int k=0;k<loc.length;k++){
            %> <%=loc[k] %>.<%} %>|
          </div>
          <br>
          <div id="dis">
            <i class="fa-regular fa-newspaper"></i> <%= j.getDiscription() %>>
          </div>
          <br>
          <div id="skills">
          <i class="fa-solid fa-microchip"></i><%= j.getSkills() %>
            
          </div>

        </div>
        <div id="img">
          <img src="./add-profile-picture-icon-upload-photo-of-social-media-user-vector.jpg" alt="" height="110px"
            width="110px">
        </div>
      </div>
    </a>
    <%} %>

  </div>


</body>
</html>