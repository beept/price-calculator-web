<%@page import="java.util.Enumeration"%>
<%@page import="util.TablePriceCalculator"%>
<%@page import="util.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  // [ ] Refatora Logica de Validacao de Sessao

  boolean logado = false;
  User usuario = (User) session.getAttribute("usuario");
  if (usuario != null) // já foi criado uma sessão
  {
    if (usuario.isValido()) {
      logado = true;
    }
  } else {
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    if (login != null && !login.isEmpty()) {
      usuario = new User(login, senha);
      if (usuario.isValido()) {
        session.setAttribute("usuario", usuario);
        logado = true;
      }
    }
  }
  if (!logado)
    response.sendRedirect(".");
%>

<%!
  boolean firstAcess;
  int quantidadeParcela;
  double valorEmprestimo;
  double juros;
  double valorParcela;
%>

<%
  try {

    valorEmprestimo = Double.parseDouble(request.getParameter("vEmp"));
    juros = Double.parseDouble(request.getParameter("vJuros"));
    quantidadeParcela = Integer.parseInt(request.getParameter("nParcela"));
    firstAcess = false;
  } catch (Exception e) {
    firstAcess = true;
  }
%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Web Price</title>
    <script src="victors_db.js"></script>
    <link rel="stylesheet" href="styles/reset.css"/>
    <link rel="stylesheet" href="styles/table_style.css"/>
  </head>
  <body>

    <form action="TabelaPrice.jsp">
      <fieldset>
        <legend>Table Price Form</legend>
        <label>Valor de emprestimo: R$ <input type="number" name="vEmp"></label>
        <label>Juros: a.m.% <input type="number" name="vJuros"></label>
        <label>Nº Parcelas: <input type="number" name="nParcela"></label>
        <input type="submit" value="Calcular">
      </fieldset>
    </form>

    <% if (!firstAcess) { %>
    <table>
      <caption>Table Price</caption>
      <thead>
        <tr>
          <th>Parcela</th>
          <th>Valor Parcela</th>
          <th>Amortização</th>
          <th>Juros</th>
          <th>Saldo Devedor</th>
        </tr>
      </thead>
      <tbody>
        <%
          valorParcela = TablePriceCalculator.calc_price(valorEmprestimo, juros, quantidadeParcela);
          TablePriceCalculator tabela = new TablePriceCalculator(valorEmprestimo, valorParcela, juros, quantidadeParcela);

          for (int i = 1; !tabela.finishedCalc(); i++) {%>
        <tr>
          <td><%=i%></td>
          <td><%=String.format("%.2f", valorParcela)%></td>
          <td><%=tabela.getAmortizacao()%></td>
          <td><%=tabela.getJuros()%></td>
          <td><%=tabela.getSaldoDevedor()%></td>
        </tr>
        <%
            tabela.nextCalc();
          }%>

        <tr>
          <td colspan="3">Total de juros pago: R$</td>
          <td><%=tabela.getTotalJuros()%></td>
          <td>TablePrice</td>
        </tr>
      </tbody>
      <tfoot></tfoot>
    </table>
    <%}%>
    <a href="logout.jsp" target="target">Sair</a>
  </body>
</html>