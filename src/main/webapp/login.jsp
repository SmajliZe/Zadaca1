<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div id="login-container" class="container bg-light">
        <h1 class="text-center font-weight-bold">LOGIN</h1>
        <div class="login-form">
            <form action="login" method="post" class="form-group">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Login</button>
                </div>
            </form>
        </div>
        <div id="login-more-buttons" class="container d-flex flex-column">
            <a href="registration.jsp" class="btn btn-info">Create an account</a>
            <a href="products" class="btn btn-dark">Enter as Guest</a>
        </div>
    </div>
</body>
</html>
