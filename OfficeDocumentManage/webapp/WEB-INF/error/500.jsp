<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%

	pageContext.setAttribute("contextRootPath",	request.getContextPath());
	
 %>


<script>
	GLOBAL_CONTEXT_ROOT_PATH = "${contextRootPath}";
</script>


<html>
	<head>
		<title>掌上安邦应用系统</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<body onclick="javascript:window.location.href='${contextRootPath}/'">
		
			<div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>		
					
			<div style="display: none">
				<ajax-notification>
					<ajax-result>500</ajax-result>
					<ajax-code>500</ajax-code>	
					<ajax-desc>系统正在维护中，请见谅...</ajax-desc>
				</ajax-notification>
			</div>
			
			
			
			
			<div style="padding: 10px;margin: auto;width: 100%;text-align: center;margin-top: 100px;" class="globalerror">
				<img src="${contextRootPath}/images/500.jpg">
			</div>
			
		</body>
</html>


