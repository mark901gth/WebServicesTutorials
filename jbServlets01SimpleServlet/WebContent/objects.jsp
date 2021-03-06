<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
// implicit request, session, pageContext, application objects
String userName = request.getParameter( "name" );
pageContext.setAttribute( "pageContextUserName", userName );
if ( userName != null )
{
    session.setAttribute( "sessionUserName", userName );
    // application.setAttribute( "applicationUserName", userName );
    pageContext.setAttribute( "pageContextUserName", userName );
    pageContext.setAttribute( "applicationUserName", userName, PageContext.APPLICATION_SCOPE );  // same as commented line above
    pageContext.findAttribute( "name" );
}
%>
<br>
The user name in the request object is: <%=userName %><br>
The user name in the session object is: <%=session.getAttribute( "sessionUserName" ) %><br>
The user name in the application object is: <%=application.getAttribute( "applicationUserName" ) %><br>
The user name in the page context object is: <%=pageContext.getAttribute( "pageContextUserName" ) %><br>
</body>
</html>