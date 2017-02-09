<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Diploma work</title>
        <link href="images/car.css" rel="stylesheet">
        <link href="images/admin.css" rel="stylesheet">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </head>

    <body>
        <div align="center">
            <br /><br>
            <br /><br>
            <br /><br>
            <p><strong><h1>Users List</h1></strong></p>


            <table class="table table-striped" id="Table1">
                <thead>
                <tr>
                    <td><b>Login</b></td>
                    <td><b>Role</b></td>
                    <td><b>Name</b></td>
                    <td><b>E-mail</b></td>
                    <td><b>Phone</b></td>
                    <td><b>Car Type</b></td>
                    <td><b>Car Number</b></td>
                </tr>
                </thead>
                <c:forEach items="${vars}" var="var">
                    <tr>
                        <td>${var.login}</td>
                        <td>${var.role}</td>
                        <td>${var.name}</td>
                        <td>${var.email}</td>
                        <td>${var.telNumber}</td>
                        <td>${var.carType}</td>
                        <td>${var.carNumber}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>
</html>