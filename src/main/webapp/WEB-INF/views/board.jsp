
<html>
<head>
    <title>View Boards</title>
<%--    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">--%>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>Name</th>
        <th>Author</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="boards" scope="request" type="java.util.List"/>
    <c:forEach items="${boards}" var="board">
        <tr>
            <td>${board.id}</td>
            <td>${board.createBy}</td>
            <td>${board.authorName}</td>
            <td>${board.authorName}</td>
            <td>${board.createAt}</td>
            <td>${board.title}</td>
            <td>${board.content}</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>