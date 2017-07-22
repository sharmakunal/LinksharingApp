
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Link Sharing</title>
</head>
<body>
<h3>Update password</h3>
<form action="/password_update" method="post">
    <label>New Password : </label>
    <input type="password" name="pswd"/>
    <label>Confirm Password : </label>
    <input type="password" name="cpswd"/>
    <input type="hidden" name="email" value="${email}"/>
    <input type="submit"/>
    ${msg}
</form>
</body>
</html>