<form action="${pageContext.request.contextPath}/api/customer?auth=sign-up"
    method="post">
    <h2>Sign Up</h2>
    <label>Username: <input type="text" name="username"></label>
    <label>Password: <input type="password" name="password"></label>

    <input type="submit" value="Submit">
</form>