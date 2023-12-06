
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div id="registration-container" class="container bg-light">
        <h1 class="text-center font-weight-bold">REGISTRATION</h1>
        <div class="registration-form">
            <form action="register" method="post">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm password:</label>
                    <input type="password" name="confirmPassword" id="confirmPassword" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="email" name="address" id="address" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Register</button>
                </div>
            </form>
        </div>
        <div id="register-more-button" class="d-flex flex-column">
            <a href="login.jsp" class="btn btn-info">Return to Login</a>
        </div>
    </div>
</body>
</html>
