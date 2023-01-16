<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center">
<h1>Welcome to form page</h1>
<form action="employeeForm" method="POST">
<input type="text" name="firstName" placeholder="First Name" /> <br />
<input type="text" name="lastName" placeholder="Last Name" /> <br />
<label for="start">DOB</label>
<input type="date" id="start" name="DOB" placeholder="Date of birth" value="1998-07-24" /> <br />

<label for="gender">Gender:</label>

<select name="gender" id="gender">
  <option value="Male">Male</option>
  <option value="Female">Female</option>
  <option value="Others">Others</option>
</select> <br/>


<input type="text" name="location" placeholder="Location" /> <br />
<input type="number" name="experience" placeholder= "Experience" /> <br />
<input type="text" name="skills" placeholder="Skills" /> <br />
<input type="tel" name="phone" placeholder="Contact Number" pattern="[0-9]{10}" required><br>
<input type="email" name="email" placeholder= "Email" /> <br />
<input type="text" name="pocName" placeholder= "POC Name" /> <br />
<input type="email" name="pocEmail" placeholder= "POC Email" /> <br /><br />
<input type="submit" value="Submit" /> <br />
</form>
</body>
</html>