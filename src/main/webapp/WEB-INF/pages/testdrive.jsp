<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Diploma work</title>
<link href="images/cupertino/jquery-ui.min.css" rel="stylesheet">
<link href="images/font-awesome.min.css" rel="stylesheet">
<link href="images/car.css" rel="stylesheet">
<link href="images/testdrive.css" rel="stylesheet">
<script src="images/jquery-1.12.4.min.js"></script>
<script src="images/jquery.ui.core.min.js"></script>
<script src="images/jquery.ui.widget.min.js"></script>
<script src="images/jquery.ui.datepicker.min.js"></script>
<script>   
   function ValidateForm1(theForm)
   {
      var regexp;
      if (theForm.Combobox1.selectedIndex < 0)
      {
         alert("Please select one of the \"Car type\" options.");
         theForm.Combobox1.focus();
         return false;
      }
      if (theForm.Editbox1.value == "")
      {
         alert("Please enter a value for the \"Name\" field.");
         theForm.Editbox1.focus();
         return false;
      }
      if (theForm.Editbox1.value.length < 1)
      {
         alert("Please enter at least 1 characters in the \"Name\" field.");
         theForm.Editbox1.focus();
         return false;
      }
      if (theForm.Editbox2.value == "")
      {
         alert("Please enter a value for the \"Tel_number\" field.");
         theForm.Editbox2.focus();
         return false;
      }
      if (theForm.Editbox2.value.length < 1)
      {
         alert("Please enter at least 1 characters in the \"Tel_number\" field.");
         theForm.Editbox2.focus();
         return false;
      }
      if (theForm.Editbox3.value == "")
      {
         alert("Please enter a value for the \"Email\" field.");
         theForm.Editbox3.focus();
         return false;
      }
      if (theForm.Editbox3.value.length < 1)
      {
         alert("Please enter at least 1 characters in the \"Email\" field.");
         theForm.Editbox3.focus();
         return false;
      }
      return true;
   }
</script>
<script>   
   $(document).ready(function()
   {
      var jQueryDatePicker1Options =
      {
         dateFormat: 'mm/dd/yy',
         changeMonth: false,
         changeYear: false,
         showButtonPanel: false,
         showAnim: 'show'
      };
      $("#jQueryDatePicker1").datepicker(jQueryDatePicker1Options);
      $("#jQueryDatePicker1").datepicker("setDate", "new Date()");
      $("#jQueryDatePicker1").change(function()
      {
         $('#jQueryDatePicker1_input').attr('value',$(this).val());
      });
   });
