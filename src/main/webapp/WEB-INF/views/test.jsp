<jsp:useBean id="greeting" scope="request" type="java.lang.String"/>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
</head>

<body>
<h1>Hello Spring MVC Test</h1>
<h1>Hello ${greeting}</h1>
<h2>Let study MVC for beginner</h2>
<%
    out.println("Your IP address is " + request.getRequestURI());
%>

</body>

</html>