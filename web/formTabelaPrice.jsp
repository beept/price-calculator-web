<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty userLoggedIn}">
  <c:redirect url="index.jsp"/>
</c:if>

<c:url value="/tabelaPrice" var="linkServletTabelaPrice"/>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Web Price</title>
    <link rel="stylesheet" href="styles/reset.css"/>
    <link rel="stylesheet" href="styles/table_style.css"/>
  </head>
  <body>
    <img src="images/logo.png" alt="alt" class="logoPosition"/>
    <form action="${linkServletTabelaPrice}">
      <fieldset>
        <!--<legend>Tabela Price</legend>-->

        <label><input type="number" step="0.01" name="vEmp" class="inputStyle" required placeholder="Valor de emprestimo: R$"></label>
        <label><input type="number" step="0.01" name="vJuros" class="inputStyle" required placeholder="Juros: a.m.%"></label>
        <label><input type="number" step="0.01" class="inputStyle" name="nParcela" required placeholder="Nº Parcelas:"></label>
        <input type="submit" value="Calcular">
      </fieldset>
    </form>

    <c:if test="${not empty tablePriceList}">
      <table>
        <!--<caption>Tabela Price</caption>-->
        <thead>
          <tr class="thead-shadow">
            <th>Parcela</th>
            <th>Valor Parcela</th>
            <th>Amortização</th>
            <th>Juros</th>
            <th>Saldo Devedor</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${tablePriceList}">
            <tr>
              <td>${item.numParcela}</td>
              <td>${item.valorParcela}</td>
              <td>${item.amortizacaoParcela}</td>
              <td>${item.juroParcela}</td>
              <td>${item.saldoDevedorParcela}</td>
            </tr>
          </c:forEach>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="3">Total de juros pago: R$</td>
            <td>${totJurosPago}</td>
            <td>GitHub: @beept</td>
          </tr>
        </tfoot>
      </table>
      <c:remove var="listaParametrosPost" scope="session"/>
    </c:if>

    <!--<a href="logout.jsp" target="target" class="logoutBtn">Sair</a>-->

    <form action="logout.jsp">
      <input type="submit" value="Sair da Conta" />
    </form>
  </body>
</html>