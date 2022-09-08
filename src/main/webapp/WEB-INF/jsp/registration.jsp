<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
</head>
<body>
	<div class = "registration">
	    <form action="controller" method="post">
		<input type="hidden" name="command" value="do_registration">
			<p>Введите имя</p>
			<input type="text" name="name" placeholder="Введите имя">
			<p>Введите фамилию</p>
			<input type="text" name="surname" placeholder="Введите фамилию">
			<p>Введите email</p>
			<input type="email" name="email" placeholder="Введите email">
			<p>Введите login</p>
			<input type="login" name="login" placeholder="Введите login">
			<p>Введите пароль</p>
			<input type="password" name="password" placeholder="Введите пароль">
			
			<c:forEach var="invalidData" items="${sessionScope.RegistrationError}">
				<font color="red">
					<c:out value="${invalidData}"/><br>
				</font>
			</c:forEach>
			
			<input type="submit" value="Registration">
			
			
	</form>
	</div>
</body>
</html> 