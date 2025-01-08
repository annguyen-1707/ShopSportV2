<%-- 
    Document   : cart
    Created on : Dec 8, 2024, 10:39:52 PM
    Author     : -Asus-
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <<link rel="stylesheet" href="css/styleMyCarts.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Shopping Cart Online</h1>
        <table>
            <tr>
                <th>STT</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total Money</th>
                <th>Action</th>
            </tr>
            <c:set var="o" value="${requestScope.cart}"/>
            <c:set var="tt" value="0"/>
            <c:forEach items="${o.items}" var="i">
                <c:set var="tt" value="${tt+1}"/>
                <tr>
                    <td>${tt}</td>
                    <td>${i.product.name}</td>
                    <td>
                        <a href="process?num=-1&id=${i.product.p_id}" class="quantity-button">-</a>
                        ${i.quantity}
                        <a href="process?num=1&id=${i.product.p_id}" class="quantity-button">+</a>
                    </td>
                    <td><fmt:formatNumber value="${i.price}" pattern="#,##0đ"/></td>
                    <td><fmt:formatNumber value="${(i.price * i.quantity)}" pattern="#,##0đ"/></td>
                    <td>
                        <form action="process" method="post">
                            <input type="hidden" name="id" value="${i.product.p_id}"/>
                            <input type="submit" value="Return Item"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3>Tổng tiền:<fmt:formatNumber value="${o.totalMoney}" pattern="#,##0đ"/> </h3>
        <hr/>
        <form action="checkoutCart" method="get">
            <input type="submit" value="Thanh toán">
        </form>
        <hr/>
        <a href="home" id="comeHome">Tiếp tục mua sắm?</a>
    </body>
    <jsp:include page="footer.jsp"/>

</html>

