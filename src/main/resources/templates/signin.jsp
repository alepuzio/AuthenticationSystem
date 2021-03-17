<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Sign In</title>
<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8" />
<link rel="stylesheet" href="../static/style.css">
</head>
<body>
	<h1>Sign In in Templates</h1>
	<p>
		Please fill the form to signin. <br />
		If you're not recorded, you can signup <a href="signup">here</a>.
	</p>
	<form action="/signin" method="get">
		<p>
			<label for="username">
				<b>Username</b>
				<input  name="username" placeholder="Enter Username" required size="20" type="text" >
			</label> <br>
			<label for="password">
				<b>Password</b>
				<input  name="password"  placeholder="Enter Password" required size="20" type="password" >
			</label><br> 
		</p>
		
		<div class="clearfix">
			<button type="button" class="cancelbtn">Cancel</button><!--TODO javascript to blank the fields -->
			<button type="submit" class="signupbtn">Sign In</button>
		</div>
		
		<div id="error" th:if="${errors != null}">
		<p class="errors">
		WARNING: your signin failed for	<span th:text="${errors}">.</span>
		</p>
		</div>
	</form>

</body>
</html>
