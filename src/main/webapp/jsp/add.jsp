<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add product</title>
</head>
<body>
<h2>New product</h2>
<form method="post">
    <label>Name</label><br>
    <label><input name="name" size="30"></label><br><br>
    <label>Price</label><br>
    <label><input name="price" type="number" min="1"></label><br><br>
    <input type="submit" value="Save">
</form>
</body>
</html>