<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:nosidebartemplate>
	<jsp:body>

		<form:form commandName="post" action="/myblog-webapp/posts/add" method="post" class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="title">Post title</label>
				<div class="controls">
					<form:input type="text" name="title" path="title" placeholder="Post title"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="text">Post text</label>
				<div class="controls">
					<form:textarea path="text" name="text" placeholder="Password" cols="10" rows="10"/>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<a href="/myblog-webapp/posts" role="button" class="btn">Cancel</a>
					<form:button type="submit" class="btn btn-primary">Add post</form:button>
				</div>
			</div>
		</form:form>

	</jsp:body>
</t:nosidebartemplate>