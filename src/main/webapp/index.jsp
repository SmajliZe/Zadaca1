<% ProductUserOrderSet productUserOrderSet=(ProductUserOrderSet) session.getAttribute("data"); %>
<%@ page import="com.Class.Products" %>
<%@ page import="com.Class.Order" %>
<%@ page import="com.Class.ProductUserOrderSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Acme&family=Oswald&family=Roboto:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mainPages.css">
</head>
<body>
    <div class="main-title d-flex justify-content-between align-items-center">
        <p>Pozdrav, <%=productUserOrderSet.getUser().getUsername() %></p>
        <h1>Biljne kapi PharmaLab</h1>
        <a href="logout" class="btn btn-danger">Logout</a>
    </div>

    <div id="admin-page-redirect">
        <% if (productUserOrderSet.getUser().getRole()==1){%>
        <div id="admin-button-container">
            <a href="adminpage" class="btn btn-info">Admin Dashboard</a>
        </div>

        <%}%>
    </div>

    <div id="starting-page">
        <div id="starting-page-images">
            <div class="slideshow-container">
                <div class="slides fade">
                    <img class="full-scale-img" src="images/secer.png">
                    <div class="text">Biljne kapi za Šećer</div>
                </div>
                <div class="slides fade">
                    <img class="full-scale-img" src="images/smirenje.png">
                    <div class="text">Biljne kapi za Smirenje</div>
                </div>
                <div class="slides fade">
                    <img class="full-scale-img" src="images/masnoca.png">
                    <div class="text">Biljne kapi za Masnoću</div>
                </div>
                <div class="slides fade">
                    <img class="full-scale-img" src="images/pluca2.png">
                    <div class="text">Biljne kapi za Pluća</div>
                </div>
                <div class="slides fade">
                    <img class="full-scale-img" src="images/zeludac2.png">
                    <div class="text">Biljne kapi za Želudac </div>
                </div>
            </div>
        </div>
    </div>
    <div id="about">
        <h2>O nama</h2>
        <p id="about-text">
            "Pharmalab je kompanija koja se bavi proizvodnjom prirodnih preparata za prevenciju i liječenje različitih stanja i oboljenja.
            Iza nas su godine predanog rada i usavršavanja na polju farmacije i fitoterapije kao prvog izbora u prevenciji i liječenju bolesti. Prednosti liječenja prirodnim preparatima su mnogobrojne, a odlikuje ih minimalna toksičnost i sigurna upotreba. Najveći benefit je svakako taj što prirodni preparati aktiviraju sposobnost tijela da se samo bori protiv bolesti i samim tim su zdraviji za upotrebu.

            Na temelju ovih saznanja, trudimo se da pacijentima ponudimo rješenje koje je upotpunosti prirodno, sigurno i učinkovito, te uz stručno savjetovanje upotpunimo našu misiju."
        </p>
        <div class="d-flex justify-content-center align-items-center">
            <img src="images/logo1.png" alt="Small logo" class="small-logo">
        </div>
    </div>
    <div id="products-page">
        <h2>Katalog</h2>
        <div class="all-products">
            <%
                for (Products products: productUserOrderSet.getProductsList()){
            %>
            <div class="product-container-w-button">
                <div class="product-image-container">
                    <img src="images/8.png" alt="Kapi">
                </div>
                <h3 class="product-name"><%=products.getName() %></h3>
                <p class="product-desc">"<%=products.getDescription() %>"</p>
                <p class="product-price-w-button">Price:<br> <%=products.getPrice() %>$</p>
                <div class="product-button">
                    <button class="product-button add-order-button" product-id="<%=products.getId() %>"
                            product-name="<%=products.getName() %>" product-price="<%=products.getPrice() %>">Order</button>
                </div>
            </div>

            <%} %>
        </div>
    </div>

    <div id="create-order-page">
        <h2>Naruči</h2>
        <form action="ordering" method="post" id="create-order-form">
            <div id="orderedProducts"></div>
            <label for="address">Adresa: </label>
            <input type="text" name="address" id="address" required><br>
            <label for="total">Ukupno: </label>
            <input type="number" name="total" id="total" value=0 readonly><br>
            <input name="products" id="products" hidden="hidden">
            <button type="submit" class="btn btn-success">Naruči</button>
        </form>
    </div>

    <div id="orders-listing-page">
        <h2>Narudžbe</h2>
        <div class="all-orders">
            <%
                for (Order orders: productUserOrderSet.getOrdersList()){
            %>
            <% if (orders.getUsername().equals(productUserOrderSet.getUser().getUsername())){ %>
            <div class="order-container">
                <div class="order-image-container">
                    <img src="images/ordersample.png" alt="Order">
                </div>
                <p class="user-order-addres">Adresa: <%=orders.getAddress() %></p>
                <p class="user-order-total">Ukupno: <%=orders.getTotal() %>$</p>
                <p class="user-order-products">Detalji narudžbe <%=orders.getProducts() %></p>
                <p class="user-order-date">Datum: <%=orders.getDate() %></p>
            </div>
            <%} %>
            <%} %>
        </div>
    </div>

    <div id="footer" class="d-flex justify-content-around flex-row">

        <div id="footer-item-2" class="text-center font-weight-bold">
                <span>www.pharmalab.ba</span>
        </div>
        <div id="footer-item-3" class="d-flex justify-content-around align-items-center">
            <a href="https://www.instagram.com/">
                <img src="icons/instagram.svg" alt="Instagram" class="social-img">
            </a>
            <a href="https://www.facebook.com">
                <img src="icons/facebook.svg" alt="Facebook" class="social-img">
            </a>
            <a href="https://www.linkedin.com">
                <img src="icons/linkedin.svg" alt="LinkedIn" class="social-img">
            </a>
        </div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", ()=>{
            document.querySelectorAll(".add-order-button").forEach(button=>{
                button.addEventListener("click", ()=>{
                    let id=button.getAttribute("product-id");
                    let name=button.getAttribute("product-name");
                    let price=button.getAttribute("product-price");
                    let total=document.getElementById("total");
                    let products=document.getElementById("products");
                    let orderedProducts=document.getElementById("orderedProducts");
                    orderedProducts.classList.add("ordered-products-table");
                    let totalValue=parseFloat(total.value);
                    total.value=totalValue+parseFloat(price);
                    products.value+=" "+name;
                    products.value=products.value.trim();
                    orderedProducts.innerHTML+="<input type='hidden' name='orderedProducts' value='" + name + "'>" + name + "<br/>";
                });
            });
        });

        // SLIDESHOW
        let slideIndex = 0;
        showSlides();

        function showSlides() {
            let i;
            let slides = document.getElementsByClassName("slides");
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slideIndex++;
            if (slideIndex > slides.length) {slideIndex = 1}
            slides[slideIndex-1].style.display = "block";
            setTimeout(showSlides, 4000);
        }
    </script>
</body>
</html>
