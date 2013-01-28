<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/paging.tld" prefix="pg" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:basetemplate>
	<jsp:body>
		
		<sec:authorize var="authenticated" access="isAuthenticated()"/>	
	
		<div class="row-fluid">
			<c:choose>
				<c:when test="${postCount > 0}">
					<c:forEach items="${postList}" var="post">
						<div class="row-fluid">
							<div class="span9 well well-large">
								<div class="row-fluid">
									<div class="span12">
										<h2>${post.title}</h2>
									</div>
								</div>
								<div class="row-fluid">
									<div class="span12">
										${post.text} 
									</div>
								</div>
								<div class="row-fluid">
									<div class="span12">
										<hr/>
										<span class="label">${post.date} by ${post.user.username}</span>
										<div style="float: right;">
										<a href="posts/view/${post.id}">View</a>
										<c:if test="${authenticated}">
											| <a href="posts/delete/${post.id}">Delete</a>
										</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="row-fluid">
						<div class="span9 well well-large">
							<div class="row-fluid">
								<div class="span12">
									No posts.
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		
		<c:if test="${pageCount > 1}">
			<div class="row-fluid">
				<div class="span10 offset3">
					<div class="pagination" id="pager">
						<pg:paging currentPage="${currentPage}" totalPageCount="${pageCount}"/>
					</div>
				</div>
			</div>
		</c:if>
		
	</jsp:body>
</t:basetemplate>