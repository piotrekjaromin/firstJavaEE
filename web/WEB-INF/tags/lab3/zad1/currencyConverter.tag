<%@ tag import="java.util.Properties" %>
<%@ tag import="java.io.InputStream" %>
<%@ tag import="java.io.FileInputStream" %>
<%@ tag import="java.io.IOException" %>
<%@ tag import="java.nio.file.Path" %>
<%@ tag import="com.lab3.zad1.dto.User" %>
<%@attribute name="value" required="true" rtexprvalue="true" type="java.lang.Double" %>
<%@attribute name="currencyIn" required="true" rtexprvalue="false" type="java.lang.String" %>
<%@attribute name="currencyOut" required="true" rtexprvalue="false" type="java.lang.String" %>
<%!
     double convert(double value, String currencyIn, String currencyOut) {
         Properties properties = new Properties();
         InputStream input = null;
         Double result = 0.0;
         try {
             input = new FileInputStream("../../../Projects/firstJavaEE/src/resources/currency.properties");
//             input = new FileInputStream(User.class.getResource("currency.properties").getPath());
             properties.load(input);
             double currencyInValue = Double.parseDouble(properties.getProperty(currencyIn));
             double currencyOutValue = Double.parseDouble(properties.getProperty(currencyOut));
             result = value * (currencyInValue/currencyOutValue);
         } catch(IOException ex){
             ex.printStackTrace();
         } finally {
             if (input != null) {
                 try {
                     input.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }

         return (double) Math.round(result*100)/100;
     }
%>
<%=convert(value, currencyIn, currencyOut)%>