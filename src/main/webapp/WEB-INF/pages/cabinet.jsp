<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Diploma work</title>
    <meta name="generator" content="WYSIWYG Web Builder 11 Trial Version - http://www.wysiwygwebbuilder.com">
    <link href="images/car.css" rel="stylesheet">
    <link href="images/cabinet.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <link href="images/cupertino/jquery-ui.min.css" rel="stylesheet">
    <link href="images/font-awesome.min.css" rel="stylesheet">
    <script src="images/jquery-1.12.4.min.js"></script>
    <script src="images/jquery.ui.core.min.js"></script>
    <script src="images/jquery.ui.widget.min.js"></script>
    <script src="images/jquery.ui.datepicker.min.js"></script>



    <script>
        $(document).ready(function () {
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
            $("#jQueryDatePicker1").change(function () {
                $('#jQueryDatePicker1_input').attr('value', $(this).val());
            });
        });
    </script>



</head>
<body>
<div id="PageHeader1" style="position:absolute;text-align:center;left:0px;top:100px;width:100%;height:70px;z-index:6;">
    <div id="PageHeader1_Container"
         style="width:970px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
        <div id="wb_Text1"
             style="position:absolute;left:14px;top:20px;width:250px;height:31px;z-index:0;text-align:left;">
            <span style="color:#000000;font-family:'Times New Roman';font-size:16px;">You are logged as:</span><span
                style="color:#000000;font-family:'Times New Roman';font-size:19px;">&nbsp; </span><span
                style="color:#0000FF;font-family:'Times New Roman';font-size:27px;"><strong>${login}</strong></span>
        </div>


        <div id="wb_Text2"
             style="position:absolute;left:320px;top:20px;width:350px;height:31px;z-index:1;text-align:left;">
            <c:forEach var="s" items="${roles}">
            <span style="color:#000000;font-family:'Times New Roman';font-size:16px;">Your role is:</span><span
                style="color:#000000;font-family:'Times New Roman';font-size:19px;">&nbsp; </span><span
                style="color:#008000;font-family:'Times New Roman';font-size:27px;"><strong><c:out
                value="${s}"/></strong></span></div>
        </c:forEach>

        <div id="wb_Text3_1"
             style="position:absolute;left:710px;top:32px;width:109px;height:19px;z-index:2;text-align:left;">
            <span style="color:#000000;font-family:'Times New Roman';font-size:16px;">Click to logout</span></div>

        <div id="wb_TextMenu1"
             style="position:absolute;left:770px;top:33px;width:200px;height:18px;text-align:center;z-index:3;">
            <c:url value="/logout" var="logoutUrl"/>
            <span><a href="${logoutUrl}" class="style1">LOGOUT</a></span></div>

    </div>


    <c:url value="/update" var="updateUrl"/>
    <div id="wb_Form1"
         style="position:absolute;left:180px;top:100px;width:418px;height:298px;z-index:16;font-family:'Times New Roman';">
        <p><strong><h3>Update data about you</h3></strong></p>
        <form name="Form1" method="post" action="${updateUrl}" id="Form1">
            <table class="table table-striped" id="Table8" >
                <thead>
                <tr>
                    <td><b>Name</b></td>
                    <td><b>Email</b></td>
                    <td><b>Phone</b></td>
                    <td><b>Car type</b></td>
                    <td><b>Car number</b></td>
                </tr>
                </thead>
                <tr>
                    <td><input type="text" id="Editbox1" name="name" value="${name}"></td>
                    <td><input type="text" id="Editbox2" name="email" value="${email}"></td>
                    <td><input type="text" id="Editbox3" name="phone" value="${phone}"></td>
                    <td><input type="text" id="Editbox4" name="carN" value="${carN}"></td>
                    <td><input type="text" id="Editbox5" name="carT" value="${carT}"></td>
            </table>
            <input type="submit" value="Update"/>
            </tr>
        </form>
    </div>

    <div id="wb_Form2" class="container"
         style="position:absolute;left:460px;top:250px;width:418px;height:298px;z-index:16;">

        <form name="Form2" method="post" action="takeservices" id="Form2">
            <div align="center">
                <p><strong><h1>____________________</h1></strong></p>
                <p><strong><h1>Services List</h1></strong></p>


                <div id="wb_Text3">
                    <span style="color:#000000;font-family:Arial;font-size:19px;"><strong>Choose the date</strong></span><span
                        style="color:#000000;font-family:Arial;font-size:13px;"><br></span></div>
                <input id="jQueryDatePicker1_input" name="date" style="display:none" type="text" value="">
                <div id="jQueryDatePicker1">
                </div>


                <table class="table table-striped" id="Table1">
                    <thead>
                    <tr>
                        <td><b>Service name</b></td>
                        <td><b>price, USD</b></td>
                        <td><b>(choose service)</b></td>
                    </tr>
                    </thead>
                    <c:forEach items="${vars}" var="var">
                        <tr>
                            <td>${var.name}</td>
                            <td>${var.price}</td>
                            <td><input type="checkbox" name="takeS" value="${var.id}" id="${var.id}"/></td>
                        </tr>
                    </c:forEach>


                </table>
                <input type="submit" value="Choose Service"/>
            </div>

        </form>

    </div>
        <div id="wb_Form99"style="position:absolute;left:50px;top:400px;font-size:9px;">

        <p><strong><h3>My history</h3></strong></p>
        <table class="table table-bordered" id="Table33">
            <thead>
            <tr>
                <td><b>Login</b></td>
                <td><b>Date</b></td>
                <td><b>Service names</b></td>
                <td><b>Total price, USD</b></td>
            </tr>
            </thead>
            <c:forEach items="${vars2}" var="var2">
                <tr>
                    <td>${var2.login}</td>
                    <td>${var2.date}</td>
                    <td>${var2.name}</td>
                    <td>${var2.price}</td>
                </tr>
            </c:forEach>


        </table>
</div>


    <c:if test="${inputStatus == true}">
        <div id="wb_Text4" style="position:absolute;left:550px;top:260px;width:270px;height:15px;z-index:13;text-align:left;">
            <span style="color:#FF0000;font-family:'Times New Roman';font-size:16px;"><strong>Please, choose Date and Service </strong></span>
        </div>


    </c:if>






   </div>

</body>
</html>