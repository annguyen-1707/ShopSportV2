<%-- 
    Document   : info
    Created on : Dec 7, 2024, 10:28:10 AM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật thông tin người dùng</title>
        <title>Cập nhật thông tin người dùng</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
            }
            .container {
                max-width: 600px;
                margin: 50px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            h2 {
                text-align: center;
                font-size: 24px;
                color: #333;
                margin-bottom: 20px;
            }
            .form-group {
                margin-bottom: 20px;
            }
            .form-group label {
                display: block;
                font-weight: bold;
                color: #555;
                margin-bottom: 8px;
            }
            .form-group input {
                width: 100%;
                padding: 12px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 8px;
                box-sizing: border-box;
                transition: border 0.3s;
            }
            .form-group input:focus {
                border-color: #4CAF50;
                outline: none;
            }
            .form-group input::placeholder {
                color: #aaa;
            }
            .form-group button {
                width: 100%;
                padding: 14px;
                font-size: 16px;
                color: white;
                background-color: #4CAF50;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            .form-group button:hover {
                background-color: #45a049;
            }
            .form-group .note {
                font-size: 12px;
                color: #888;
                margin-top: 5px;
            }
            .form-group .note a {
                color: #4CAF50;
            }
        </style>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <jsp:include page="menuInfo.jsp"/>
        <div class="container">
            <c:set value="${sessionScope.account}" var="a"/>
            <h2>Cập nhật thông tin cá nhân</h2>
            <form action="info" method="post">
                <div class="form-group">
                    <label for="name">Họ tên:</label>
                    <input type="text" id="name" name="name" placeholder="Nhập họ của bạn" value="${a.name}">
                </div>
                <div class="form-group">
                    <label for="phone">Số điện thoại:</label>
                    <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại của bạn" value="${a.telephone}">
                </div>
                <div class="form-group">
                    <label for="address">Địa chỉ:</label>
                    <input type="text" id="address" name="address" placeholder="Nhập địa chỉ của bạn" value="${a.address}">
                </div>
                <div class="form-group">
                    <label for="currentPassword">Mật khẩu hiện tại (bỏ trống nếu không đổi):</label>
                    <input type="password" id="currentPassword" name="currentPassword" placeholder="Nhập mật khẩu hiện tại">
                    <p class="note">Chỉ thay đổi nếu bạn muốn cập nhật mật khẩu của mình.</p>
                </div>
                <div class="form-group">
                    <label for="newPassword">Mật khẩu mới (bỏ trống nếu không đổi):</label>
                    <input type="password" id="newPassword" name="newPassword" placeholder="Nhập mật khẩu mới">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Xác nhận mật khẩu mới:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Xác nhận mật khẩu mới">
                </div>
                <div class="form-group">
                    <button type="submit">Lưu thay đổi</button>
                </div>
                <h3 class="error-message" style="color: red">${requestScope.error}</h3>
                <h3 class="error-message" style="color: #007BFF" >${requestScope.ms}</h3>
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>