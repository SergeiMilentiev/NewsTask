<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">
	<form action="controller" method="post"> 
		<div>
			<p>Title:</p>
			<p><input type="text" name="title" value="title" size=30 maxlength=150 required="required"/></p>
        
        	<p>Brief:</p>
			<p><input type="text" name="briefNews" value="briefNews" size=20 maxlength=150 required="required"/></p>
       					
			<p>Content:</p>	
            <p><textarea name="content" required="required"/></textarea></p>
            
       		<p>Date:</p>
			<p><input type="date" name="newsData"/></p>
  		</div>
  <div>
    <input type="hidden" name="command" value="do_add_News" />
    <input type="submit" value="Enter"/>
  </div>
  
  <c:if test = "${sessionScope.news_added_status eq 'news not added'}">
   		<font color="red">
			<c:out value="news not added"/><br>
		</font>
  </c:if>
  
	</form>  
</div>
