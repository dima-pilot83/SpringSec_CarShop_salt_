<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Diploma work</title>
</head>
<body>
<div align="center">
    <h1>Access denied for ${login}!</h1>

    <c:url value="/logout" var="logoutUrl" />
    <p>Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>
</div>

<div id="wb_Image1" style="position:absolute;left:320px;top:120px;width:600px;height:574px;z-index:1;">
    <img src="images/alert.png" id="Image1" alt="">
</div>
</body>
</html>