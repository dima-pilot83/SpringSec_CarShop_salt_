<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<link href="images/car.css" rel="stylesheet">
<link href="images/admin.css" rel="stylesheet">
<head>
    <title>Diploma work</title>
</head>
<body>
<div id="PageHeader1" style="position:absolute;text-align:center;left:0px;top:100px;width:100%;height:70px;z-index:6;">
    <div id="PageHeader1_Container" style="width:970px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
        <div id="wb_Text1" style="position:absolute;left:14px;top:20px;width:250px;height:31px;z-index:0;text-align:left;">
            <span style="color:#000000;font-family:'Times New Roman';font-size:16px;">You are logged as:</span><span style="color:#000000;font-family:'Times New Roman';font-size:19px;">&nbsp; </span><span style="color:#0000FF;font-family:'Times New Roman';font-size:27px;"><strong>${login}</strong></span></div>


        <div id="wb_Text2" style="position:absolute;left:320px;top:20px;width:350px;height:31px;z-index:1;text-align:left;">
            <c:forEach var="s" items="${roles}">
            <span style="color:#000000;font-family:'Times New Roman';font-size:16px;">Your role is:</span><span style="color:#000000;font-family:'Times New Roman';font-size:19px;">&nbsp; </span><span style="color:#800404;font-family:'Times New Roman';font-size:27px;"><strong><c:out value="${s}" /></strong></span></div>
        </c:forEach>

        <div id="wb_Text3" style="position:absolute;left:710px;top:32px;width:109px;height:19px;z-index:2;text-align:left;">
            <span style="color:#000000;font-family:'Times New Roman';font-size:16px;">Click to logout</span></div>

        <div id="wb_TextMenu1" style="position:absolute;left:770px;top:33px;width:200px;height:18px;text-align:center;z-index:3;">
            <c:url value="/logout" var="logoutUrl" />
            <span><a href="${logoutUrl}" class="style1">LOGOUT</a></span></div>
    </div>
</div>

<a href="./viewtd" target="_blank"><img src="images/img0015.jpg" id="Banner1" alt="&#1055;&#1088;&#1086;&#1089;&#1084;&#1086;&#1090;&#1088;&#1077;&#1090;&#1100; &#1079;&#1072;&#1087;&#1080;&#1089;&#1080; &#1085;&#1072; &#1058;&#1077;&#1089;&#1090;-&#1076;&#1088;&#1072;&#1081;&#1074;" style="border-width:0;position:absolute;left:160px;top:180px;width:420px;height:90px;z-index:6;"></a>
<a href="./viewservices" target="_blank"><img src="images/img0016.jpg" id="Banner2" alt="&#1055;&#1088;&#1086;&#1089;&#1084;&#1086;&#1090;&#1088;&#1077;&#1090;&#1100;/&#1088;&#1077;&#1076;&#1072;&#1082;&#1090;&#1080;&#1088;&#1086;&#1074;&#1072;&#1090;&#1100; &#1091;&#1089;&#1083;&#1091;&#1075;&#1080; &#1058;&#1054;" style="border-width:0;position:absolute;left:650px;top:180px;width:420px;height:90px;z-index:7;"></a>
<a href="./viewcustom" target="_blank"><img src="images/img0017.jpg" id="Banner3" alt="&#1055;&#1088;&#1086;&#1089;&#1084;&#1086;&#1090;&#1088;&#1077;&#1090;&#1100; &#1089;&#1087;&#1080;&#1089;&#1086;&#1082; &#1082;&#1083;&#1080;&#1077;&#1085;&#1090;&#1086;&#1074;" style="border-width:0;position:absolute;left:160px;top:310px;width:420px;height:90px;z-index:8;"></a>
<a href="./viewtakenservices" target="_blank"><img src="images/img0020.jpg" id="Banner4" alt="&#1055;&#1088;&#1086;&#1089;&#1084;&#1086;&#1090;&#1088;&#1077;&#1090;&#1100; &#1079;&#1072;&#1087;&#1080;&#1089;&#1080; &#1085;&#1072; &#1058;&#1054;" style="border-width:0;position:absolute;left:160px;top:440px;width:420px;height:90px;z-index:9;"></a>

</body>
</html>
