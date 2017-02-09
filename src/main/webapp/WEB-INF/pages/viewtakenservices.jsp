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

    <form name="Form1" method="post" action="sorttakenser"  id="Form1">
        <div align="center">
            <br /><br>
            <br /><br>
            <br /><br>
            <p><strong><h1>Users List (taken services)</h1></strong></p>


            <table class="table table-striped" id="Table1">
                <thead>
                <tr>
                    <td><b>Login</b></td>
                    <td><b>Date</b></td>
                    <td><b>Service names</b></td>
                    <td><b>Total price, USD</b></td>
                </tr>
                </thead>
                <c:forEach items="${vars}" var="var">
                    <tr>
                        <td><a href="/viewcustom/${var.login}" class="style1"target="_blank">${var.login}</a></td>
                        <td>${var.date}</td>
                        <td>${var.name}</td>
                        <td>${var.price}</td>
                    </tr>
                </c:forEach>
            </table>
            Sort by
            <select name="sortBy" size="1" id="Combobox1" style="position:absolute;">
                <option value="login1">Login</option>
                <option value="date1">Date</option>
                <option value="price1">Price</option>
            </select>
            <input type="submit" id="Button1" name="" value="Sort data"style="position:absolute;left:800px">
        </div>
    </form>
    <form name="Form2" method="post" action="downloadFile/ts"  id="Form2">
        <input type="submit" id="Button2" name="" value="Download in file"style="position:absolute;left:800px">
    </form>
    </body>
</html>