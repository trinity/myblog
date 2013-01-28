<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:nosidebartemplate>
	<jsp:body>
		<form action="/myblog-webapp/j_spring_security_check" method="post" class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="j_username">User name</label>
				<div class="controls">
					<input type="text" id="j_username" name="j_username" placeholder="User name">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="j_password">Password</label>
				<div class="controls">
					<input type="password" id="j_password" name="j_password" placeholder="Password">
				</div>
			</div>
			
			<!-- 
			<div class="control-group">
				<div class="controls">
					<label class="checkbox">
						<input type="checkbox"> Remember me
					</label>
				</div>
			</div> -->
			
			<div class="control-group">
				<div class="controls">
					<a href="/myblog-webapp/posts" role="button" class="btn">Cancel</a>
					<button type="submit" class="btn btn-primary">Log in</button>
				</div>
			</div>
		</form>
	</jsp:body>
</t:nosidebartemplate>