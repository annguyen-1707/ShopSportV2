<%-- 
    Document   : manageOrder
    Created on : Dec 10, 2024, 11:45:32 PM
    Author     : -Asus-
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleManageOrders.css"/>
    </head>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="menuSeller.jsp"/>
    <body>
        <div class="container">
            <h1>Order Management</h1>
            <h3 style="color: red">${requestScope.error}</h3>
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
                    <c:forEach var="o" items="${requestScope.ordersAll}">
                        <c:set var="tt" value="${tt+1}"/>
                        <tr>
                    <input value="${o.o_id}" name="o_id" hidden=""/>
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
                    <td>
                        ${o.s_name}
                    </td>
                    <td>
                        <c:if test="${o.s_id==1}">
                            <form action="manageOrder" method="post">
                                <input value="${o.o_id}" name="o_id" hidden=""/>
                                <button type="submit" name="action" value="accept" class="accept">Accept</button><br/>
                            </form>
                            <form action="manageOrder" method="post">
                                <input value="${o.o_id}" name="o_id" hidden=""/>
                                <button type="submit" name="action" value="cancelled" class="cancelled">Cancelled</button><br/>
                            </form>
                        </c:if>
                        <c:if test="${o.s_id==2}">
                            <form action="manageOrder" method="post">
                                <input value="${o.o_id}" name="o_id" hidden=""/>
                                <button type="submit" name="action" value="completed" class="completed">Completed</button><br/>
                            </form>
                        </c:if>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>

