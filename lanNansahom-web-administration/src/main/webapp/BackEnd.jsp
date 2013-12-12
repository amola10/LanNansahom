<%@page contentType="text/html;" import="eg.net.lanNansahom.server.GoogleLoginService"%>
<!doctype html>
<html>
<head>
<meta name="gwt:property" content="locale=en_UK">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--                                                               -->
<!-- Consider inlining CSS to reduce the number of requested files -->
<!--                                                               -->
<link type="text/css" rel="stylesheet" href="BackEnd.css">

<!--                                           -->
<!-- Any title is fine                         -->
<!--                                           -->
<title>Lan-nansahom Administration Panel</title>

<!--                                           -->
<!-- This script loads your compiled module.   -->
<!-- If you add any GWT meta tags, they must   -->
<!-- be added before this line.                -->
<!--                                           -->
<%
	boolean isAuthorized = false;
	GoogleLoginService loginService = new GoogleLoginService();
	if (!loginService.isUserLoggedIn()) {
		loginService.sendRedirectLogin(request, response);
	} else if (loginService.isUserAuthorized()) {
		isAuthorized = true;
	}
	
	if(isAuthorized) {
%>

<script type="text/javascript" src="BackEnd/BackEnd.nocache.js"></script>
<script type="text/javascript" src="gxt/flash/swfobject.js"></script>
<link rel="stylesheet" type="text/css" href="gxt/css/gxt-all.css">
<% }	%>
</head>


<!--                                           -->
<!-- The body can have arbitrary html, or      -->
<!-- you can leave the body empty if you want  -->
<!-- to create a completely dynamic UI.        -->
<!--                                           -->
<body>
<%= !isAuthorized ? "You are not authorized to access application. Go away ... Hesh men henaaa :D" : ""  %>
</body>
</html>
