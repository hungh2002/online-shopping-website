<form action="${pageContext.request.contextPath}/api/customer?auth=sign-in"
    method="post">
    <h2>Sign In</h2>
    <label>Username: <input type="text" name="username"></label>
    <br>
    <label>Password: <input type="password" name="password"></label>
    <br>
    <label> <input type="checkbox" name="rememberMe" value="true"> Remember
        me</label>
    <br>
    <input type="submit" value="Submit">
</form>