</script>
</head>
<body>
   <div id="space"><br></div>
   <div id="container">
      <div id="wb_Form1" style="position:absolute;left:120px;top:200px;width:680px;height:807px;z-index:14;">
         <form name="Form1" method="post" action="newtestdrive"  id="Form1" onsubmit="return ValidateForm1(this)">
            <div id="wb_Text2" style="position:absolute;left:144px;top:60px;width:280px;height:38px;z-index:3;text-align:left;">
               <span style="color:#000000;font-family:Arial;font-size:19px;"><strong>&#1042;&#1099;&#1073;&#1077;&#1088;&#1080;&#1090;&#1077; &#1072;&#1074;&#1090;&#1086;&#1084;&#1086;&#1073;&#1080;&#1083;&#1100;</strong></span><span style="color:#000000;font-family:Arial;font-size:13px;"><br></span></div>
            <select name="carT" size="1" id="Combobox1" style="position:absolute;left:144px;top:107px;width:90px;height:28px;z-index:4;">
               <option selected="" value="X1">X1</option>
               <option value="X3">X3</option>
               <option value="X6">X6</option>
            </select>
            <div id="wb_Text3" style="position:absolute;left:144px;top:152px;width:280px;height:60px;z-index:5;text-align:left;">
               <span style="color:#000000;font-family:Arial;font-size:19px;"><strong>&#1042;&#1099;&#1073;&#1077;&#1088;&#1080;&#1090;&#1077; &#1076;&#1072;&#1090;&#1091; &#1090;&#1077;&#1089;&#1090;-&#1076;&#1088;&#1072;&#1081;&#1074;&#1072;</strong></span><span style="color:#000000;font-family:Arial;font-size:13px;"><br></span></div>
            <input id="jQueryDatePicker1_input" name="date" style="display:none" type="text" value="00/00/2017">
            <div id="jQueryDatePicker1" style="position:absolute;left:159px;top:212px;width:210px;height:180px;z-index:6;">
            </div>
            <div id="wb_Text4" style="position:absolute;left:144px;top:430px;width:250px;height:54px;z-index:7;text-align:left;">
               <span style="color:#000000;font-family:Arial;font-size:19px;"><strong>&#1050;&#1086;&#1085;&#1090;&#1072;&#1082;&#1090;&#1085;&#1072;&#1103; &#1080;&#1085;&#1092;&#1086;&#1088;&#1084;&#1072;&#1094;&#1080;&#1103;</strong></span><span style="color:#000000;font-family:Arial;font-size:13px;"><br><br>&#1048;&#1084;&#1103;</span></div>
            <input type="text" id="Editbox1" style="position:absolute;left:144px;top:504px;width:240px;height:18px;line-height:18px;z-index:8;" name="name" value="">
            <div id="wb_Text5" style="position:absolute;left:144px;top:564px;width:250px;height:16px;z-index:9;text-align:left;">
               <span style="color:#000000;font-family:Arial;font-size:13px;">&#1053;&#1086;&#1084;&#1077;&#1088; &#1090;&#1077;&#1083;&#1077;&#1092;&#1086;&#1085;&#1072;</span></div>
            <input type="text" id="Editbox2" style="position:absolute;left:144px;top:594px;width:240px;height:18px;line-height:18px;z-index:10;" name="phone" value="" placeholder="380670001122">
            <div id="wb_Text6" style="position:absolute;left:144px;top:654px;width:250px;height:16px;z-index:11;text-align:left;">
               <span style="color:#000000;font-family:Arial;font-size:13px;">&#1069;&#1083;&#1077;&#1082;&#1090;&#1088;&#1086;&#1085;&#1085;&#1099;&#1081; &#1072;&#1076;&#1088;&#1077;&#1089;</span></div>
            <input type="text" id="Editbox3" style="position:absolute;left:144px;top:684px;width:240px;height:18px;line-height:18px;z-index:12;" name="email" value="">
            <input type="submit" id="Button1" name="" value="Send data" style="position:absolute;left:269px;top:740px;width:126px;height:25px;z-index:13;">
         </form>
      </div>

      <div id="wb_Text1" style="position:absolute;left:220px;top:180px;width:383px;height:41px;z-index:16;text-align:left;">
         <span style="color:#000000;font-family:Arial;font-size:35px;"><strong><u>&#1047;&#1072;&#1087;&#1080;&#1089;&#1100; &#1085;&#1072; &#1090;&#1077;&#1089;&#1090;-&#1076;&#1088;&#1072;&#1081;&#1074;</u></strong></span>
      </div>
   </div>
   <div id="PageHeader1" style="position:absolute;text-align:center;left:0px;top:100px;width:100%;height:70px;z-index:7777;">
      <div id="PageHeader1_Container" style="width:989px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
         <div id="NavigationBar1" style="position:absolute;left:114px;top:15px;width:714px;height:29px;z-index:0;">
            <ul class="navbar">
               <li><a href="./cars"><img alt="" src="images/img0004_over.gif" class="hover"><span><img alt="" src="images/img0004.gif"></span></a></li>
               <li><a href="./testdrive"><img alt="" src="images/img0009_over.gif" class="hover"><span><img alt="" src="images/img0009.gif"></span></a></li>
               <li><a href="./login"><img alt="" src="images/img0010_over.gif" class="hover"><span><img alt="" src="images/img0010.gif"></span></a></li>
            </ul>
         </div>
         <div id="wb_Image1" style="position:absolute;left:910px;top:0px;width:79px;height:59px;z-index:1;">
            <img src="images/logo.jpg" id="Image1" alt=""></div>
         <div id="wb_FontAwesomeIcon1" style="position:absolute;left:10px;top:5px;width:60px;height:60px;text-align:center;z-index:2;">
            <a href="./index"><div id="FontAwesomeIcon1"><i class="fa fa-home">&nbsp;</i></div></a></div>
      </div>
   </div>
</body>
</html>