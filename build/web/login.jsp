<%-- 
    Document   : login
    Created on : Dec 7, 2024, 10:25:51 AM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            /* Cô lập CSS cho nội dung chính */
            .login-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                padding: 20px;
                min-height: 100vh;
                background: #ffffff;
                box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
                margin: 20px auto;
                max-width: 400px;
                border-radius: 8px;
            }

            .login-container h1 {
                color: #4CAF50;
                margin: 10px 0;
            }

            .login-container h3 {
                color: #333;
                margin: 5px 0;
            }

            .login-container h3 a {
                color: #007BFF;
                text-decoration: none;
            }

            .login-container h3 a:hover {
                text-decoration: underline;
            }

            .login-container .error-message {
                color: red;
                margin: 10px 0;
            }

            .login-container form {
                display: flex;
                flex-direction: column;
                width: 100%;
            }

            .login-container form label {
                margin: 10px 0 5px;
                font-weight: bold;
            }

            .login-container form input[type="text"],
            .login-container form input[type="password"] {
                padding: 8px;
                margin-bottom: 15px;
                border: 1px solid #ddd;
                border-radius: 4px;
                width: 100%;
            }

            /*            .login-container form input[type="checkbox"] {
                            margin-right: 8px;
                        }*/

            .login-container form input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }

            .login-container form input[type="submit"]:hover {
                background-color: #45a049;
            }

            .login-container form a {
                color: #007BFF;
                text-decoration: none;
            }

            .login-container form a:hover {
                text-decoration: underline;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f8ff;
                margin: 0;
                padding: 0;
            }
        </style>
    </head>
    <jsp:include page="menu.jsp"/>

    <body>            
        <div class="login-container">
            <h1>Login Page</h1>
            <h3>
                Bạn không có tài khoản? <a href="sign">Đăng ký</a> miễn phí<br/>
            </h3>
            <h3 class="error-message">${requestScope.ms}</h3>
            <h3 class="error-message">${requestScope.noitice}</h3>

            <form action="login" method="post">
                <label for="user">Tên đăng nhập:</label>
                <input type="text" id="user" name="user" value="${cookie.cuser.value}" placeholder="Username"/><br/>

                <label for="pass">Mật khẩu</label>
                <input type="password" id="pass" name="pass" value="${cookie.cpass.value}" placeholder="Password"/><br/>

                <div style="display: flex; align-items: center; gap: 5px;">
                    <input type="checkbox" ${(cookie.crem != null ? 'checked' : '')} name="rem" value="ON">
                    <span>Nhớ mật khẩu</span>
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="forget">Quên mật khẩu?</a><br/>

                <input type="submit" value="ĐĂNG NHẬP"/>
            </form>
        </div>
    </body>
</html>