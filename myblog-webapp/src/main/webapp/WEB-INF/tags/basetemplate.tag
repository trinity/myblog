<%@ tag description="Base template" pageEncoding="UTF-8" %>
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
				
				<!-- siderbar -->
				<div class="span2 offset2">
					<t:sidebar/>
				</div>
				
				<!-- main -->
				<div class="span8">
					<jsp:doBody/>
				</div>
			</div>
		</div>
	
		<t:footer/>
	</body>
</html>