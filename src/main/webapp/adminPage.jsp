<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Class.Order" %>
<%@ page import="com.Class.ProductUserOrderSet" %>
<% ProductUserOrderSet productUserOrderSet=(ProductUserOrderSet) session.getAttribute("data"); %>
<%@ page import="java.util.List" %>
<%

    if (session.getAttribute("data")==null){
        response.sendRedirect("login.jsp");
    }
    if (productUserOrderSet.getUser().getRole()!=1){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Page</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Acme&family=Oswald&family=Roboto:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mainPages.css">
</head>
<body>
    <div class="admin-page-title d-flex flex-column justify-content-center align-items-center">
        <h1>Admin Page</h1>
        <div class="admin-return-button">
            <a href="index.jsp" class="btn btn-info">Return to menu</a>
        </div>
    </div>

    <div id="admin-orders-page">
        <h2>Orders List</h2>
        <p>All orders made by users</p>
        <div class="all-orders">
            <%
                List<Order> ordersList=(List<Order>) request.getAttribute("ordersList");
                for (Order orders: ordersList){
            %>
            <div class="order-container-admin">
                <div class="order-image-container">
                    <img src="images/ordersample.png" alt="Order">
                </div>
                <h3 class="order-username">Username: <%=orders.getUsername() %></h3>
                <p class="order-address">Address: <%=orders.getAddress() %></p>
                <p class="order-total">Total: <%=orders.getTotal() %>$</p>
                <p class="order-all-products">Order details: <%=orders.getProducts() %></p>
                <p class="order-date">Date: <%=orders.getDate() %></p>
            </div>
            <%} %>
        </div>
    </div>

    <div id="add-new-product-page">
        <h2>Add new product</h2>
        <form action="adminpage" method="post" id="new-product-form">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" name="name" id="name" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" name="description" id="description" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" name="price" id="price" required>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success">Add Product</button>
            </div>
        </form>
    </div>
</body>
</html>
