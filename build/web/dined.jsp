<%-- 
    Document   : denied
    Created on : Dec 7, 2024, 10:29:09 AM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            /* General Body Styling */
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }

            /* Header Styling (Access Denied Message) */
            #h1 {
                text-align: center;
                color: #e74c3c;
                margin-top: 50px;
            }

            /* Styling for the link */
            #a {
                display: block;
                text-align: center;
                margin-top: 20px;
                font-size: 18px;
                color: #3498db;
                text-decoration: none;
            }

            #a:hover {
                text-decoration: underline;
            }

            /* Footer Styling */
            footer {
                margin-top: 200px; /* 100px space from the content */
            }
        </style>
    </head>
    <jsp:include page="menu.jsp"/>
    <body>
        <h1 id="h1">Access Denied!</h1>
        <a id="a" href="home">Come back home?</a>

        <!-- Footer included with styling applied -->
        <jsp:include page="footer.jsp"/>

    </body>
</html>