<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8" />
<link rel="stylesheet" href="../static/style.css">
</head>
<body>
	<h1>Home</h1>
	<div>
	<p>
		Hello <span style="font-style: italic" th:text="${username}">. </span> <br />
		Thank you to sign in: you' re 
		<span style="font-style: italic" th:text="${name}"></span> 
		<span style="font-style: italic" th:text="${surname}"> </span> 
		with VAT IN <span style="font-style: italic" th:text="${vatin}"> </span>.
		<br/>
		You can <a href="/">logout</a>.
		</p>
	</div>
	

		<div id="error" th:if="${errors != null}">
			<p class="errors">
				WARNING: there's the error <span style="font-style: italic" th:text="${errors}">.</span>
			</p>
		</div>
	
	
</body>
</html>
