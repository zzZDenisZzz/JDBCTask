<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>MyServlet</title>
</head>
<body>
<h1>List departments</h1>
<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Add</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%--@elvariable id="products" type="java.util.List"--%>
    <c:forEach items="${products}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
