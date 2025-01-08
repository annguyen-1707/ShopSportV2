<%-- 
    Document   : menu
    Created on : Dec 7, 2024, 10:24:59 AM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleMenus.css">
    </head> 

    <body> 
        <div class="menu">
            <div class="left">
                <a href="home"><img src="image/home.avif" alt="Home"></a>
                <a href="seller">Người bán hàng</a>
                <a href="search">Tìm sản phẩm</a>
            </div>
            <div class="center">
                <div class="search-bar">
                    <form action="search" style="width: 100%; display: flex;">
                        <input type="text" id="search" name="key" placeholder="Search..." value="${sessionScope.key}">
                        <button type="submit">
                            <i class="fa fa-search"></i> <!-- Biểu tượng kính lúp -->
                        </button>
                    </form>
                </div>
            </div>
            <div class="right">
                <c:if test="${sessionScope.account!=null}">
                    <a href="info">${sessionScope.account.username}</a>
                    <a href="show">My bag(${sessionScope.size})</a>
                    <a href="logout">Logout</a>
                </c:if>
                <c:if test="${sessionScope.account==null}">
                    <a href="login">Login</a>
                </c:if>
            </div>
        </div>
    </body> 
</html>