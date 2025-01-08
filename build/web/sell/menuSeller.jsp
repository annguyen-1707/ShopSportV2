<%-- 
    Document   : menuSeller
    Created on : Dec 10, 2024, 11:43:32 PM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .navbar {
                display: flex;
                justify-content: space-around; /* Chia đều khoảng cách giữa các mục */
                align-items: center;
                background-color: #007bff; /* Màu nền xanh */
                padding: 10px 20px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                font-family: Arial, sans-serif;
            }

            .navbar a {
                color: white;
                text-decoration: none;
                font-size: 18px;
                font-weight: bold;
                padding: 10px 15px;
                border-radius: 5px;
                transition: background-color 0.3s ease, color 0.3s ease;
            }

            .navbar a:hover {
                background-color: #0056b3; /* Đổi màu nền khi hover */
                color: #f8f9fa; /* Đổi màu chữ */
            }
        </style>
    </head>
    <body>
        <div class="navbar">
            <a href="seller">Quản lý hàng</a>
            <a href="manageOrder">Quản lý đơn</a>
        </div>
    </body>
</html>
