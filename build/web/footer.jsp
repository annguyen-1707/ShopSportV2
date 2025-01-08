<%-- 
    Document   : footer
    Created on : Dec 11, 2024, 3:41:03 PM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            .footer {
                background-color: #1f1f1f;
                color: #fff;
                padding: 40px 20px;
            }

            .footer-container {
                display: flex;
                justify-content: space-between;
                flex-wrap: wrap;
            }

            .footer-section {
                flex: 1 1 200px;
                margin: 10px;
            }

            .footer-section h2 {
                font-size: 18px;
                margin-bottom: 15px;
                color: #f8c94b;
            }

            .footer-section p {
                font-size: 14px;
                line-height: 1.6;
            }

            .footer-section ul {
                list-style: none;
                padding: 0;
            }

            .footer-section ul li {
                margin-bottom: 10px;
            }

            .footer-section ul li a {
                text-decoration: none;
                color: #f8c94b;
                transition: color 0.3s;
            }

            .footer-section ul li a:hover {
                color: #fff;
            }

            .footer-section .social-links a {
                margin-right: 10px;
                font-size: 18px;
                color: #f8c94b;
                text-decoration: none;
                transition: color 0.3s;
            }

            .footer-section .social-links a:hover {
                color: #fff;
            }

            .footer-bottom {
                text-align: center;
                margin-top: 20px;
                font-size: 14px;
                border-top: 1px solid #555;
                padding-top: 10px;
            }
        </style>
    </head>
    <body>
        <footer class="footer">
            <div class="footer-container">
                <!-- Logo and Description -->
                <div class="footer-section about">
                    <h2>SportsShop</h2>
                    <p>
                        SportsShop - Nơi cung cấp các sản phẩm thể thao chất lượng cao dành cho mọi người yêu thích thể thao.
                    </p>
                </div>

                <!-- Quick Links -->
                <div class="footer-section links">
                    <h2>Liên kết nhanh</h2>
                    <ul>
                        <li><a href="home">Trang chủ</a></li>
                        <li><a href="search">Sản phẩm</a></li>
                        <li><a href="#">Liên hệ</a></li>
                    </ul>
                </div>

                <!-- Contact Info -->
                <div class="footer-section contact">
                    <h2>Liên hệ</h2>
                    <p><i class="fas fa-map-marker-alt"></i> Đường láng Hòa Lạc Hà Nội</p>
                    <p><i class="fas fa-phone"></i> +84 987 654 321</p>
                    <p><i class="fas fa-envelope"></i> support@sportsshop.vn</p>
                </div>

                <!-- Social Media Links -->
                <div class="footer-section social">
                    <h2>Kết nối với chúng tôi</h2>
                    <div class="social-links">
                    </div>
                </div>
            </div>

            <div class="footer-bottom">
                <p>&copy; 2024 SportsShop. Tất cả các quyền được bảo lưu.</p>
            </div>
        </footer>
    </body>
</html>
