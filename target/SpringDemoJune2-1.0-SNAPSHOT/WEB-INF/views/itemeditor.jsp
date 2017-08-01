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
    <style>
        p{
            color: darkorange;
            font-size: xx-large;
            background-color: lightskyblue;
            text-align: center;
            font: bold 50px Gill Sans, serif;
            padding: 130px;
        }
        body{
            color: darkorange;
            background-color: lightskyblue;
            font: bold 25px Gill Sans, serif;
        }

    </style>
</head>
<body>
<form method="post" action="/editItem">

    <h2>Edit Item</h2>
    <br>
    <br>
    Item Name:
    <input type="text" name="name" value="${itemName}" required>
    <br>
    <br>
    Item Description:
    <input type="text" name="description" value="${itemDescription}" required>
    <br>
    <br>
    Item Quantity:
    <input type="text" name="quantity" value="${itemQuantity}" required>
    <br>
    <br>
    Item Price:
    <input type="text" name="price" value="${itemPrice}" required>
    <br>
    <br>
    <input type="submit" value="Edit Item">

</form>
</body>
</html>
