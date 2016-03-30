<%@ tag import="java.util.Collections" %>
<%@ tag import="com.lab3.zad1.dto.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="isAscending" required="true" rtexprvalue="true" type="java.lang.Boolean" %>
<%@attribute name="dateColor" required="false" rtexprvalue="false" %>
<jsp:useBean id="users" scope="application" class="java.util.ArrayList"></jsp:useBean>

<%
    if(isAscending)
        Collections.sort(users, (o1, o2) -> ((User)o1).getLogin().compareTo(((User)o2).getLogin()) );
    else
        Collections.sort(users, (o1, o2) -> -((User) o1).getLogin().compareTo(((User) o2).getLogin()));
%>

<c:forEach items="${users}" var="user" >
    <c:out value="${user.getLogin()} "/><font color="${dateColor}"><c:out value="${user.getLoginDate()}"/></font><br>
</c:forEach>
