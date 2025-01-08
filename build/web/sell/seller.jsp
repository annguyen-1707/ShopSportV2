<%-- 
    Document   : seller.jsp
    Created on : Dec 7, 2024, 10:28:53 AM
    Author     : -Asus-
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleSellers.css">
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete product with id = " + id)) {
                    window.location = "deleteProduct?p_id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <jsp:include page="menuSeller.jsp"/>

        <div class="container">
            <c:set value="${sessionScope.productsAll}" var="p"/>
            <h1>List of Products </h1>
            <h3><a href="addProduct" class="add-new-button">Add new</a></h3>
     
            <c:if test="${p != null}">
                <table class="product-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Category</th>
                            <th>Type</th>
                            <th>Date Release</th>
                            <th>Discount</th>
                            <th>Image</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="tt" value="0"/>
                        <c:forEach items="${p}" var="product">
                            <c:set var="tt" value="${tt+1}"/>
                            <c:set value="${product.p_id}" var="id"/>
                            <tr>
                                <td>${tt}</td>
                                <td>${product.name}</td>
                                <td>${product.describe}</td>
                                <td><fmt:formatNumber value="${product.price}" pattern="#,##0đ"/></td>
                                <td>${product.quantity}</td>
                                <td>${product.category.name}</td>
                                <td>${product.type.name}</td>
                                <td>${product.dateRelease}</td>
                                <td>${product.discount}%</td>
                                <td><img src="image/${product.image}" alt="${product.name}" class="product-image" /></td>
                                <td>
                                    <a href="updateProduct?p_id=${id}" class="action-link">Update</a>
                                    <br/><br/>
                                    <a href="#" onclick="doDelete('${id}')" class="action-link delete-link">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
