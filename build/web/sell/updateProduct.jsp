<%-- 
    Document   : updateProduct
    Created on : Dec 8, 2024, 1:34:02 PM
    Author     : -Asus-
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleUpdateProduct.css">

    </head>
    <body>
        <jsp:include page="../menu.jsp"/>
        <jsp:include page="menuSeller.jsp"/>
        <div class="container">
            <c:set value="${requestScope.product}" var="p" />
            <h1 class="form-title">Update Product: ${p.name}</h1>
            <form action="updateProduct?p_id=${p.p_id}" method="POST" enctype="multipart/form-data" class="product-form">
                <div class="form-group">
                    <label for="name">Product Name:</label>
                    <input type="text" id="name" name="name" value="${p.name}" required>
                </div>

                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" id="price" name="price" step="0.01" value="${p.price}" required min="0">
                </div>

                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="number" id="quantity" name="quantity" value="${p.quantity}" required min="0">
                </div>

                <div class="form-group">
                    <label for="category">Category:</label>
                    <select name="category" id="category">
                        <c:forEach items="${sessionScope.categories}" var="c">
                            <option value="${c.c_id}" ${c.c_id == p.category.c_id ? 'selected="selected"' : ''}>
                                ${c.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="type">Sport Type:</label>
                    <select name="type" id="type">
                        <c:forEach items="${sessionScope.types}" var="t">
                            <option value="${t.t_id}" ${t.t_id == p.type.t_id ? 'selected="selected"' : ''}>
                                ${t.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="describe">Description:</label>
                    <textarea id="describe" name="describe" rows="4" required>${p.describe}</textarea>
                </div>

                <div class="form-group">
                    <label for="image">Product Image:</label>
                    <input type="file" id="image" name="image" accept="image/*" required="">
                </div>

                <div class="form-group">
                    <label for="dateRelease">Release Date:</label>
                    <input type="date" id="dateRelease" name="dateRelease" value="${p.dateRelease}" required>
                </div>

                <div class="form-group">
                    <label for="discount">Discount (%):</label>
                    <input type="number" id="discount" name="discount" step="0.01" value="${p.discount}" required min="0">
                </div>

                <button type="submit" class="submit-btn">Update Product</button>
            </form>
        </div>
        <jsp:include page="../footer.jsp" />
    </body>

</html>
