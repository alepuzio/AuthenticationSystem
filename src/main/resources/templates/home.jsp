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
		Hello <span th:text="${username}">. </span> <br />
		Thank you to sign in: you' re <span th:text="${name}"></span> <span th:text="${surname}"> </span> with VAT IN <span th:text="${vatin}"> </span>.
		<br/>
		You can <a href="/">logout</a>.
		</p>
	</div>
	
</body>
</html>
