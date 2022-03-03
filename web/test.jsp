<%--
    Document   : test
    Created on : 2 de mar. de 2022, 22:05:01
    Author     : Victor Rodrigues at https://github/taveirasrc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <ul>
      <c:forEach begin="1" end="10" step="1">
        <li>
          VICTOR
        </li>
      </c:forEach>
    </ul>
  </body>
</html>
