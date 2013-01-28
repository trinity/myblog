<%@ tag description="Sidebar template" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sec:authorize var="authenticated" access="isAuthenticated()"/>	

<div class="row-fluid" style="margin-bottom: 30px;">
	<ul class="nav nav-list">
		<li class="nav-header">List header</li>
		<li class="active"><a href="/myblog-webapp/posts">Home</a></li>
		<li><a href="#">Library</a></li>
	</ul>
</div>
				
<div class="row-fluid">
	<form class="form-search">
		<div class="input-append">
			<input type="text" class="span10 search-query">
			<button type="submit" class="btn">Search</button>
		</div>
	</form>
</div>

<div class="row-fluid">
	<c:choose>
		<c:when test="${authenticated}">
			<div>Logged in as <strong><sec:authentication property="principal.username"/></strong></div>
			<a href="/myblog-webapp/auth/logout" role="button" class="btn">Log out</a>
			<a href="/myblog-webapp/posts/add" role="button" class="btn">Add post</a>
		</c:when>
		<c:otherwise>
			<div>Not logged in.</div>
			<a href="/myblog-webapp/auth/login" role="button" class="btn">Log in</a>
		</c:otherwise>
	</c:choose>
</div>