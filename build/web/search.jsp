<%-- 
    Document   : search
    Created on : Dec 7, 2024, 7:09:24 PM
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
        <title>Kết quả tìm kiếm</title> 
        <link rel="stylesheet" href="css/styleSearch.css">
    </head> 
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="form-container"> <form action="search">
                <div class="category-type-container"> 
                    <div>
                        <label for="category">Các loại sản phẩm:</label> 
                        <select name="category" id="category"> 
                            <option value="0">Tất cả</option> 
                            <c:forEach items="${sessionScope.categories}" var="c">
                                <option value="${c.c_id}">${c.name}</option>
                            </c:forEach> 
                        </select> 
                    </div> 
                    <div> 
                        <label for="type">Các môn thể thao:</label>
                        <select name="type" id="type"> 
                            <option value="0">Tất cả</option>
                            <c:forEach items="${sessionScope.types}" var="t"> 
                                <option value="${t.t_id}">${t.name}
                                </option>
                            </c:forEach> 
                        </select> 
                    </div> 
                </div>
                <div class="price-date-container"> <div> <label for="price1">Từ giá:</label> 
                        <input type="number" id="price1" name="price1"> </div>
                    <div> <label for="price2">Đến giá:</label>
                        <input type="number" id="price2" name="price2"> </div>
                    <div> <label for="from">Từ ngày:</label> <input type="date" id="from" name="from"> </div> <div> <label for="to">Đến ngày:</label> 
                        <input type="date" id="to" name="to"> </div>
                </div><br/>
                <div class="search-container"> 
                    <input type="text" id="search" name="key" placeholder="Search..." value="${sessionScope.key}">
                </div><br/>
                <input type="submit" value="SEARCH"> 
            </form> 
        </div>           
        <div class="container"> 
            <c:if test="${not empty sessionScope.key}">
                <h1>Kết quả tìm kiếm cho:"${sessionScope.key}"</h1> 
            </c:if> 
            <c:set var="p" value="${requestScope.products}"/> 
            <c:if test="${p.size()==0}"> 
                <h3>Chúng tôi không tìm thấy sản phẩm nào phù hợp</h3>
            </c:if> 
            <c:if test="${p.size()!=0}">
                <h3>Chúng tôi đã tìm thấy một số sản phẩm cho bạn.</h3> 
                <ul> 
                    <c:forEach items="${p}" var="p">
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
            </c:if> 
        </div> 
        <jsp:include page="footer.jsp"/>
    </body> 
</html>