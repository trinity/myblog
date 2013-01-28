<%@ tag description="No sidebar template" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!DOCTYPE html>
<html>
	
	<t:header/>
		
	<body>     		
		<div class="container-fluid">
			
			<div class="row-fluid">
				<t:title/>
			</div>
		
			<div class="row-fluid">
				<div class="span6 offset4">
					<jsp:doBody/>
				</div>
			</div>
		</div>
	
		<t:footer/>
	</body>
</html>