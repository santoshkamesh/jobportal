<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="resource.Collagedao"%>
<%@page import="dto.Collage"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/update-user.css">
  <script src="https://kit.fontawesome.com/a3f5006001.js" crossorigin="anonymous"></script>
<title>Insert title here</title>

</head>
<body>
	<div id="top">
    <div id="img">
    <% 
    session =request.getSession();
    User u=(User)session.getAttribute("user");
    Collage collage=Collagedao.getclg(u.getId());
    
    List<String> degreeValues = Arrays.asList(
    	    "btech",
    	    "be",
    	    "bca",
    	    "bsc_cs",
    	    "bsc_it",
    	    "mtech",
    	    "me",
    	    "mba",
    	    "mca",
    	    "msc_cs",
    	    "msc_it",
    	    "ba",
    	    "bcom",
    	    "ma",
    	    "mcom",
    	    "phd",
    	    "other"
    	);
    
    List<String> degreeLabels = Arrays.asList(
    	    "B.Tech (Bachelor of Technology)",
    	    "B.E (Bachelor of Engineering)",
    	    "BCA (Bachelor of Computer Applications)",
    	    "B.Sc (Bachelor of Science) in Computer Science",
    	    "B.Sc (Bachelor of Science) in Information Technology",
    	    "M.Tech (Master of Technology)",
    	    "M.E (Master of Engineering)",
    	    "MBA (Master of Business Administration)",
    	    "MCA (Master of Computer Applications)",
    	    "M.Sc (Master of Science) in Computer Science",
    	    "M.Sc (Master of Science) in Information Technology",
    	    "B.A (Bachelor of Arts)",
    	    "B.Com (Bachelor of Commerce)",
    	    "M.A (Master of Arts)",
    	    "M.Com (Master of Commerce)",
    	    "PhD (Doctor of Philosophy)",
    	    "Other"
    	);
    
    List<String> specializationValues = Arrays.asList(
    	    "cs",
    	    "it",
    	    "ece",
    	    "eee",
    	    "mechanical",
    	    "civil",
    	    "biotech",
    	    "aerospace",
    	    "ai_ml",
    	    "data_science",
    	    "finance",
    	    "marketing",
    	    "human_resources",
    	    "operations",
    	    "psychology",
    	    "sociology",
    	    "other"
    	);
    
    List<String> specializationLabels = Arrays.asList(
    	    "Computer Science",
    	    "Information Technology",
    	    "Electronics and Communication Engineering",
    	    "Electrical and Electronics Engineering",
    	    "Mechanical Engineering",
    	    "Civil Engineering",
    	    "Biotechnology",
    	    "Aerospace Engineering",
    	    "Artificial Intelligence and Machine Learning",
    	    "Data Science",
    	    "Finance",
    	    "Marketing",
    	    "Human Resources",
    	    "Operations Management",
    	    "Psychology",
    	    "Sociology",
    	    "Other"
    	);
    
    List<String> examinationBoards = Arrays.asList(
    	    "CBSE (Central Board of Secondary Education)",
    	    "ICSE (Indian Certificate of Secondary Education)",
    	    "State Board (Choose your state's board)",
    	    "NIOS (National Institute of Open Schooling)",
    	    "Uttar Pradesh Board of High School and Intermediate Education",
    	    "Maharashtra State Board of Secondary and Higher Secondary Education",
    	    "Rajasthan Board of Secondary Education",
    	    "West Bengal Board of Secondary Education",
    	    "Tamil Nadu State Board",
    	    "Karnataka Secondary Education Examination Board",
    	    "Andhra Pradesh Board of Secondary Education",
    	    "Kerala Board of Public Examinations",
    	    "Gujarat Secondary and Higher Secondary Education Board",
    	    "Bihar School Examination Board",
    	    "Haryana Board of School Education",
    	    "Punjab School Education Board",
    	    "Madhya Pradesh Board of Secondary Education",
    	    "Other"
    	);
    
    %>
      <a href="#popup5"><img src="viewpic?id=<%=u.getId()%>" alt=""
          height="170px" width="170px" /></a>
    </div>
    <div id="personal">
    
    
    
    
    
      <h1><%= u.getName() %></h1>
      <sup><a href="#popup1">
          <i class="fa-solid fa-pen fa-sm"></i>
        </a></sup>
        
        <%
        if(collage!=null){%>
      <p><%= degreeLabels.get(degreeValues.indexOf(collage.getDegree())) %></p>
      <p><%= collage.getCollagename() %></p>
      <%} %>
      <hr />
      <div id="topdown">
        <div id="bottomleft" class="bottom">
          <i class="fa-solid fa-location-dot"></i>location
          <br />
          <br />
          <i class="fa-solid fa-venus-mars"></i>
          <span><%= u.getGender() %></span>
          <br />
          <br />
          <i class="fa-solid fa-cake-candles"></i><%=u.getDob() %>
          <br />
          <br />
        </div>
        <div id="bottomright" class="bottom">
          <i class="fa-solid fa-phone"></i>
          <span><%= u.getPhone() %></span>
          <br />
          <br />
          <i class="fa-regular fa-envelope"></i><span><%= u.getEmail() %></span>
          <br />
          <br />
        </div>
      </div>
    </div>
  </div>
  <div id="education">
    <a href="#popup2"><h1>Education</h1></a>

    <br>
    <%if(collage!=null){ %>
    <span><%= degreeLabels.get(degreeValues.indexOf(collage.getDegree()))%>,<%= specializationLabels.get(specializationValues.indexOf(collage.getSpecialization()))%> from <%= collage.getCollagename() %></span><br>
    <span>Graduating in <%= collage.getYop() %>, <%=collage.getType() %></span>
    <%} %>
    <br>
    <br>
    <br>
    <a href="#popup3"><span>Class XII </span></a><br>
    <span>Tamil Nadu, English</span><br>
    <span>Scored 70.5%, Passed out in 2020</span>
    <br>
    <br>
    <a href="#popup4"><span>Class X</span></a><br>
    <span>Tamil Nadu, English</span><br>
    <span>Scored 78%, Passed out in 2018</span>


  </div>
  <div id="career">
    <div>
      <a href="#popup5">
        <h1>carier</h1>
      </a>
      <h1>preferences</h1>
    </div>
    <div id="career-left" class="careers">
      <span>Preferred job type</span><br>
      <span>jobs, Internships</span>
      <br>
      <br>
      <span>Preferred location</span><br>
      <span>Chennai, Kanchipuram, Chengalpattu</span>
    </div>
    <div id="career-right" class="careers">
      <span>Availability to work</span><br>
      <span>15 Days or less</span>
    </div>
  </div>
  <div id="skills">
    <h1>Key skills </h1>
    <br>
    <p>MySQL,
      JDBC,
      Java,
      Core Java Programming,
      Oracle SQL</p>
  </div>
  <div id="popup1" class="overlay">
    <div class="popup">
      <div class="content">
        <div id="form1">
          <form  method="post" action="personal">
            <label for="fullname">Full Name<sup>*</sup></label><br>
            <%String name=u.getName();
            		if(name==null){%>
            		<input class="required" type="text" name="fname" id="fullname" value="tell us your name" autofocus
              required><br>	
            		
              <%
              }
            		else{ %>
            		
            	<input class="required" type="text" name="fname" id="fullname" value=<%=name %> autofocus
              required><br>	
            <% 
            		}
            		%>
            <br>
            <label for="email">Email address<sup>*</sup></label><br>
            <%String email=u.getEmail();
            		if(name==null){%>
            		<input class="required" type="email" name="mail" id="email" placeholder="Tell us your Email Id">
            		
              <%
              }
            		else{ %>
            		
            	<input class="required" type="email" name="mail" id="mail" value=<%=email %> autofocus
              required><br>	
            <% 
            		}
            		%>
            <br>
            <br>
            <label for="">gender<sup>*</sup></label>
            <br>
            <% String gender=u.getGender();
            		if(gender.equals("male")){%>
            		<input type="radio" name="gender" id="male" value="male" checked required>
            <input type="radio" name="gender" id="female" value="female" required>
            <input type="radio" name="gender" id="others" value="others" required>
            <header id="filter">
              <label for="male" class="filter-label featured" id="male-label">Male</label>
              <label for="female" class="filter-label personal" id="female-label">Female</label>
              <label for="others" class="filter-label tech" id="others-label">Others</label>
            </header>
            <%}
            		else if(gender.equals("female")){%>
            		<input type="radio" name="gender" id="male" value="male"  required>
            <input type="radio" name="gender" id="female" value="female" checked required>
            <input type="radio" name="gender" id="others" value="others" required>
            <header id="filter">
              <label for="male" class="filter-label featured" id="male-label">Male</label>
              <label for="female" class="filter-label personal" id="female-label">Female</label>
              <label for="others" class="filter-label tech" id="others-label">Others</label>
            </header>
            <% }
            else{%>
            <input type="radio" name="gender" id="male" value="male"  required>
            <input type="radio" name="gender" id="female" value="female" required>
            <input type="radio" name="gender" id="others" value="others" checked required>
            <header id="filter">
              <label for="male" class="filter-label featured" id="male-label">Male</label>
              <label for="female" class="filter-label personal" id="female-label">Female</label>
              <label for="others" class="filter-label tech" id="others-label">Others</label>
            </header>
            <%} %>
            <br>
            <label for=""></label>
            <label for="phone">Phone<sup>*</sup></label><br>
            <%String phone=""+u.getPhone();
            		if(name==null){%>
            		<input class="required" type="phone" name="mobo" id="phone" required placeholder="enter your mobile number">
            		
              <%
              }
            		else{ %>
            		
            	<input class="required" type="phone" name="mobo" id="fullname" value=<%=phone %> autofocus
              required><br>	
            <% 
            		}
            		%>
            
            <br>
            <br>
            <label for="fullname">DOB<sup>*</sup></label><br>
            <%String dob=u.getDob();
            		if(dob==null){%>
            		<input class="required" type="date" name="udob" id="dob" value="tell us you date of birth" autofocus
              required><br>	
            		
              <%
              }
            		else{ %>
            		
            	<input class="required" type="date" name="udob" id="dob" value=<%=dob %> autofocus
              required><br>	
            <% 
            		}
            		%>
            <br>
            <br>
            <label for="">Work status</label><br>
            <%
            String workstatus=u.getWorkstatus();
            		
            if(workstatus==null){%>
            <input type="radio" name="wexp" id="exp" value="experienced"><label for="exp">experienced</label>
            <input type="radio" name="wexp" id="fresh" value="fresher"><label for="fresh">fresher</label>
            
            	
           <% }
            else if(workstatus.equals("experienced")){%>
            <input type="radio" name="wexp" id="exp" value="experienced" checked><label for="exp">experienced</label>
            <input type="radio" name="wexp" id="fresh" value="fresher"><label for="fresh">fresher</label>
            
            <%}
            else {
            %>
            <input type="radio" name="wexp" id="exp" value="experienced"><label for="exp">experienced</label>
            <input type="radio" name="wexp" id="fresh" value="fresher" checked><label for="fresh">fresher</label>
            <%} %>
            <br>
            <br>
            <a href="#"><input type="button" value="close"></a>
            <input type="submit" value="submit">

          </form>
        </div>
      </div>
    </div>
  </div>

  <div id="popup2" class="overlay">
    <div class="popup">
      <div class="content">
        <div id="form2">
          <form method="post" action="clg">
            <h1>Education</h1>
            <p>Adding your educational details help recruiters know your value as a potential candidate</p>
            <label for="course">Select a Course:</label>
            <%
            if(collage==null){
            %>
            <select id="course" name="course" class="required">
              <%
			        for (int i = 0; i < degreeValues.size(); i++) {
			    %>
			        <option value="<%= degreeValues.get(i) %>"><%= degreeLabels.get(i) %></option>
			    <%
			        }
			            
			    %>
			</select>
			
			<%
			}
            else {%>
             <select id="course" name="course" class="required">
             <option value="<%= collage.getDegree() %>"><%= degreeLabels.get(degreeValues.indexOf(collage.getDegree())) %></option>
             <%
			        for (int i = 0; i < degreeValues.size(); i++) {
			    %>
			        <option value="<%= degreeValues.get(i) %>"><%= degreeLabels.get(i) %></option>
			    <%
			        }
            }
			            
			    %>
			</select><br>
            <br>
            <label for="specialization">Select a Specialization:</label><br>
            
            
            <%
            

            if(collage==null){
                %>
                <select id="specialization" name="specialization" class="required">
                  <%
    			        for (int i = 0; i < specializationValues.size(); i++) {
    			    %>
    			        <option value="<%= specializationValues.get(i) %>"><%= specializationLabels.get(i) %></option>
    			    <%
    			        }
    			            
    			    %>
    			</select>
    			
    			<%
    			}
            else{%>
             <select id="specialization" name="specialization" class="required">
             <option value="<%= collage.getSpecialization() %>"><%= specializationLabels.get(specializationValues.indexOf(collage.getSpecialization())) %></option>
             <%
			        for (int i = 0; i < specializationValues.size(); i++) {
			    %>
			        <option value="<%= specializationValues.get(i) %>"><%= specializationLabels.get(i) %></option>
			    <%
			        }
            }
			            
			    %>
			</select>
            
              
            <br>
            <br>
            <label for="">College name</label>
            <br>
            <% if(collage!=null){
            	String s=collage.getCollagename();%>
            <input type="text" name="clg" id="uclg" class="required" value="<%=s %>">
            <%} 
            else{%>
            <input type="text" name="clg" id="uclg" class="required">
            <% }
            %>
            <br>
            <br>
            <br>
            <label for="course_duration_end">Course End Year:</label>
            
            
            <%
            

            if(collage==null){
                %>
                <select class="required" id="course_duration_end" name="complete">
                  <%
    			        for (int i = 2012; i <= 2025; i++) {
    			    %>
    			        <option value="<%= i %>"><%= i %></option>
    			    <%
    			        }
    			            
    			    %>
    			</select>
    			
    			<%
    			}
            else{%>
             <select class="required" id="course_duration_end" name="complete">
             <option value="<%= collage.getYop() %>"><%= collage.getYop() %></option>
             <%
			        for (int i = 2012; i <= 2025; i++) {
			    %>
			        <option value="<%= i %>"><%= i %></option>
			    <%
			        }
            }
			            
			    %>
			</select>

              
            <br><br>
            <label for="">CGPA</label>
            <br>
            <%if(collage==null){ %>
            <input type="text" name="cgpa" id="cgpa" class="required">
            <%}
            else{%>
            <input type="text" name="cgpa" id="cgpa" class="required" value="<%= collage.getCgpa()%>">
            <%} %>
            <br>
            <br>
            <br>
            <%if(collage==null){ %>
            <label for="">Course type</label><br>
            <input type="radio" name="ctype" id="ufull" value="fulltime"><label for="ufull" >fulltime</label>
            <input type="radio" name="ctype" id="upart" value="parttime"><label for="upart" >Part Time</label>
            <%}
            else if(collage.getType().equals("fulltime")){%>
            <label for="">Course type</label><br>
            <input type="radio" name="ctype" id="ufull" value="fulltime" checked ><label for="ufull"  >fulltime</label>
            <input type="radio" name="ctype" id="upart" value="parttime"><label for="upart" >Part Time</label>
            <%}
            else{
            %>
            <label for="">Course type</label><br>
            <input type="radio" name="ctype" id="ufull" value="fulltime"><label for="ufull" >fulltime</label>
            <input type="radio" name="ctype" id="upart" value="parttime" checked ><label for="upart" >Part Time</label>
            <%} %>
            <br>
            <br>
            <a href="#"><input type="button" value="close"></a>
            <input type="submit" value="submit">

          </form>
        </div>
      </div>
    </div>
  </div>
  <div id="popup3" class="overlay">
    <div class="popup">
      <div class="content">
        <div id="form3">
          <form action="xii">
            <label for="board">Examination Board:</label>
            <select class="required" id="board" name="board" >
              <option value="cbse">CBSE (Central Board of Secondary Education)</option>
              <option value="icse">ICSE (Indian Certificate of Secondary Education)</option>
              <option value="state_board">State Board (Choose your state's board)</option>
              <option value="nios">NIOS (National Institute of Open Schooling)</option>
              <option value="up_board">Uttar Pradesh Board of High School and Intermediate Education</option>
              <option value="maharashtra_board">Maharashtra State Board of Secondary and Higher Secondary Education
              </option>
              <option value="rajasthan_board">Rajasthan Board of Secondary Education</option>
              <option value="west_bengal_board">West Bengal Board of Secondary Education</option>
              <option value="tamil_nadu_board">Tamil Nadu State Board</option>
              <option value="karnataka_board">Karnataka Secondary Education Examination Board</option>
              <option value="andhra_board">Andhra Pradesh Board of Secondary Education</option>
              <option value="kerala_board">Kerala Board of Public Examinations</option>
              <option value="gujarat_board">Gujarat Secondary and Higher Secondary Education Board</option>
              <option value="bihar_board">Bihar School Examination Board</option>
              <option value="haryana_board">Haryana Board of School Education</option>
              <option value="punjab_board">Punjab School Education Board</option>
              <option value="mp_board">Madhya Pradesh Board of Secondary Education</option>
              <option value="other">Other</option>
            </select>
            <br><br>


            <label for="medium">Medium of Study:</label>
            <select class="required" id="medium" name="medium">
              <option value="english">English</option>
              <option value="hindi">Hindi</option>
              <option value="tamil">Tamil</option>
              <option value="telugu">Telugu</option>
              <option value="malayalam">Malayalam</option>
              <option value="marathi">Marathi</option>
              <option value="gujarati">Gujarati</option>
              <option value="bengali">Bengali</option>
              <option value="urdu">Urdu</option>
              <option value="kannada">Kannada</option>
              <option value="punjabi">Punjabi</option>
              <option value="other">Other</option>
            </select>
            <br><br>


            <label for="percentage">Percentage:</label>
            <input class="required" type="number" id="percentage" name="percentage" step="0.01"
              placeholder="Enter your percentage" min="0" max="100">
            <br><br>


            <label for="passing_year">Passing Year:</label>
            <input class="required" type="text" id="passing_year" name="passing_year"
              placeholder="Enter your passing year">
            <br><br>
            <a href="#"><input type="button" value="close"></a>
            <input type="submit" value="Submit">
          </form>
        </div>
      </div>
    </div>
  </div>
  <div id="popup4" class="overlay">
    <div class="popup">
      <div class="content">
        <div id="form4">
          <form method="post" action="x">

            <label for="board">Examination Board:</label>
            <select class="required" id="board" name="board">
              <option value="cbse">CBSE (Central Board of Secondary Education)</option>
              <option value="icse">ICSE (Indian Certificate of Secondary Education)</option>
              <option value="state_board">State Board (Choose your state's board)</option>
              <option value="nios">NIOS (National Institute of Open Schooling)</option>
              <option value="up_board">Uttar Pradesh Board of High School and Intermediate Education</option>
              <option value="maharashtra_board">Maharashtra State Board of Secondary and Higher Secondary Education
              </option>
              <option value="rajasthan_board">Rajasthan Board of Secondary Education</option>
              <option value="west_bengal_board">West Bengal Board of Secondary Education</option>
              <option value="tamil_nadu_board">Tamil Nadu State Board</option>
              <option value="karnataka_board">Karnataka Secondary Education Examination Board</option>
              <option value="andhra_board">Andhra Pradesh Board of Secondary Education</option>
              <option value="kerala_board">Kerala Board of Public Examinations</option>
              <option value="gujarat_board">Gujarat Secondary and Higher Secondary Education Board</option>
              <option value="bihar_board">Bihar School Examination Board</option>
              <option value="haryana_board">Haryana Board of School Education</option>
              <option value="punjab_board">Punjab School Education Board</option>
              <option value="mp_board">Madhya Pradesh Board of Secondary Education</option>
              <option value="other">Other</option>
            </select>
            <br><br>


            <label for="medium">Medium of Study:</label>
            <select class="required" id="medium" name="medium">
              <option value="english">English</option>
              <option value="hindi">Hindi</option>
              <option value="tamil">Tamil</option>
              <option value="telugu">Telugu</option>
              <option value="malayalam">Malayalam</option>
              <option value="marathi">Marathi</option>
              <option value="gujarati">Gujarati</option>
              <option value="bengali">Bengali</option>
              <option value="urdu">Urdu</option>
              <option value="kannada">Kannada</option>
              <option value="punjabi">Punjabi</option>
              <option value="other">Other</option>
            </select>
            <br><br>


            <label for="percentage">Percentage:</label>
            <input class="required" type="number" id="percentage" name="percentage" step="0.01"
              placeholder="Enter your percentage" min="0" max="100">
            <br><br>


            <label for="passing_year">Passing Year:</label>
            <input class="required" type="text" id="passing_year" name="passing_year"
              placeholder="Enter your passing year">
            <br><br>
            <a href="#"><input type="button" value="close"></a>
            <input type="submit" value="Submit">
          </form>
        </div>
      </div>
    </div>
  </div>
  
	<div id="popup5" class="overlay">
    <div class="popup">
      <div class="content">
        <div id="form5">
        <form method="post" action="upload" enctype="multipart/form-data">
		profile_pic:<input type="file" name="photo"><br>
		<br>
		<a href="#"><input type="button" value="close"></a>
	<input type="submit"></form>
          
        </div>
      </div>
    </div>
  </div>
	
</body>
</html>