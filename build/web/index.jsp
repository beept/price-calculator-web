<%@page import="util.GlobalVariables"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/frmControl" var="linkServletFrmControl"/>

<c:if test="${not empty userLoggedIn}">
  <c:redirect url="formTabelaPrice.jsp"/>
</c:if>

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

    <form action="${linkServletFrmControl}" method="POST">
      <img src="images/logo.png" alt="alt"/>
      <p>
        <!--<label for="login">Login: </label>-->
        <input class="inputStyle" type="text" name="${ GlobalVariables.DEFAULT_NAME_USERNAME_PARAMETER }" value="${ recentUserName }" id="login" required placeholder="Nome de Usuario">
      </p>
      <p>
        <!--<label for="passwd">Senha: </label>-->
        <input class="inputStyle" type="password" name="${ GlobalVariables.DEFAULT_NAME_PASSWORD_PARAMETER }" value="${ recentUserPass }" id="passwd" required placeholder="Senha">
      </p>
      <input type="submit" name="loginOption" value="Login">
      <input type="submit" name="registerOption" value="Registrar">
      <c:if test="${not empty opStatus}">
        <c:choose>
          <c:when test="${opStatus == 'Cadastro efetuado!'}">
            <div class="msgBox acceptMsgColor">${ opStatus }</div>
          </c:when>
          <c:otherwise>
            <div class="msgBox rejectMsgColor">${ opStatus }</div>
          </c:otherwise>
        </c:choose>
        <c:remove var="opStatus" scope="session"/>
        <script src="scripts/removeStatusMsg.js"></script>
      </c:if>
    </form>
  </body>
</html>
