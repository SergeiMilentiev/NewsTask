<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.login_label.name"
	var="login_label" />
<fmt:message bundle="${loc}" key="local.password_label.name"
	var="password_label" />
<fmt:message bundle="${loc}" key="local.name_label.name"
	var="name_label" />
<fmt:message bundle="${loc}" key="local.surname_label.name"
	var="surname_label" />
<fmt:message bundle="${loc}" key="local.email_label.name"
	var="email_label" />
<fmt:message bundle="${loc}" key="local.registration_page.name"
	var="registration_page" />
<fmt:message bundle="${loc}" key="local.registration_button.name"
	var="registration_button" />
<fmt:message bundle="${loc}" key="local.invalid_name_label.name"
	var="invalid_name" />
<fmt:message bundle="${loc}" key="local.invalid_surname_label.name"
	var="invalid_surname" />
<fmt:message bundle="${loc}" key="local.invalid_login_label.name"
	var="invalid_login" />
<fmt:message bundle="${loc}" key="local.invalid_password_label.name"
	var="invalid_password" />
<fmt:message bundle="${loc}" key="local.invalid_email_label.name"
	var="invalid_email" />	

<meta charset="UTF-8">
<title>${registration_page}</title>

</head>
<body>
	<div class = "registration">
	    <form action="controller" method="post">
		<input type="hidden" name="command" value="do_registration">
			<p>${name_label}</p>
			<input type="text" name="name" placeholder="${name_label}">
			<c:if test = "${RegistrationError.invalidName eq false}">
				<font color="red">
					<c:out value="${invalid_name}"/><br>
				</font>
			</c:if>
			<p>${surname_label}</p>
			<input type="text" name="surname" placeholder="${surname_label}">
			<c:if test = "${RegistrationError.invalidSurname eq false}">
				<font color="red">
					<c:out value="${invalid_surname}"/><br>
				</font>
			</c:if>
			<p>${email_label}</p>
			<input type="email" name="email" placeholder="${email_label}">
			<c:if test = "${RegistrationError.invalidEmail eq false}">
				<font color="red">
					<c:out value="${invalid_email}"/><br>
				</font>
			</c:if>
			<p>${login_label}</p>
			<input type="text" name="login" placeholder="${login_label}">
			<c:if test = "${RegistrationError.invalidLogin eq false}">
				<font color="red">
					<c:out value="${invalid_logain}"/><br>
				</font>
			</c:if>
			<p>${password_label}</p>
			<input type="password" name="password" placeholder="${password_label}">
			<c:if test = "${RegistrationError.invalidPassword eq false}">
				<font color="red">
					<c:out value="${invalid_password}"/><br>
				</font>
			</c:if>
			<br>
			<br>
			<input type="submit" value="${registration_button}">	
		</form>
	</div>
</body>
</html> 