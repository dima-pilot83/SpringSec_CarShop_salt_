<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>Diploma work</title>
<link href="images/font-awesome.min.css" rel="stylesheet">
<link href="images/car.css" rel="stylesheet">
<link href="images/login.css" rel="stylesheet">
</head>
<body>
   <div id="space"><br></div>
   <div id="container">
      <img src="images/img0014.gif" id="Text1" alt="" style="position:absolute;left:450px;top:180px;width:520px;height:400px;z-index:9;">
      <div id="wb_Image2" style="position:absolute;left:0px;top:180px;width:441px;height:309px;z-index:11;">
         <img src="images/to.jpg" id="Image2" alt="">
      </div>
      <div id="wb_Form1" style="position:absolute;left:140px;top:590px;width:528px;height:241px;z-index:12;">

         <c:url value="/j_spring_security_check" var="loginUrl" />

         <form name="Form1" method="post" action="${loginUrl}" id="Form1">
            <input type="password" id="Editbox1" style="position:absolute;left:139px;top:122px;width:240px;height:22px;line-height:18px;z-index:3;" name="j_password" value="">
            <div id="wb_Text3" style="position:absolute;left:139px;top:102px;width:250px;height:18px;z-index:4;text-align:left;">
               <span style="color:#000000;font-family:Arial;font-size:16px;"><strong>password</strong></span></div>
            <input type="text" id="Editbox3" style="position:absolute;left:139px;top:52px;width:240px;height:22px;line-height:18px;z-index:5;" name="j_login" value="">
            <div id="wb_Text2" style="position:absolute;left:139px;top:30px;width:250px;height:19px;z-index:6;text-align:left;">
               <span style="color:#000000;font-family:Arial;font-size:16px;"><strong>login</strong></span></div>
            <input type="submit" id="Button1" name="" value="Enter" style="position:absolute;left:209px;top:176px;width:96px;height:25px;z-index:7;">
            <div id="wb_TextMenu1" style="position:absolute;left:149px;top:219px;width:200px;height:18px;text-align:center;z-index:8;">
               <span><a href="./register">Register new user</a></span></div>

         </form>
      </div>
      <c:if test="${param.error ne null}">
         <div id="wb_Text4" style="position:absolute;left:137px;top:525px;width:270px;height:15px;z-index:13;text-align:left;">
            <span style="color:#FF0000;font-family:'Times New Roman';font-size:16px;"><strong>Wrong login or password</strong></span>
         </div>


      </c:if>
      <c:if test="${param.logout ne null}">
         <div id="wb_Text5" style="position:absolute;left:136px;top:560px;width:270px;height:15px;z-index:14;text-align:left;">
            <span style="color:#3742ff;font-family:'Times New Roman';font-size:16px;"><strong>You've been logged out</strong></span>
         </div>
      </c:if>



   </div>
   <div id="PageHeader1" style="position:absolute;text-align:center;left:0px;top:100px;width:100%;height:70px;z-index:7777;">
      <div id="PageHeader1_Container" style="width:989px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
         <div id="NavigationBar1" style="position:absolute;left:114px;top:15px;width:714px;height:29px;z-index:0;">
            <ul class="navbar">
               <li><a href="./cars"><img alt="" src="images/img0011_over.gif" class="hover"><span><img alt="" src="images/img0011.gif"></span></a></li>
               <li><a href="./testdrive"><img alt="" src="images/img0012_over.gif" class="hover"><span><img alt="" src="images/img0012.gif"></span></a></li>
               <li><a href="./login"><img alt="" src="images/img0013_over.gif" class="hover"><span><img alt="" src="images/img0013.gif"></span></a></li>
            </ul>
         </div>
         <div id="wb_Image1" style="position:absolute;left:910px;top:5px;width:79px;height:59px;z-index:1;">
            <img src="images/logo.jpg" id="Image1" alt=""></div>
         <div id="wb_FontAwesomeIcon1" style="position:absolute;left:10px;top:5px;width:60px;height:60px;text-align:center;z-index:2;">
            <a href="index"><div id="FontAwesomeIcon1"><i class="fa fa-home">&nbsp;</i></div></a></div>
      </div>
   </div>
   <div id="PageFooter1" style="position:absolute;overflow:hidden;text-align:left;left:0px;top:900px;width:100%;height:100px;z-index:13;">
   </div>
</body>
</html>