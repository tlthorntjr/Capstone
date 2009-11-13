<%@ page import="com.twowire.model.SystemModel" %>

<jsp:useBean id="mybean" scope="page" class="com.twowire.model.User" />
<jsp:setProperty name="mybean" property="*" />

<html>
<head><title>Hello World!</title></head>

<h1>Login</h1>

<form method="POST" action="Login.do">
	Username:
	<input type="text" name="username" size="25">
	<br/>
	Password:
	<input type="text" name="password" size="25">
	<br/>
	<input type="submit" name="submit" value="Login">
	<input type="submit" name="cancel" value="Cancel">
</form>

</html>