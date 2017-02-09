<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Diploma work</title>
        <link href="images/car.css" rel="stylesheet">
        <link href="images/admin.css" rel="stylesheet">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <script>
            function ValidateForm2(theForm)
            {
                var regexp;

                if (theForm.Editbox1.value == "")
                {
                    alert("Please enter a value for the \"Service name\" field.");
                    theForm.Editbox1.focus();
                    return false;
                }
                if (theForm.Editbox1.value.length < 1)
                {
                    alert("Please enter at least 1 characters in the \"Service name\" field.");
                    theForm.Editbox1.focus();
                    return false;
                }
                if (theForm.Editbox2.value == "")
                {
                    alert("Please enter a value for the \"Price\" field.");
                    theForm.Editbox2.focus();
                    return false;
                }
                if (theForm.Editbox2.value.length < 1)
                {
                    alert("Please enter at least 1 characters in the \"Price\" field.");
                    theForm.Editbox2.focus();
                    return false;
                }

                return true;
            }
        </script>



    </head>

    <body>
    <div id="wb_Form1" >

        <form name="Form1" method="post" action="deleteservices" id="Form1">
        <div align="center">
            <br /><br>
            <br /><br>
            <br /><br>
            <p><strong><h1>Services List</h1></strong></p>


            <table class="table table-striped" id="Table1">
                <thead>
                <tr>
                    <td><b>Service name</b></td>
                    <td><b>price, USD</b></td>
                    <td><b>(delete service)</b></td>
                </tr>
                </thead>
                <c:forEach items="${vars}" var="var">
                    <tr>
                        <td>${var.name}</td>
                        <td>${var.price}</td>
                        <td><input type="checkbox" name="deleteS" value="${var.id}" id="${var.id}"/></td>
                    </tr>
                </c:forEach>



            </table>
            <input type="submit" value="Delete Service"/>
        </div>

        </form>
    </div>

    <div id="wb_Form2" >
        <form name="Form2" method="post" action="addservice" id="Form2" onsubmit="return ValidateForm2(this)">
            <div align="center">
                <p><strong><h1>_______________________________________</h1></strong></p>
                <p><strong><h1>Add new Service</h1></strong></p>
            <table class="table table-striped" id="Table2">
                <tr>
           Service name: <input type="text" id="Editbox1" name="name" value="">
            Price, USD<input type="number" id="Editbox2" name="price" value="">
                </tr>

            </table>
            <input type="submit" value="Add Service"/>


    </div>
        </form>
    </div>


    </body>
</html>