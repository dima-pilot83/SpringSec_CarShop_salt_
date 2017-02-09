<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Diploma work</title>
<link href="images/car.css" rel="stylesheet">
<link href="images/index.css" rel="stylesheet">
<script src="images/jquery-1.12.4.min.js"></script>
<script src="images/wb.carousel.min.js"></script>
<script>   
   $(document).ready(function()
   {
      var Carousel1Opts =
      {
         delay: 3000,
         duration: 500,
         easing: 'linear',
         mode: 'forward-circular',
         direction: '',
         scalemode: 1,
         pagination: true,
         pagination_img_default: 'images/page_default.png',
         pagination_img_active: 'images/page_active.png',
         start: 0
      };
      $("#Carousel1").carousel(Carousel1Opts);
   });
</script>
</head>
<body>
   <div id="space"><br></div>

   <div id="PageHeader1" style="position:absolute;text-align:center;left:0px;top:100px;width:100%;height:70px;z-index:7777;">
      <div id="PageHeader1_Container" style="width:989px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
         <div id="NavigationBar1" style="position:absolute;left:114px;top:20px;width:714px;height:29px;z-index:0;">
            <ul class="navbar">
               <li><a href="./cars" target="_blank"><img alt="" src="images/img0001_over.gif" class="hover"><span><img alt="" src="images/img0001.gif"></span></a></li>
               <li><a href="./testdrive" target="_blank"><img alt="" src="images/img0002_over.gif" class="hover"><span><img alt="" src="images/img0002.gif"></span></a></li>
               <li><a href="./login" target="_blank"><img alt="" src="images/img0003_over.gif" class="hover"><span><img alt="" src="images/img0003.gif"></span></a></li>
            </ul>
         </div>
         <div id="wb_Image1" style="position:absolute;left:910px;top:5px;width:79px;height:59px;z-index:1;">
            <img src="images/logo.jpg" id="Image1" alt=""></div>
         <div id="wb_TextArt1" style="position:absolute;left:0px;top:10px;width:102px;height:32px;z-index:2;">
            <img src="images/img0018.png" id="TextArt1" alt="&#1050;&#1080;&#1077;&#1074; &#1040;&#1074;&#1090;&#1086;" title="&#1050;&#1080;&#1077;&#1074; &#1040;&#1074;&#1090;&#1086;" style="width:102px;height:32px;"></div>
      </div>
   </div>
   <div id="wb_Carousel1" style="position:absolute;left:0px;top:170px;width:989px;height:520px;z-index:8;overflow:hidden;">
      <div id="Carousel1" style="position:absolute">
         <div class="frame">
            <div id="wb_Image2" style="position:absolute;left:114px;top:45px;width:760px;height:430px;z-index:3;">
               <img src="images/1%20%284%29.jpg" id="Image2" alt=""></div>
         </div>
         <div class="frame">
            <div id="wb_Image3" style="position:absolute;left:1103px;top:16px;width:760px;height:469px;z-index:4;">
               <img src="images/3.jpg" id="Image3" alt=""></div>
         </div>
         <div class="frame">
            <div id="wb_Image4" style="position:absolute;left:2063px;top:35px;width:800px;height:450px;z-index:5;">
               <img src="images/6%20%282%29.jpg" id="Image4" alt=""></div>
         </div>
      </div>
   </div>
   <div id="PageFooter1" style="position:absolute;overflow:hidden;text-align:left;left:0px;top:850px;width:100%;height:150px;z-index:9;">
      <img src="images/img0008.gif" id="Text1" alt="" style="position:absolute;left:481px;top:0px;width:250px;height:110px;z-index:6;">
   </div>
</body>
</html>