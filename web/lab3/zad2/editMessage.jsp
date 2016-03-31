<%@ page import="com.lab2.zad5.dto.Feedback" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="messageNumber" scope="request" class="java.lang.String"/>
<jsp:useBean id="feedbacksFromFile" scope="application" class="java.util.Vector"/>
<html>
<head>
    <title></title>
</head>
<body>
<form action="zad3_2_edit" method="post">
    <input type="text" value="<%=((Feedback)feedbacksFromFile.get(Integer.parseInt(messageNumber))).getComment()%>" name="editedMessage">
    <input type="hidden" value="${messageNumber}" name="number">
    <input type="submit">
</form>


</body>
</html>
