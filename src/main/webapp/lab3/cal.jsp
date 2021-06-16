<%--
  Created by IntelliJ IDEA.
  User: xulelin
  Date: 2021/6/16
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cal</title>
</head>
<body>
<form id="myForm" action="${pageContext.request.contextPath}/CalServlet" method="post">
    <table>
        <tr>
            <td> First val:</td>
            <td><input id="firstVal" type="text" name="firstVal" value="${cookie.cFirstValue.value}"></td>
            <td> Enter a name：</td>
            <td><input id="enterName" type="text" name="name" value="${cookie.cName.value}"></td>
        </tr>
        <tr>
            <td>Second val：</td>
            <td><input id="secondVal" type="text" name="secondVal" value="${cookie.cSecondValue.value}"></td>
            <td>Length：</td>
            <td><input id="length" type="text" readonly value="${cookie.cLength.value}"></td>
        </tr>
        <tr>
            <td>Result：</td>
            <td><input id="result" type="text" readonly value="${cookie.cResult.value}"></td>
            <td></td>
            <td></td>
        </tr>
    </table>
    <table>
        <tr>
            <td>  <input id="hidden" type="hidden" name="action" value="">
                <button id="add" type="button">Add</button>
                <button id="subtract" type="button">Subtract</button>
                <button id="multiply" type="button">Multiply</button>
                <button id="divide" type="button">Divide</button>
                <button id="computeLength" type="button">Compute Length</button></td>
        </tr>
        <tr>
            <td></td>
            <td> <button id="reset" type="button">Reset</button></td>
        </tr>
    </table>
</form>
<script src="../js/jquery.js"></script>
<script>
    $('#add').click(function () {
        $("#hidden").attr("value","add");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#subtract').click(function () {
        $('#hidden').attr("value","subtract");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#multiply').click(function () {
        $('#hidden').attr("value","multiply");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#divide').click(function () {
        $('#hidden').attr("value","divide");
        if(checkFormNum()){
            $('#myForm').submit();
        }
    })
    $('#computeLength').click(function () {
        $('#hidden').attr("value","computeLength");
        if(chexkFormString()){
            $('#myForm').submit();
        }
    })
    $('#reset').click(function () {
        $('#firstVal').attr("value","");
        $('#secondVal').attr("value","");
        $('#enterName').attr("value","");
        $('#length').attr("value","");
        $('#result').attr("value","");
        $('#hidden').attr("value","");
    })
    function checkFormNum() {
        if (!checkNumber($('#firstVal').val())){
            alert("First val is not a number");
            return false;
        }
        if (!checkNumber($('#secondVal').val())){
            alert("Second val is not a number");
            return false;
        }
        return true;
    }
    function chexkFormString() {
        if (checkString($('#enterName').val())){
            alert("Name is not valid");
            return false;
        }
        return true;
    }
    //验证字符串是否是数字
    function checkNumber(theObj) {
        var reg = /^[0-9]+.?[0-9]*$/;
        return reg.test(theObj);
    }
    function checkString(str) {
        var reg=/\d/;
        return reg.test(str);
    }
</script>
</body>
</html>