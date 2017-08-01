<%--
  Created by IntelliJ IDEA.
  User: angelo
  Date: 7/21/17
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GC Coffee</title>
    <style>
        h1 {
            font: bold 50px Gill Sans, serif;
            color: chartreuse;
            background-color: firebrick;
        }

        body {
            font: bold 25px Gill Sans, serif;
            color: chartreuse;
            background-color: firebrick;
        }

    </style>
    <h1>Please fill in the form to register!</h1>
</head>
<body>
<form method="post" action="/registerUser">

    <form action="/action_page_post.php" method="post">

        First Name:
        <input type="text" name="firstName" value="First Name" required>
        <br>
        Last Name:
        <input type="text" name="lastName" value="Last Name" required>
        <br>
        Email:
        <input type="text" name="email" value="Email@gmail.com" required>
        <br>
        Phone Number:
        <input type="text" name="phoneNumber" value="123-456-7890" required>
        <br>
        Password:
        <input type="password" name="password" value="password" required>
        <br>
        <br>
        Gender:
        <br>
            <input type="radio" name="gender" value="male"> Male<br>
            <input type="radio" name="gender" value="female"> Female<br>
            <input type="radio" name="gender" value="other" checked> Other
            <br>
            <br>
        Would you like to be on our mailing list?
        <br>
        <select name="emailList">
            <option value="yes">Yes</option>
            <option value="no">No</option>
            <option value="maybe">Maybe</option>
        </select>
        <br>
        <br>
        What are your coffee preferences?
        <br>
        <input type="checkbox" name="preferences" value="coffee" checked> Coffee<br>
        <input type="checkbox" name="preferences" value="latte">Latte<br>
        <input type="checkbox" name="preferences" value="espresso">Esspresso<br>
        <input type="checkbox" name="preferences" value="cappuccino">Cappuccino<br>
        <input type="checkbox" name="preferences" value="macchiatto">Macchiatto<br>
        <br>
        <input type="submit" value="Register">
    </form>
</form>
</body>
</html>
