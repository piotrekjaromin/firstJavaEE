<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="users" scope="application" class="java.util.ArrayList"></jsp:useBean>

<c:forEach items="${users}" var="user" >
    <c:out value="${user}"/><br>
</c:forEach>
