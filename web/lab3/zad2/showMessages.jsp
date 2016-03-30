<%@ page import="com.lab2.zad5.dto.Feedback" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: piotrek
  Date: 28.03.16
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
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
