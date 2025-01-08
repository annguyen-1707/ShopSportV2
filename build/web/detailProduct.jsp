<%-- 
    Document   : detailProduct
    Created on : Dec 8, 2024, 10:54:04 PM
    Author     : -Asus-
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Túi Xách Pickleball</title>
        <link rel="stylesheet" href="css/styleDetailPage.css">
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <form action="handleAction">
            <div class="container">
                <c:set value="${requestScope.product}" var="p"/>
                <div class="image-section">
                    <img src="image/${p.image}" alt="${p.name}">
                </div>
                <div class="info-section">
                    <h1>${p.name}</h1>
                    <input name="p_id" type="text" value="${p.p_id}" hidden="">
                    <p class="price-old">Giá cũ: <fmt:formatNumber value="${p.price}" pattern="#,##0đ"/></p>
                    <p class="price">Giá khuyến mãi: <fmt:formatNumber value="${p.price*(100-p.discount)/100}" pattern="#,##0đ"/></p>
                    <p class="description">Mô tả sản phẩm: ${p.describe}</p>
                    <p class="dateRelease">Ngày phát hành:<fmt:formatDate value="${p.dateRelease}" pattern="dd-MM-yyyy"/></p>
                    <div class="quantity">
                        <label for="quantity">Số lượng:</label>
                        <div class="quantity-controls">
                            <button onclick="updateQuantity(-1)" type="button">-</button>
                            <input type="number" id="quantity" name="quantity" value="1" min="1" max="${p.quantity}">
                            <button onclick="updateQuantity(1)" type="button">+</button>
                        </div>
                    </div>
                    <p class="tag">Tag:           #${p.category.name},#${p.type.name}</p>
                    <c:set var="quantity" value=""/>
                    <div class="actions">
                        <button type="submit" name="action" value="addToCart" id="addToCart">Add to Cart</button>
                        <button type="submit" name="action" value="buyNow" id="buyNow">Buy Now</button>
                    </div>
                </div>
            </div>
        </form>

        <div class="container2"> 
            <h3>Các sản phẩm liên quan</h3> <!-- Add this line to display the title above the products list -->
            <ul> 
                <c:forEach items="${requestScope.productsRelate}" var="p">
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
    <script>
        function updateQuantity(amount) {
            const quantityInput = document.getElementById('quantity');
            let currentValue = parseInt(quantityInput.value);
            if (isNaN(currentValue))
                currentValue = 1;
            currentValue = Math.max(1, currentValue + amount);
            quantityInput.value = currentValue;
        }
    </script>
    <jsp:include page="footer.jsp"/>
</body>
</html>