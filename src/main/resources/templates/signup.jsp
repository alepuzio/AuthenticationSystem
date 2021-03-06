<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Sign Up</title>
<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8" />
<link rel="stylesheet" href="../static/style.css">
</head>
<body>
	<h1>Sign Up</h1>
	<p>
		Please fill the form to signup. <br />
		All the data are mandatory.
	</p>
	<form action="/record" method="post">
		<p>
			<label for="name">
			<b>Name</b> 
			<input type="text"	placeholder="Enter Name" name="name" required size="20" value="alessandro">
			</label> <br>
			<label for="surname">
			<b>Surname</b>
			<input type="text" placeholder="Enter Surname" name="surname" required size="20" value="puzielli">
			</label><br>
			<label for="vatin">
			<b>VATIn</b>
			<input type="text" placeholder="Enter VATIn" name="vatin" required size="20"  value="PZLSSNN">
			</label> <br>
			<label for="username">
				<b>Username</b>
				<input type="text" placeholder="Enter Username" name="username" required size="20"  value="alex">
			</label> <br>
			<label for="password">
				<b>Password</b>
				<input placeholder="Enter Password" name="password" required size="20" type="password" value="io">
			</label><br> 
			<label for="repeatpassword">
				<b>Repeat Password</b>
				<input placeholder="Enter Password" name="repeatedPassword" required size="20" type="password" value="io">
			</label><br>
		</p>
		<p>
			By creating an account you agree to <a href="#"style="color: dodgerblue">have more than 18 years</a>.<br/>
			After the record of your data, you will be automatically signin. <br/>
			If you want, you can try to signin in the <a href="/">page</a>.<br/>			
		</p>

		<div class="clearfix">
			<button type="button" class="cancelbtn">Cancel</button><!--TODO javascript to blank the fields -->
			<button type="submit" class="signupbtn">Sign Up</button>
		</div>
	</form>
		<div id="error" th:if="${errors != null}">
			<p class="errors">
				WARNING: there's the error <span style="font-style: italic" th:text="${errors}">.</span>
			</p>
		</div>

</body>
</html>
