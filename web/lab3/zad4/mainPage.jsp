<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:import url="computerParts.xml" var="computerParts"/>
<x:parse xml="${computerParts}" var="output"/>

<table border="1">
  <tr>
    <td>name</td>
    <td>price</td>
    <td>quantity</td>
    <td>add to cart</td>
  </tr>
<x:forEach select="$output/computer_parts/part" var="part">
  <tr>
    <td><x:out select="$part/name"/></td>
    <td><x:out select="$part/price"/></td>
    <form action="/zad3_4" method="POST">
      <input type="hidden" value='<x:out select="$part/@id"/>' name="id">
      <td><input type="text" size="6 " name="quantity"></td>
      <td><input type="submit" value="add to cart"></td>
    </form>

  </tr>
</x:forEach>
</table>

<form action="/zad3_4" method="get">
  <input type="submit" value="show cart">
</form>

</body>
</html>
