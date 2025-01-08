<%-- 
    Document   : checkoutDirect
    Created on : Dec 11, 2024, 8:49:34 AM
    Author     : -Asus-
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleCheckouts.css">

    </head>
    <jsp:include page="menu.jsp"/>
    <body>
        <form action="checkoutDirect" method="post">
            <c:set value="${requestScope.customer}" var="c"/>
            <div class="container">
                <h1>Thanh toán</h1>
                <div class="content">
                    <!-- Thông tin thanh toán -->
                    <div class="payment-info">
                        <h2>Thông tin thanh toán</h2>
                        <label for="name">Họ và tên *</label>
                        <input type="text" id="name" placeholder="Nhập họ và tên" value="${c.name}" required>

                        <label for="phone">Số điện thoại *</label>
                        <input type="text" id="phone" placeholder="Nhập số điện thoại" value="${c.telephone}" required>

                        <label for="city">Địa chỉ *</label>
                        <input type="text" id="address" placeholder="Nhập địa chỉ" value="${c.address}" required>
                    </div>
                    <!-- Tóm tắt đơn hàng -->
                    <div class="order-summary">
                        <h2>Tóm tắt đơn hàng</h2>
                        <c:set var="totalAmount" value="0" scope="page" />
                        <c:forEach items="${requestScope.cart.items}" var="i">
                            <div class="order-item">
                                <img src="image/${i.product.image}" alt="i.product.name">
                                <p>${i.product.name} x${i.quantity}</p>
                                <span><fmt:formatNumber value="${i.price}" pattern="#,##0đ"/></span>
                            </div>
                            <c:set var="itemTotal" value="${i.price * i.quantity}" />
                            <c:set var="totalAmount" value="${totalAmount + itemTotal}" />
                            <input name="p_id" value="${i.product.p_id}" hidden=""/>
                            <input name="quantity" value="${i.quantity}" hidden=""/>
                        </c:forEach>
                        <div class="total">
                            <p>Tổng tiền</p>
                            <span><fmt:formatNumber value="${totalAmount}" pattern="#,##0đ"/></span>
                        </div>
                        <input class="order-btn" value="Đặt hàng" type="submit">
                    </div>
                </div>
            </div>
        </form>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
