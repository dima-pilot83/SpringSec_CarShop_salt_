<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Diploma work</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </head>

    <body style="background-color: #D3D3D3">
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

                    <tr>
                        <td>${login}</td>
                        <td>${role}</td>
                        <td>${name}</td>
                        <td>${email}</td>
                        <td>${phone}</td>
                        <td>${carT}</td>
                        <td>${carN}</td>
                    </tr>

            </table>
        </div>

    </body>
</html>