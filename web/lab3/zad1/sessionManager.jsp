<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/lab3/zad1" %>
<%@ taglib prefix="mojeZnaczniki" uri="indentationEditor" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<tag:login_logout/>
all logged-in users:<br> <tag:showUsers isAscending="false" dateColor="red"/>
currency converter: <tag:currencyConverter value="23.4" currencyIn="EUR" currencyOut="USD"/>
s<mojeZnaczniki:indentationEditor content="naglowek" align="center" color="red"/>
</body>
</html>
