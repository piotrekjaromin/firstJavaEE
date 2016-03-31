<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="randomNumber" scope="request" class="java.lang.String"/>
<jsp:useBean id="numberOfGuess" scope="request" class="java.lang.String"/>
<jsp:useBean id="result" scope="request" class="java.lang.String"/>
<html>
<head>
    <title></title>
</head>
<body>


<form action="/zad3_3" method="post">
  <input type="text" name="number">
  <input type="hidden" value="${randomNumber}" name="randomNumber">
  <input type="hidden" value="${numberOfGuess}" name="numberOfGuess">
  <input type="submit">
</form>
<c:out value="${result}"/>

</body>
</html>
