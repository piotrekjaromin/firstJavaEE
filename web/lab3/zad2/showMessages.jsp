<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="feedbacks" scope="application" class="java.util.Vector"/>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:if test="${feedbacks ne null}">
  <c:forEach items="${feedbacks}" var="feedback">
    <c:out value="${feedback.getName()}"/> ( <c:out value="${feedback.getMail()}"/> ) says: <br>
    <c:out value="${feedback.getComment()}" /> <br><br>
  </c:forEach>
</c:if>
</body>
</html>
