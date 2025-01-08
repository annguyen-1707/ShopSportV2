<%-- 
    Document   : addProduct2
    Created on : Dec 8, 2024, 4:16:17 PM
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
        <link rel="stylesheet" href="css/styleAddProduct.css">

    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <jsp:include page="menuSeller.jsp"/>
        <div class="container">
            <h1 class="form-title">Add New Product</h1>
            <form action="addProduct" method="POST" enctype="multipart/form-data" class="product-form">
                <div class="form-group">
                    <label for="name">Product Name:</label>
                    <input type="text" id="name" name="name" required>
                </div>

                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" id="price" name="price" step="0.01" required min="0">
                </div>

                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="number" id="quantity" name="quantity" required min="0">
                </div>

                <div class="form-group">
                    <label for="category">Các loại sản phẩm:</label>
                    <select name="category" id="category">
                        <c:forEach items="${sessionScope.categories}" var="c">
                            <option value="${c.c_id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="type">Các môn thể thao:</label>
                    <select name="type" id="type">
                        <c:forEach items="${sessionScope.types}" var="t">
                            <option value="${t.t_id}">${t.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="describe">Description:</label>
                    <textarea id="describe" name="describe" rows="4" required></textarea>
                </div>

                <div class="form-group">
                    <label for="image">Product Image:</label>
                    <input type="file" id="image" name="image" accept="image/*" required>
                </div>

                <div class="form-group">
                    <label for="dateRelease">Release Date:</label>
                    <input type="date" id="dateRelease" name="dateRelease" required>
                </div>

                <div class="form-group">
                    <label for="discount" min="0" >Discount (%):</label>
                    <input type="number" id="discount" name="discount" step="0.01" min="0">
                </div>

                <button type="submit" class="submit-btn">Add Product</button>
            </form>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>
