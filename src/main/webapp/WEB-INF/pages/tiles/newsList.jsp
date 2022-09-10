<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.menu_title.name"
	var="menu_title" />
<fmt:message bundle="${loc}" key="local.menu_news_list_link.name"
	var="news_list" />
<fmt:message bundle="${loc}" key="local.view_news_button_edit.name"
	var="edit_news_button" />
<fmt:message bundle="${loc}" key="local.view_news_title.name"
	var="view_news_button" />

<div class="body-title">
	<a href="">${menu_title} >> </a> ${news_list}
</div>

<form action="" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>

				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
						      <a href="controller?command=go_to_edit_news&id=${news.idNews}">${edit_news_button}</a> 
						</c:if>
						
						<a href="controller?command=go_to_view_news&id=${news.idNews}">${view_news_button}</a> 
   					    
   					    <c:if test="${sessionScope.role eq 'admin'}">
   					         <input type="checkbox" name="idNews" value="${news.idNews }" />
   					    </c:if>
					</div>
				</div>
			</div>
		</div>

	</c:forEach>

	<!-- 	<logic:notEmpty name="newsForm" property="newsList">
		<div class="delete-button-position">
			<html:submit>
				<bean:message key="locale.newslink.deletebutton" />
			</html:submit>
		</div>
	</logic:notEmpty> -->

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        No news.
	</c:if>
	</div>
</form>
