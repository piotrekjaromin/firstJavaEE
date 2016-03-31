<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="feedbacksFromFile" scope="application" class="java.util.Vector"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<c:if test="${feedbacksFromFile ne null}">
  <c:forEach items="${feedbacksFromFile}" var="feedback" varStatus="index">
    <c:out value="${feedback.getName()}"/> ( <c:out value="${feedback.getMail()}"/> ) says: <br>
    <c:out value="${feedback.getComment()}" /> <button onclick="location.href = '/zad3_2_edit?number=${index.index}'">edit</button><br><br>
  </c:forEach>
</c:if>


</body>
</html>
