<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:nosidebartemplate>
	<jsp:body>
	
		<form:form modelAttribute="user" method="post" action="/myblog-webapp/admin/user/add" class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="username">User name</label>
				<div class="controls">
					<form:input type="text" name="username" path="username" placeholder="User name"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<form:input type="password" name="password" path="password" placeholder="Password"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="firstName">First name</label>
				<div class="controls">
					<form:input type="text" name="firstName" path="firstName" placeholder="First name"/>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="lastName">Last name</label>
				<div class="controls">
					<form:input type="text" name="lastName" path="lastName" placeholder="Last name"/>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="email">Email</label>
				<div class="controls">
					<form:input type="text" name="email" path="email" placeholder="Email"/>
				</div>
			</div>
									
			<div class="control-group">
				<div class="controls">
					<label class="checkbox" for="admin">
						<form:checkbox name="admin" path="admin"/> Admin?
					</label>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<a href="/myblog-webapp/posts" role="button" class="btn">Cancel</a>
					<form:button type="submit" class="btn btn-primary">Save</form:button>
				</div>
			</div>
		</form:form>
		
	</jsp:body>
</t:nosidebartemplate>