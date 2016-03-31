<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.TreeMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<jsp:useBean id="cart" scope="session" class="java.util.TreeMap"/>

<c:import url="computerParts.xml" var="computerParts"/>
<x:parse xml="${computerParts}" var="output"/>


<table border="1">
  <tr>
    <td>id</td>
    <td>quantity</td>
    <td>remove</td>
  </tr>
  <c:forEach var="product" items="${cart}">
    <x:forEach select="$output/computer_parts/part" var="part">
      <x:set var="idXml" select="$part/@id" scope="page"/>
      <c:set var="idMap" value="id=\"${product.key}\"" scope="page"/>
      <c:if test="${idMap eq idXml}">

          <tr>
            <td><x:out select="$part/name"/></td>
            <td><c:out value="${product.value}"/></td>

          <form method="post" action="/zad3_4_remove">
            <input type="hidden" value='<c:out value="${product.key}"/>' name="id">
            <td><input type="submit" value="remove"></td>
          </form>
          </tr>
      </c:if>

  </x:forEach>
  </c:forEach>
</table>

</body>
</html>
