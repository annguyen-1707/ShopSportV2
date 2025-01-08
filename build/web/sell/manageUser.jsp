<%-- 
    Document   : manageUser
    Created on : Dec 12, 2024, 10:52:02 AM
    Author     : -Asus-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleManageOrders.css"/>
    </head>
    <jsp:include page="../menu.jsp"/>
    <jsp:include page="menuSeller.jsp"/>
    <body>
        <div class="container">
            <h1>User Management</h1>
<!--            <h3 style="color: red">${requestScope.error}</h3>-->
            <table>
                <thead>
                    <tr>
                        <th>TT</th>
                        <th>Name</th>
                        <th>User name</th>
                        <th>Telephone</th>
                        <th>Address</th>
                        <th>Role</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:set var="tt" value="0"/>
                <c:forEach var="a" items="${requestScope.adminsAll}">
                    <c:set var="tt" value="${tt + 1}"/>
                    <tr>
                        <td>${tt}</td>
                        <td>${a.name}</td>
                        <td>${a.username}</td>
                        <td>${a.telephone}</td>
                        <td>${a.address}</td>
                        <td>${a.role}</td>
                        <td>
                            <form action="manageAdmin" method="post" >
                                <input value="${a.username}" name="username" hidden=""/>
                                <button type="submit" name="action" value="edit" class="edit">Edit</button>
                                <button type="submit" name="action" value="delete" class="delete" onclick="return confirm('Are you sure you want to delete this admin?');">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>