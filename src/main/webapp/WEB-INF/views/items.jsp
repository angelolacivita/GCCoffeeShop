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
</head>
<body>
<table border=1>
    <h3>Item____Desc____Qty_Price</h3>
    <c:forEach var="myvar" items="${cList}">
        <tr>
            <td> ${myvar.name}</td>
            <td> ${myvar.description}</td>
            <td> ${myvar.quantity}</td>
            <td> ${myvar.price}</td>
            <td>
                <a href = "delete?itemid=${myvar.itemid}">Delete</a>
            </td>
            <td>
                <a href = "/updateItem?itemid=${myvar.itemid}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href = "additem">Add an Item</a>
</body>
</html>
