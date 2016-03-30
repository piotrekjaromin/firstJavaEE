<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%!
  int randomNumber() {
    return new Random().nextInt(100);
  }

  int compare(int a, int b) {
    return ((Integer)a).compareTo(b);
  }
%>

<%
  int randomNumber;
  int numberOfGuess;
  if(request.getParameter("randomNumber")==null)
    randomNumber = randomNumber();
  else
    randomNumber = Integer.parseInt(request.getParameter("randomNumber"));

  if(request.getParameter("numberOfGuess")==null)
    numberOfGuess=0;
  else
    numberOfGuess=Integer.parseInt(request.getParameter("numberOfGuess")) + 1;
%>



<form action="guessNumber.jsp" method="post">
  <input type="text" name="number">
  <input type="hidden" name="randomNumber" value="<%=randomNumber%>">
  <input type="hidden" name="numberOfGuess" value="<%=numberOfGuess%>">
  <input type="submit">
</form>

<%
  if(request.getParameter("number")!=null) {
    if (compare(Integer.parseInt(request.getParameter("number")), randomNumber) == 1)
      out.print("Twoja liczba (" + request.getParameter("number") + ") jest wieksza niz zagadka");
    else if (compare(Integer.parseInt(request.getParameter("number")), randomNumber) == -1)
      out.print("Twoja liczba (" + request.getParameter("number") + ") jest mniejsza niz zagadka");
    else out.print("Zgadles. Liczba prob: " + numberOfGuess + ". <br>Sprobuj <a href='guessNumber.jsp'> raz jeszcze</a>");
  }

%>
</body>
</html>
