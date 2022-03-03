<%@page import="util.GlobalVariables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/frmControl" var="linkServletFrmControl"/>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/reset.css"/>
    <link rel="stylesheet" href="styles/login_style.css"/>
    <title>Login | WebTablePrice</title>
  </head>
  <body>
    <c:if test="${not empty opStatus}">
      <script>alert('${opStatus}');</script>
    </c:if>
    <form action="${linkServletFrmControl}" method="POST">
      <p>
        <label for="login">Login: </label>
        <input type="email" name="${ GlobalVariables.DEFAULT_NAME_USERNAME_PARAMETER }" value="${ recentUserName }" id="login" required placeholder="seuemail@dominio.com">
      </p>
      <p>
        <label for="passwd">Senha: </label>
        <input type="password" name="${ GlobalVariables.DEFAULT_NAME_PASSWORD_PARAMETER }" value="${ recentUserPass }" id="passwd" required placeholder="senha">
      </p>
      <input type="submit" name="loginOption" value="Login">
      <input type="submit" name="registerOption" value="Registrar">
    </form>
  </body>
</html>
