<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
	font-family: Arial, Helvetica, sans-serif;
    min-height: 100vh;
    display: flex;
    align-items: center;/* Căn giữa theo chiều dọc phải sử dụng chung với display: flex*/
    justify-content: center;/* Căn giữa theo chiều ngang phải sử dụng chung với display: flex*/
    padding: 20px;
    /* background: rgb(255, 255, 255); */
}
form {
	width: 700px;
	height: 700px;
	border: 3px solid #f1f1f1;
    background-color: white; /* Màu nền của div */
    border-radius: 20px; /* Bo góc 20px */
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  /* padding-top: 16px; */
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>
<form action="/LTWEB_C2/login" method="post">
  <div class="imgcontainer">
    <img src="https://fit.hcmute.edu.vn/Resources/Images/SubDomain/fit/FIT-DoanHoi.png" alt="Avatar" class="avatar">
  </div>
  <c:if test="${alert !=null}">
		<h3 class="alert alertdanger">${alert}</h3>
	</c:if>

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
    
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
    <span class="psw">Forgot <a href="/LTWEB_C2/forgotpassword">password?</a></span>
    <button type="submit">Login</button>
  </div>

  <div class="container" style="text-align: center;">
    <!-- <button type="button" class="cancelbtn">Cancel</button> -->
    
    <span class="reg">Don't have an account? <a href="/LTWEB_C2/register" style="font-weight: bold;">Register</a></span>
  </div>
</form>

</body>
</html>