<%--
  Created by IntelliJ IDEA.
  User: angelo
  Date: 8/1/17
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/editItem">

    <h2>Edit Item</h2>
    <br>
    <br>
    Item Name:
    <input type="text" name="name" value="" required>
    <br>
    <br>
    Item Description:
    <input type="text" name="description" value="" required>
    <br>
    <br>
    Item Quantity:
    <input type="text" name="quantity" value="" required>
    <br>
    <br>
    Item Price:
    <input type="text" name="price" value="" required>
    <br>
    <br>
    <input type="submit" value="Edit Item">

</form>
</body>
</html>
