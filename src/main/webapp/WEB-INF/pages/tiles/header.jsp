<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="local.sign_in_button.name"
	var="sign_in_button" />
<fmt:message bundle="${loc}" key="local.sign_out_button.name"
	var="sign_out_button" />
<fmt:message bundle="${loc}" key="local.header_title.name"
	var="header_title" />
<fmt:message bundle="${loc}" key="local.login_label.name"
	var="login_label" />
<fmt:message bundle="${loc}" key="local.password_label.name"
	var="password_label" />
<fmt:message bundle="${loc}" key="local.registration_button.name"
	var="registration_button" />	
	

<div class="wrapper">
	<div class="newstitle">${header_title}</div>


	<div class="local-link">

		<c:if test="${not (sessionScope.user eq 'active')}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" /> 
					${login_label} <input type="text" name="login" value="" /><br /> 
					${password_label} <input type="password" name="password" value="" /><br />

					<c:if test="${not (requestScope.AuthenticationError eq null)}">
						<font color="red"> 
						   <c:out value="${requestScope.AuthenticationError}" />
						</font> 
					</c:if>
					<c:if test="${requestScope.isRegistrationComplite eq true }">
						<font color="green"> 
						   <c:out value="Succesfull registration!" />
						</font> 
					</c:if>
					<input type="submit" value="${sign_in_button}" /><br />
				</form>
				<a href= controller?command=go_to_registration_page >${registration_button}</a>
				<c:if test="${not (sessionScope.user eq 'active')}">
					<a href= controller?command=change_local&local=en >${en_button}</a> 
					<a href= controller?command=change_local&local=ru >${ru_button}</a>
				</c:if>
			</div>
		</c:if>
		
		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="${sign_out_button}" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
