<%--
  Created by IntelliJ IDEA.
  User: angelo
  Date: 7/31/17
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>GC Coffee</title>
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
            font-size: large;
            font: bold 25px Gill Sans, serif;
            text-align: center;
        }
        table{
            color: darkorange;
            background-color: lightskyblue;
            font-size: large;
            font: bold 25px Gill Sans, serif;
            text-align: center;

        }

    </style>
</head>
<body>
<table border=1 align="center">
    <tr>
        <td>Item</td>
        <td>Description</td>
        <td>Quantity</td>
        <td>Price</td>
    </tr>
</table>
<table border=1 align="center">
    <c:forEach var="myvar" items="${cList}">
        <tr>
            <td> ${myvar.name}</td>
            <td> ${myvar.description}</td>
            <td> ${myvar.quantity}</td>
            <td> ${myvar.price}</td>
            <td>
                <a href = "/updateItem?itemid=${myvar.itemid}">Edit</a>
            </td>
            <td>
                <a href = "delete?itemid=${myvar.itemid}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href = "additem">Add an Item</a>
</body>
</html>
