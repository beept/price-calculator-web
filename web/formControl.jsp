<%-- 
    Document   : formControl
    Created on : 25 de fev. de 2022, 16:33:05
    Author     : Victor Rodrigues at https://github/taveirasrc
--%>

<%@page import="util.RequestData"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>

<%
  boolean registerOption = false;

  StringBuffer pName = new StringBuffer();
  Enumeration<String> pNames = request.getParameterNames();
  
  List <RequestData> requestValuesList = new ArrayList();
  
  while (pNames.hasMoreElements()) {

    pName.append(pNames.nextElement());

    if (pName.toString().equalsIgnoreCase("register-option")) {
      registerOption = true;
    } else {
      requestValuesList.add(new RequestData(pName.toString(), request.getParameter(pName.toString())));
    }
    pName.delete(0, pName.length());
  }

  session.setAttribute("user-arguments", requestValuesList);

  if (registerOption) {
    response.sendRedirect("registerUser.jsp");
  } else {
    response.sendRedirect("."); //Tabela
  }
%>