<%@ page import="com.lab2.zad5.dto.Feedback" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <title>Guests book</title>

    <script>
        function insertValue() {
            $("#nameToAppend").val($("#name").val());
            $("#mailToAppend").val($("#mail").val());
            $("#commentToAppend").val($("#comment").val());
            $("#toAppend").submit();
            return;
        }
    </script>


</head>
<body>


<form action="/zad3_2" method="POST">
   Name: <input type="text" name="name" id="name"><br>
   Mail: <input type="text" name="mail" id="mail"><br>
   Comment: <input type="text" name="comment" id="comment"><br>
    <input type="submit" value="Send Feedback">
</form>

<form action="/zad3_2_save" method="get">
    <input type="submit" value="save to file">
</form>

<form action="/zad3_2_save" method="post" id="toAppend">
    <input type="hidden" name="name" id="nameToAppend">
    <input type="hidden" name="mail" id="mailToAppend">
    <input type="hidden" name="comment" id="commentToAppend">
    <button type="button" onclick="insertValue()">add to file</button>
</form>

<%
    List<Feedback> feedbacks = (List<Feedback>) application.getAttribute("feetbacks");
    if(feedbacks != null) {
        for(Feedback feedback : feedbacks){
            out.println(feedback.getName() + " (" + feedback.getMail() + ") says:<br>");
            out.println(feedback.getComment() + "<br><br>");
        }
    }

%>



</body>
</html>

