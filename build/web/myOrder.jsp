<%-- 
    Document   : myOrder
    Created on : Dec 11, 2024, 2:18:47 AM
    Author     : -Asus-
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleMyOrders.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="menuInfo.jsp"/>
    <center>
        <h1>Quản lí đơn</h1><hr/>
        <table>
            <thead>
                <tr>
                    <th>TT</th>
                    <th>Customer</th>
                    <th>Total Price</th>
                    <th>Order Date</th>
                    <th>Detail</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="tt" value="0"/>
                <c:forEach var="o" items="${requestScope.myOrders}">
                <input value="${o.o_id}" name="o_id" hidden=""/>
                <c:set var="tt" value="${tt+1}"/>
                <tr>
                    <td>${tt}</td>
                    <td>${o.customer.name}</td>
                    <td><fmt:formatNumber value="${o.total_price}" pattern="#,##0đ"/></td>
                    <td>${o.order_date}</td>
                    <td>
                        <ul>
                            <c:forEach var="od" items="${requestScope.orderDetailsAll}">
                                <c:if test="${od.o_id == o.o_id}">
                                    <li>${od.p_name} x${od.quantity}</li>
                                    </c:if>
                                </c:forEach>
                        </ul>
                    </td>
                    <td> ${o.s_name}</td>
                    <td>
                        <c:if test="${o.s_id==1}">
                            <form action="myOrder" method="post">
                                <input value="${o.o_id}" name="o_id" hidden=""/>
                                <button class="cancel-order"> Hủy đơn</button>
                            </form>  
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </center>
    <jsp:include page="footer.jsp"/>
</body>
</html>

