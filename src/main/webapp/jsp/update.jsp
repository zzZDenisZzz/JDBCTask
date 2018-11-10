<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update product</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">
    <%--@elvariable id="product" type="com.shop_kiev.model.Product"--%>
    <input type="hidden" value="${product.id}" name="id"/>
    <label>Name</label><br>
    <label><input name="name" value="${product.name}"/></label><br><br>
    <label>Price</label><br>
    <label><input name="price" value="${product.price}" type="number" min="1"/></label><br><br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>