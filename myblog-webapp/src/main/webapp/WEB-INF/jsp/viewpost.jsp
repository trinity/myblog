<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:basetemplate>
	<jsp:body>
	
		<div id="addCommentModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="addCommentModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
				<h3 id="addCommentModalLabel">Add comment</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="commentUsername">User name</label>
						<div class="controls">
							<input id="commentUsername" type="text" name="commentUsername" placeholder="User name"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="commentText">Comment</label>
						<div class="controls">
							<textarea id="commentText" name="commentText" placeholder="Comment" cols="10" rows="10"></textarea>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<div class="control-group">
					<div class="controls">
						<button id="cancelCommentButton" class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
						<button id="saveCommentButton" class="btn btn-primary">Save</button>
					</div>
				</div>
			</div>
		</div>
	
		<div class="row-fluid">
			<c:choose>
				<c:when test="${post != null}">
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
										<a href="#addCommentModal" data-toggle="modal">Comment</a>
										<c:if test="${authenticated}">
											| <a href="/myblog-webapp/posts/delete/${post.id}">Delete</a>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
					<c:choose>
						<c:when test="${post.comments != null}">
							<div id="comments" class="row-fluid">
								<div class="span9 well well-large">
									<div class="row-fluid">
										<div class="span12">
											<h4>Comments for post '${post.title}'</h4>
											<hr/>
										</div>
									</div>
									<c:forEach items="${post.comments}" var="comment">
										<div class="row-fluid">
											<div class="span12">
												<span><strong>${comment.username} commented on ${comment.date}:</strong></span>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span12">
												<span>${comment.text}</span>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div id="comments" class="row-fluid">
								<div class="span9 well well-large">
									<div class="row-fluid">
										<div class="span12">
											No comments yet.
										</div>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<div class="row-fluid">
						<div class="span9 well well-large">
							<div class="row-fluid">
								<div class="span12">
									No such post exists.
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		
		<script>
			$(document).ready(function() {
				
				$("#saveCommentButton").click(function() {
					var username = $("#commentUsername").val();
					var text = $("#commentText").val();
													
					$.post("/myblog-webapp/posts/view/${post.id}/comments/add", { "username" : username, "text" : text })
						.success(function() {
							$("#commentUsername").val("");
							$("#commentText").val("");
							$("#addCommentModal").modal("hide");
							$("#comments").load("/myblog-webapp/posts/view/${post.id} #comments");
						})
						.error(function() {
							alert('Error: ' + e);
						});
				});
				
				$("#cancelCommentButton").click(function() {
					$("#commentUsername").val("");
					$("#commentText").val("");
				});
			});
		</script>
		
	</jsp:body>
</t:basetemplate>