<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h4>Lista Filmow</h4>
<jsp:useBean id="movies" scope="request" class="java.util.ArrayList"/>
<table border="1">
  <tr>
    <td>Tytul</td><td>Gatunek</td><td>Rok</td><td>Dochod</td>
  </tr>

<c:forEach items='${movies}' var="movie">
  <tr>
    <td><c:out value="${movie.getTitle()}"/></td>
    <c:choose>
      <c:when test="${movie.getType() eq 'wojenny'}">
        <td bgcolor="aqua"><c:out value="${movie.getType()}"/></td>
      </c:when>
      <c:otherwise>
        <td><c:out value="${movie.getType()}"/></td>
      </c:otherwise>
    </c:choose>

    <td><c:out value="${movie.getYear()}"/></td>
    <td>
      <fmt:setLocale value="en_US"/>
      <fmt:formatNumber type="currency" value="${movie.getIncome()}"/></td>
  </tr>
</c:forEach>
</table>
</body>
</html>
