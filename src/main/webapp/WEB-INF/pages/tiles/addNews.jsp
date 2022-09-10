<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.view_news_label_news_title.name"
	var="news_title" />
<fmt:message bundle="${loc}" key="local.view_news_label_news_brief.name"
	var="news_brief" />	
<fmt:message bundle="${loc}" key="local.view_news_label_news_content.name"
	var="news_content" />	
<fmt:message bundle="${loc}" key="local.edit_news_button_save.name"
	var="save_button" />	
<fmt:message bundle="${loc}" key="local.news_added_message.name"
	var="news_added" />	
<fmt:message bundle="${loc}" key="local.news_not_added_message.name"
	var="news_not_added" />		

<div align="center">
	<form action="controller" method="post"> 
		<div>
			<p>${news_title}</p>
			<p><input type="text" name="title" value="title" size=30 maxlength=150 required="required"/></p>
        
        	<p>${news_brief}</p>
			<p><input type="text" name="briefNews" value="briefNews" size=20 maxlength=150 required="required"/></p>
       					
			<p>${news_content}</p>	
            <p><textarea name="content" required="required"/></textarea></p>
  		</div>
  <div>
    <input type="hidden" name="command" value="add_news" />
    <input type="submit" value="${save_button}"/>
  </div>
  
  <c:if test = "${sessionScope.news_added_status eq false}">
   		<font color="red">
			<c:out value="${news_not_added}"/><br>
		</font>
  </c:if>
  
  <c:if test = "${sessionScope.news_added_status eq true}">
   		<font color="red">
			<c:out value="${news_added}"/><br>
		</font>
  </c:if>
  
	</form>  
</div>
