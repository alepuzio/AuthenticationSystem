<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "    http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign In</title>
<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8" />
<link rel="stylesheet" href="../static/style.css">
</head>
<body>
	<h1>Sign In</h1>
	<p>
		Please fill the form to signin. <br />
		If you're not recorded, you can signup <a href="signup">here</a>.
	</p>
	<form action="/signin" method="get">
		<p>
			<label for="username">
				<b>Username</b>
				<input type="text" placeholder="Enter Username" name="username"  size="20"  ><!-- todo required -->
			</label> <br>
			<label for="password">
				<b>Password</b>
				<input placeholder="Enter Password" name="password"  size="20" type="password"><!-- todo required -->
			</label><br> 
		</p>
		
		<div class="clearfix">
			<button type="button" class="cancelbtn">Cancel</button><!--TODO javascript to blank the fields -->
			<button type="submit" class="signupbtn">Sign In</button>
		</div>
		
		<div id="errors" >
		<p>
		WARNING: your signin failed for : th:text="${errors}".
		</p>
		</div>
	</form>

</body>
</html>
