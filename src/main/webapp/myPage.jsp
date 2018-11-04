<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>MyServlet</title>
</head>
<body>
<h1>List departments</h1>
<table>
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
