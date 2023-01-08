<%--
  Created by IntelliJ IDEA.
  User: 15107
  Date: 1/27/2021
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href='support'>CStech Support Form</a>
  <br>
  <form action="support" method="post">
    Name: <input name="user_name"> <br>
    Email address: <input name="user_email_address"> <br>
    Problem: <input name="problem"> <br>
    <label for="problem_description">Problem description:</label>
    <textarea id="problem_description" name="problem_description" rows="3" cols="50">

    </textarea> <br>
    <input type="submit" value="help">
  </form>
  </body>
</html>
