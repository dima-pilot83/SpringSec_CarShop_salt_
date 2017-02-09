<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Diploma work</title>
    <link href="images/car.css" rel="stylesheet">
    <link href="images/register.css" rel="stylesheet">


    <script>
        function ValidateForm1(theForm)
        {
            var regexp;

            if (theForm.Editbox1.value == "")
            {
                alert("Please enter a value for the \"Login\" field.");
                theForm.Editbox1.focus();
                return false;
            }
            if (theForm.Editbox1.value.length < 1)
            {
                alert("Please enter at least 1 characters in the \"Login\" field.");
                theForm.Editbox1.focus();
                return false;
            }
            if (theForm.Editbox2.value == "")
            {
                alert("Please enter a value for the \"Password\" field.");
                theForm.Editbox2.focus();
                return false;
            }
            if (theForm.Editbox2.value.length < 1)
            {
                alert("Please enter at least 1 characters in the \"Password\" field.");
                theForm.Editbox2.focus();
                return false;
            }

            return true;
        }
    </script>

</head>
<body>
<div align="center">
    <c:url value="/newuser" var="regUrl" />
    <br /><br>
    <br /><br>
    <br /><br>
    <br /><br>
    <br /><br>

    <p><strong><h3>Please, enter your data</h3></strong></p>


 <form name="Form1" action="${regUrl}" method="POST" id="Form1" onsubmit="return ValidateForm1(this)">
     <br/> <br/>
        Login:<br/><input id="Editbox1" type="text" name="login"><br/>
        Password:<br/><input id="Editbox2" type="password" name="password"><br/>
        E-mail:<br/><input type="text" name="email"><br/>
        Phone:<br/><input type="text" name="phone"><br/>
        Name:<br/><input type="text" name="name"><br/>
        Car type :<br/><input type="text" name="carT"><br/>
        Car number:<br/><input type="text" name="carN"><br/>
     <br/> <br/>
        <input type="submit" value="Send data" />

        <c:if test="${exists ne null}">
            <p>User already exists!</p>
        </c:if>
    </form>
</div>
</body>
</html>
