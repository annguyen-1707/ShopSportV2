<%-- 
    Document   : home.jsp
    Created on : Dec 7, 2024, 10:27:24 AM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleHomes.css">
    </head>
    <body>
        <jsp:include page="menu.jsp"/>

        <div class="ad-container">
            <div class="ad-text">
                <h1>Pickleball</h1>
                <p>Sự kết hợp hoàn hảo giữa quần vợt, bóng bàn và cầu lông, là môn thể thao bùng nổ với nhịp độ nhanh, dễ tiếp cận và mang lại niềm vui bất tận cho mọi lứa tuổi, từ sân chơi nghiệp dư đến các giải đấu chuyên nghiệp.</p>
                <a href="search?type=3" class="buy-button">MUA NGAY</a>
            </div>
            <div class="ad-image">
                <img src="image/pickelball.png" alt="Pickleball Equipment">
            </div>
        </div>
        <!----------------------------------------------------------------------------------------------------->
        <div class="container">
            <div class="popular-sports">
                <h2>Thể thao thịnh hành</h2>
                <div class="sports-icons">
                    <div class="sports-icon">
                        <a href="search?type=4">
                            <div class="image-container">
                                <img src="image/basketball.webp" alt="Bóng rổ">
                                <p class="image-text">Bóng rổ</p>
                            </div>
                        </a>
                    </div>
                    <div class="sports-icon">
                        <a href="search?type=6">                            <div class="image-container">
                                <img src="image/table-tennis.webp" alt="Bóng bàn">
                                <p class="image-text">Bóng bàn</p>
                            </div>
                        </a>                  
                    </div>
                    <div class="sports-icon">
                        <a href="search?type=1">                            <div class="image-container">
                                <img src="image/football.webp" alt="Bóng đá">
                                <p class="image-text">Bóng đá</p>
                            </div>
                        </a>
                    </div>
                    <div class="sports-icon">
                        <a href="search?type=2">                            <div class="image-container">
                                <img src="image/badminton.webp" alt="Cầu lông">
                                <p class="image-text">Cầu lông</p>
                            </div>
                        </a>
                    </div>
                    <div class="sports-icon">
                        <a href="search?type=3">                            <div class="image-container">
                                <img src="image/pickleball.webp" alt="Pickleball">
                                <p class="image-text">Pickleball</p>
                            </div>
                        </a>
                    </div>
                    <div class="sports-icon">
                        <a href="search?type=5">                            <div class="image-container">
                                <img src="image/running.webp" alt="Chạy bộ">
                                <p class="image-text">Chạy bộ</p>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="view-all">
                    <a href="search">Xem Tất Cả</a>
                </div>
            </div>
        </div>
         <!----------------------------------------------------------------------------------------------------->
        <div class="container2"> 
            <h3>Các sản bán chạy</h3> <!-- Add this line to display the title above the products list -->
            <ul> 
                <c:forEach items="${requestScope.productsTopBuy}" var="p">
                    <li> 
                        <a href="detailProduct?p_id=${p.p_id}"> 
                            <div class="image-container">
                                <img src="image/${p.image}" alt="${p.name}"/> 
                                <!-- Thêm phần giảm giá ở góc ảnh -->
                                <span class="discount">${p.discount}%</span> 
                            </div>
                            <p class="category-name">${p.category.name}</p>
                            <p class="product-name">${p.name}</p> 
                            <p class="old-price">Giá gốc:<fmt:formatNumber value="${(p.price)}" pattern="#,##0đ"/></p> 
                            <p class="price">Giá khuyến mãi:<fmt:formatNumber value="${(p.price)*(100-p.discount)/100}" pattern="#,##0đ"/></p> 
                        </a> 
                        <a href="addCart?id=${p.p_id}&num=1" class="add-to-cart">Thêm giỏ hàng</a> 
                    </li> 
                </c:forEach> 
            </ul> 
        </div>
        <!----------------------------------------------------------------------------------------------------->
        <div class="container2"> 
            <h3>Các sản phẩm mới</h3> <!-- Add this line to display the title above the products list -->
            <ul> 
                <c:forEach items="${requestScope.productsNew}" var="p">
                    <li> 
                        <a href="detailProduct?p_id=${p.p_id}"> 
                            <div class="image-container">
                                <img src="image/${p.image}" alt="${p.name}"/> 
                                <!-- Thêm phần giảm giá ở góc ảnh -->
                                <span class="discount">${p.discount}%</span> 
                            </div>
                            <p class="category-name">${p.category.name}</p>
                            <p class="product-name">${p.name}</p> 
                            <p class="old-price">Giá gốc:<fmt:formatNumber value="${(p.price)}" pattern="#,##0đ"/></p> 
                            <p class="price">Giá khuyến mãi:<fmt:formatNumber value="${(p.price)*(100-p.discount)/100}" pattern="#,##0đ"/></p> 
                        </a> 
                        <a href="addCart?id=${p.p_id}&num=1" class="add-to-cart">Thêm giỏ hàng</a> 
                    </li> 
                </c:forEach> 
            </ul> 
        </div>
        <!----------------------------------------------------------------------------------------------------->
        <div class="container2"> 
            <h3>Các sản phẩm sale mạnh tay</h3> <!-- Add this line to display the title above the products list -->
            <ul> 
                <c:forEach items="${requestScope.productsSale}" var="p">
                    <li> 
                        <a href="detailProduct?p_id=${p.p_id}"> 
                            <div class="image-container">
                                <img src="image/${p.image}" alt="${p.name}"/> 
                                <!-- Thêm phần giảm giá ở góc ảnh -->
                                <span class="discount">${p.discount}%</span> 
                            </div>
                            <p class="category-name">${p.category.name}</p>
                            <p class="product-name">${p.name}</p> 
                            <p class="old-price">Giá gốc:<fmt:formatNumber value="${(p.price)}" pattern="#,##0đ"/></p> 
                            <p class="price">Giá khuyến mãi:<fmt:formatNumber value="${(p.price)*(100-p.discount)/100}" pattern="#,##0đ"/></p> 
                        </a> 
                        <a href="addCart?id=${p.p_id}&num=1" class="add-to-cart">Thêm giỏ hàng</a> 
                    </li> 
                </c:forEach> 
            </ul> 
        </div>

    </body>
    <jsp:include page="footer.jsp"/>

</html>