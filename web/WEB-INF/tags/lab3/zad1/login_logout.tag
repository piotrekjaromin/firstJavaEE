<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag import="com.lab3.zad1.dto.User" %>

<%--<jsp:useBean id="user" scope="session" class="com.lab3.zad1.dto.User"/>--%>

<%
    User user = (User) session.getAttribute("user"); %>


<c:choose>
<c:when test="${user eq null}">

    <form action="/zad3_1" method="post">
        login: <input type="text" name="login">
        password: <input type="password" name="password">
        <input type="submit">
    </form>
</c:when>
<c:otherwise>
    current user: <%=user.getLogin()%> date: <%=user.getLoginDate()%>
    <form action="/zad3_1" method="get">
        <input type="submit" value="log out">
    </form>

</c:otherwise>
</c:choose>