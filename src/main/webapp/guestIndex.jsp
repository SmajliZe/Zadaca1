<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Class.Products" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Index page</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Acme&family=Oswald&family=Roboto:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mainPages.css">
</head>
<body>
    <div class="main-title d-flex justify-content-between align-items-center">

        <h1>PharmaLab</h1>
        <a href="login.jsp" class="btn btn-success">Login</a>
    </div>
    <div id="starting-page">

        <div id="starting-page-images">
            <div class="slideshow-container">
                <div class="slides fade">
                    <img class="full-scale-img" src="images/secer.png">
                    <div class="text">Biljne kapi za Šećer</div>
                </div>

                <div class="slides fade">
                    <img class="full-scale-img" src="images/zeludac2.png">
                    <div class="text">Biljne kapi za Želudac</div>
                </div>

                <div class="slides fade">
                    <img class="full-scale-img" src="images/masnoca.png">
                    <div class="text">Biljne kapi za Masnoću</div>
                </div>
            </div>
        </div>
    </div>
    <div id="about">
        <h2>O nama</h2>
        <p id="about-text">
            "Pharmalab je kompanija koja se bavi proizvodnjom prirodnih preparata za prevenciju i liječenje različitih stanja i oboljenja.
            Iza nas su godine predanog rada i usavršavanja na polju farmacije i fitoterapije kao prvog izbora u prevenciji i liječenju bolesti. Prednosti liječenja prirodnim preparatima su mnogobrojne, a odlikuje ih minimalna toksičnost i sigurna upotreba. Najveći benefit je svakako taj što prirodni preparati aktiviraju sposobnost tijela da se samo bori protiv bolesti i samim tim su zdraviji za upotrebu.

            Na temelju ovih saznanja, trudimo se da pacijentima ponudimo rješenje koje je upotpunosti prirodno, sigurno i učinkovito, te uz stručno savjetovanje upotpunimo našu misiju.""
        </p>
        <div class="d-flex justify-content-center align-items-center">
            <img src="images/logo1.png" alt="Small logo" class="small-logo">
        </div>
    </div>
    <div id="products-page">
        <h2>Katalog</h2>

        <div class="all-products">
            <%
                List<Products> productsList=(List<Products>) request.getAttribute("productsList");
                for (Products products: productsList){
            %>
            <div class="product-container">
                <div class="product-image-container">
                    <img src="images/8.png" alt="Test">
                </div>
                <h3 class="product-name"><%=products.getName() %></h3>
                <p class="product-desc">"<%=products.getDescription() %>"</p>
                <p class="product-price">Price:<br> <%=products.getPrice() %>$</p>
            </div>
            <%} %>
        </div>
    </div>


    <div id="footer" class="d-flex justify-content-around flex-row">
        <div id="footer-item-1" class="font-weight-bold">
                <span>Potok 9<br>
                72000 Zenica<br>
                Bosna i Hercegovina<br></span>
        </div>
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
